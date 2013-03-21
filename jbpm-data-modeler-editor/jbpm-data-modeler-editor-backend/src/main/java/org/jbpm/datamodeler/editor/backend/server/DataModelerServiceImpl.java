package org.jbpm.datamodeler.editor.backend.server;

import org.drools.compiler.lang.descr.QueryDescr;
import org.jboss.errai.bus.server.annotations.Service;
import org.jbpm.datamodeler.codegen.GenerationContext;
import org.jbpm.datamodeler.codegen.GenerationEngine;
import org.jbpm.datamodeler.codegen.GenerationListener;
import org.jbpm.datamodeler.codegen.parser.DataModelParser;
import org.jbpm.datamodeler.codegen.parser.DataObjectPropertyToken;
import org.jbpm.datamodeler.codegen.parser.DataObjectToken;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.PropertyType;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.jbpm.datamodeler.core.impl.PropertyTypeFactoryImpl;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.jbpm.datamodeler.editor.service.ServiceException;
import org.jbpm.datamodeler.xml.SerializerException;
import org.jbpm.datamodeler.xml.XMLSerializer;
import org.jbpm.datamodeler.xml.impl.XMLSerializerImpl;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.file.Files;
import org.kie.guvnor.project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uberfire.backend.server.util.Paths;
import org.uberfire.backend.vfs.Path;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
@ApplicationScoped
public class DataModelerServiceImpl implements DataModelerService {

    private static final Logger logger = LoggerFactory.getLogger(DataModelerServiceImpl.class);

    private static final String MAIN_JAVA_PATH = "src/main/java";
    private static final String MAIN_RESOURCES_PATH = "src/main/resources";
    private static final String TEST_JAVA_PATH        = "src/test/java";
    private static final String TEST_RESOURCES_PATH   = "src/test/resources";

    private static final String DEFAULT_GUVNOR_PKG = "defaultpkg";

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

        if (logger.isDebugEnabled()) logger.debug("Reading data model from path: " + path);

