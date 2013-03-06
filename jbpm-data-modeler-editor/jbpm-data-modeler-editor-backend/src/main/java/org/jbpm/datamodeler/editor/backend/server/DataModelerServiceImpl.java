package org.jbpm.datamodeler.editor.backend.server;

import org.jboss.errai.bus.server.annotations.Service;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.jbpm.datamodeler.impexp.codegen.GenerationContext;
import org.jbpm.datamodeler.impexp.codegen.GenerationEngine;
import org.jbpm.datamodeler.impexp.codegen.GenerationListener;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.file.Files;
import org.kie.guvnor.project.service.ProjectService;
import org.uberfire.backend.server.util.Paths;
import org.uberfire.backend.vfs.Path;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Service
@ApplicationScoped
public class DataModelerServiceImpl implements DataModelerService {

    private static final String SOURCE_JAVA_PATH      = "src/main/java";
    private static final String SOURCE_RESOURCES_PATH = "src/main/resources";
    private static final String TEST_JAVA_PATH        = "src/test/java";
    private static final String TEST_RESOURCES_PATH   = "src/test/resources";

    @Inject
    @Named("ioStrategy")
    IOService ioService;

    @Inject
    private Paths paths;

    @Inject
    private ProjectService projectService;

    public DataModelerServiceImpl() {
    }

    @Override
    public DataModelTO loadModel(Path path) {
        System.out.println("read this path: " + path);

        try {

            final String content = ioService.readAllString( paths.convert( path ) );

            System.out.println("the file content is: " + content);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO: implement the correct model loading
        
        DataModelTO dataModel = new DataModelTO(path.getFileName());
        List<DataObjectTO> dataObjects = new ArrayList<DataObjectTO>();
        for (int i=0; i< 10 ; i++) {
            dataObjects.add(new DataObjectTO(i));
        }
        dataModel.setDataObjects(dataObjects);

        return dataModel;
    }

    public Path resolveResourcePackage(final Path resource) {

        //TODO this method should be moved to the ProjectService class
        //Null resource paths cannot resolve to a Project
        if ( resource == null ) {
            return null;
        }

        //If Path is not within a Project we cannot resolve a package
        final Path projectRoot = projectService.resolveProject(resource);
        if ( projectRoot == null ) {
            return null;
        }

        //The Path must be within a Project's src/main/resources or src/test/resources path
        boolean resolved = false;
        org.kie.commons.java.nio.file.Path path = paths.convert( resource ).normalize();
        final org.kie.commons.java.nio.file.Path srcResourcesPath = paths.convert( projectRoot ).resolve( SOURCE_RESOURCES_PATH );
        final org.kie.commons.java.nio.file.Path testResourcesPath = paths.convert( projectRoot ).resolve( TEST_RESOURCES_PATH );

        if ( path.startsWith( srcResourcesPath ) ) {
            resolved = true;
        } else if ( path.startsWith( testResourcesPath ) ) {
            resolved = true;
        }
        if ( !resolved ) {
            return null;
        }

        //If the Path is already a folder simply return it
        if ( Files.isDirectory(path) ) {
            return resource;
        }

        path = path.getParent();

        return paths.convert( path );
    }

    @Override
    public void saveModel(DataModelTO dataModel, Path path) {

        try {

            String content = ioService.readAllString( paths.convert( path ) );

            content = content + " - file was saved at: " + new Date();
            ioService.write(paths.convert(path), content);

            //convert to the domain model
            DataModel dataModelDomain = DataModelHelper.to2Domain(dataModel);

            GenerationContext generationContext = new GenerationContext(dataModelDomain);
            generationContext.addTemplateSet("POJOS");
            generationContext.setOutputPath("/tmp");
            generationContext.setPackageName("org.jboss.test");

            //get the route to the root directory. (the main pom.xml directory)
            Path projectPath = projectService.resolveProject(path);
            org.kie.commons.java.nio.file.Path output = ensureProjectJavaPath(paths.convert(projectPath));

            GenerationEngine generationEngine = GenerationEngine.getInstance();
            ServiceGenerationListener generationListener = new ServiceGenerationListener(output);
            generationEngine.setGenerationListener(generationListener);
            generationEngine.init();
            generationEngine.generateAllTemplates(generationContext);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public class ServiceGenerationListener implements GenerationListener {

        org.kie.commons.java.nio.file.Path output;

        public ServiceGenerationListener(org.kie.commons.java.nio.file.Path output) {
            this.output = output;
        }

        @Override
        public void assetGenerated(String fileName, String content) {

            String subDir;
            org.kie.commons.java.nio.file.Path subDirPath;
            org.kie.commons.java.nio.file.Path destFilePath;
            StringTokenizer dirNames;

            subDirPath = output;
            int index = fileName.lastIndexOf("/");
            if (index == 0) {
                //the file names was provided in the form /SomeFile.java
                fileName = fileName.substring(1, fileName.length());
            } else if (index > 0) {
                //the file name was provided in the most common form /dir1/dir2/SomeFile.java
                String dirNamesPath = fileName.substring(0, index);
                fileName = fileName.substring(index+1, fileName.length());
                dirNames = new StringTokenizer(dirNamesPath, "/");
                while (dirNames.hasMoreElements()) {
                    subDir = dirNames.nextToken();
                    subDirPath = subDirPath.resolve(subDir);
                    if (!ioService.exists(subDirPath)) {
                        ioService.createDirectory(subDirPath);
                    }
                }
            }

            //the last subDirPath is the directory to crate the file.
            destFilePath = subDirPath.resolve(fileName);
            ioService.write(destFilePath, content);
        }
    }

    private org.kie.commons.java.nio.file.Path ensureProjectJavaPath(org.kie.commons.java.nio.file.Path mainPath) {
        org.kie.commons.java.nio.file.Path javaPath = mainPath.resolve("src");
        if (!ioService.exists(javaPath)) {
            javaPath = ioService.createDirectory(javaPath);
        }
        javaPath = javaPath.resolve("main");
        if (!ioService.exists(javaPath)) {
            javaPath = ioService.createDirectory(javaPath);
        }
        javaPath = javaPath.resolve("java");
        if (!ioService.exists(javaPath)) {
            javaPath = ioService.createDirectory(javaPath);
        }

        return javaPath;
    }

    @Override
    public Path createModel(Path context, String fileName) {

        org.kie.commons.java.nio.file.Path kiePath = paths.convert( context ).resolve( fileName );

        //create the file to support the model
        //TODO implement the "DataModelBuilder" that creates the empty model xml file
        ioService.createFile(kiePath);
        
        ioService.write(kiePath, "The file was created at: " + new Date());

        final Path path = paths.convert(kiePath, false);

        return path;
    }
}