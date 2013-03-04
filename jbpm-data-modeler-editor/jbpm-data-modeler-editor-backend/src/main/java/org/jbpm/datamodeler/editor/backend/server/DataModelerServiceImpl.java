package org.jbpm.datamodeler.editor.backend.server;

import org.jboss.errai.bus.server.annotations.Service;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.editor.backend.server.DataModelHelper;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.jbpm.datamodeler.impexp.codegen.GenerationContext;
import org.jbpm.datamodeler.impexp.codegen.GenerationEngine;
import org.jbpm.datamodeler.impexp.codegen.GenerationListener;
import org.kie.commons.java.nio.file.OpenOption;
import org.kie.commons.java.nio.file.StandardOpenOption;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.server.util.Paths;

import org.kie.commons.io.IOService;
import org.uberfire.backend.vfs.PathFactory;

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

    @Inject
    @Named("ioStrategy")
    IOService ioService;

    @Inject
    private Paths paths;

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
        DataModelTO dataModel = new DataModelTO("TestModel");
        List<DataObjectTO> dataObjects = new ArrayList<DataObjectTO>();
        for (int i=0; i< 10 ; i++) {
            dataObjects.add(new DataObjectTO(i));
        }
        dataModel.setDataObjects(dataObjects);

        return dataModel;
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

            //calculate the project/src/main directory
            org.kie.commons.java.nio.file.Path mainPath = getProjectMainPath(path);
            org.kie.commons.java.nio.file.Path output = ensureProjectJavaPath(mainPath);


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

    private org.kie.commons.java.nio.file.Path getProjectMainPath(Path path) {
        //complete path to the file.
        org.kie.commons.java.nio.file.Path currentDir = paths.convert(path);

        boolean srcFound = false;

        while (!srcFound && (currentDir = currentDir.getParent()) != null) {
            srcFound = currentDir.getFileName().endsWith("main");
        }
        return currentDir;
    }

    private org.kie.commons.java.nio.file.Path ensureProjectJavaPath(org.kie.commons.java.nio.file.Path mainPath) {
        org.kie.commons.java.nio.file.Path javaPath = mainPath.resolve("java");
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