        DataModel dataModel = null;
        try {

            final String content = ioService.readAllString( paths.convert( path ) );
            if (logger.isDebugEnabled()) logger.debug("The file content is: \n" + content);

            XMLSerializer serializer = new XMLSerializerImpl();
            dataModel = serializer.deserialize(content);

            String defaultPackageName = calculateDefaultPackageName(path);
            DataModelTO dataModelTO = DataModelHelper.domain2To(dataModel);
            dataModelTO.setDefaultPackage(defaultPackageName);

            return dataModelTO;

        } catch (SerializerException e) {
            logger.error("Data model couldn't be deserialized from file due to the following errors. path: " + path, e);
            throw new ServiceException("Data model: " + path + ", couldn't be loaded due to the following error. " + e);
        }
    }

    @Override
    public void saveModel(DataModelTO dataModel, Path path) {

        //TODO provide final implementation
        try {

            if (logger.isDebugEnabled()) logger.debug("Saving data model: " + dataModel.getName() + " into path: " + path);

            //convert to the domain model
            DataModel dataModelDomain = DataModelHelper.to2Domain(dataModel);

            XMLSerializer serializer = new XMLSerializerImpl();
            String content = serializer.serialize(dataModelDomain);

            if (logger.isDebugEnabled()) logger.debug("Data model was serialized to: \n" + content);
            //Write the serialized model to the file
            ioService.write(paths.convert(path), content);

        } catch (Exception e) {
            //TODO propagate the proper exception to client
            logger.error("The following error was produced during data model saving", e);
        }
    }

    @Override
    public void generateModel(DataModelTO dataModel, final Path path) {
        
        try {
            //convert to domain model
            DataModel dataModelDomain = DataModelHelper.to2Domain(dataModel);

            //get the path to project root directory (the main pom.xml directory) and calculate
            //the java sources path
            Path projectPath = projectService.resolveProject(path);
            org.kie.commons.java.nio.file.Path output = ensureProjectJavaPath(paths.convert(projectPath));

            GenerationContext generationContext = new GenerationContext(dataModelDomain);
            ServiceGenerationListener generationListener = new ServiceGenerationListener(output);
            generationContext.setGenerationListener(generationListener);

            //This output path is only for testing purposes, TODO REMOVE IT!
            generationContext.setOutputPath("/tmp");

            
            GenerationEngine generationEngine = GenerationEngine.getInstance();
            generationEngine.generate(generationContext);

        } catch (Exception e) {
            logger.error("An error was produced during data model generation, dataModel: " + dataModel + ", path: " + path, e);
            throw new ServiceException("Data model: " + dataModel.getName() + ", couldn't be generated due to the following error. " + e);
        }
    }

    @Override
    public Path createModel(Path context, String fileName) {

        //TODO provide error handling, what happens if the file creation fails.

        if (logger.isDebugEnabled()) logger.debug("Creating data model with the following parameters, path: " + context + ", fileName: " + fileName);

        //kie path to store the created file.
        org.kie.commons.java.nio.file.Path kiePath = paths.convert( context ).resolve( fileName );

        //create a default empty model.
        DataModel dataModel = ModelFactoryImpl.getInstance().newModel(fileName);
        
        XMLSerializer serializer = new XMLSerializerImpl();
        String serializedModel;
        
        try {
            serializedModel = serializer.serialize(dataModel);

            ioService.createFile(kiePath);

            ioService.write(kiePath, serializedModel);

            Path path = paths.convert(kiePath, false);
            return path;
            
        } catch (SerializerException e) {
            logger.error("The following error was produced during data model creation.", e);
        }

        return null;
    }

    public List<PropertyTypeTO> getBasePropertyTypes() {
        List<PropertyTypeTO> types = new ArrayList<PropertyTypeTO>();
        
        for (PropertyType baseType : PropertyTypeFactoryImpl.getInstance().getBasePropertyTypes()) {
            types.add(new PropertyTypeTO(baseType.getName(), baseType.getClassName()));
        }
        return types;
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

    /**
     * Update the model from the generated pojos in order to add manually changes in java sources to the model.
     *
     * @param dataModel
     */
    private void updateModel(DataModel dataModel, org.kie.commons.java.nio.file.Path projectPath) {

        //check if the java dir exists

        org.kie.commons.java.nio.file.Path javaPath = existsProjectJavaPath(projectPath);
        if (javaPath != null) {
            //It's ok to try to update the model from pojos.
            //Iterate the dataObjects list.
            for (DataObject dataObject : dataModel.getDataObjects()) {
                updateDataObject(dataObject, javaPath);
            }
        }
    }

    private void updateDataObject(DataObject dataObject, org.kie.commons.java.nio.file.Path javaPath) {

        //TODO implement errors handling
        org.kie.commons.java.nio.file.Path javaFilePath = calculateFilePath(dataObject, javaPath);
        if (ioService.exists(javaFilePath)) {
            //ok, the pojo is there
            String fileContent = ioService.readAllString(javaFilePath);
            DataModelParser parser = null;
            DataObjectToken token = null;

            try {
                parser = new DataModelParser(fileContent);
                token = parser.parse();
                updateDataObject(dataObject, token);
            } catch (Exception e) {
                // :(
                e.printStackTrace();
            }
        }
    }

    private void updateDataObject(DataObject dataObject, DataObjectToken token) {
        //TODO provide final implementation.
        //current implementation add all to properties to the data object
        List<DataObjectPropertyToken> propertyTokens = token.getProperties();
        for (DataObjectPropertyToken propertyToken : propertyTokens) {
            dataObject.addProperty(propertyToken.getName(), propertyToken.getType());
        }
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
        final org.kie.commons.java.nio.file.Path srcResourcesPath = paths.convert( projectRoot ).resolve(MAIN_RESOURCES_PATH);
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

    private org.kie.commons.java.nio.file.Path existsProjectJavaPath(org.kie.commons.java.nio.file.Path projectPath) {
        org.kie.commons.java.nio.file.Path javaPath = projectPath.resolve("src").resolve("main").resolve("java");
        if (ioService.exists(javaPath)) {
            return javaPath;
        }
        return null;
    }

    private org.kie.commons.java.nio.file.Path ensureProjectJavaPath(org.kie.commons.java.nio.file.Path projectPath) {
        org.kie.commons.java.nio.file.Path javaPath = projectPath.resolve("src");
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

    /**
     * Given a data object calculates the path to the java file allocating the corresponding pojo.
     *
     * @param dataObject
     *
     * @param javaPath Java sources root.
     *
     * @return
     */
    private org.kie.commons.java.nio.file.Path calculateFilePath(DataObject dataObject, org.kie.commons.java.nio.file.Path javaPath) {
        String packageName = dataObject.getPackageName();
        org.kie.commons.java.nio.file.Path filePath = javaPath;

        if (packageName != null && !"".equals(packageName)) {
            StringTokenizer packageTokens = new StringTokenizer(packageName, ".");
            while (packageTokens.hasMoreElements()) {
                filePath = filePath.resolve(packageTokens.nextToken());
            }
        }
        filePath = filePath.resolve(dataObject.getName() + ".java");
        return filePath;
    }

    private String calculateDefaultPackageName(Path resourceFilePath) {
        String packageName = null;

        packageName = projectService.resolvePackageName(resourceFilePath);

        if (packageName == null || DEFAULT_GUVNOR_PKG.equals(packageName)) {
            return "";
        } else {
            return packageName;
        }
    }
}