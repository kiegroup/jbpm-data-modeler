package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.codegen.parser.DataModelParser;
import org.jbpm.datamodeler.commons.file.FileScanner;
import org.jbpm.datamodeler.commons.file.ScanResult;
import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.impl.DataModelImpl;
import org.jbpm.datamodeler.driver.AnnotationDriver;
import org.jbpm.datamodeler.driver.ModelDriver;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class PojoDriver implements ModelDriver {

    private static final Logger logger = LoggerFactory.getLogger(PojoDriver.class);

    private final Map<String, AnnotationDefinition> configuredAnnotations = new HashMap<String, AnnotationDefinition>();
    
    private final Map<String, AnnotationDriver> configuredAnnotationsDriver = new HashMap<String, AnnotationDriver>();

    public PojoDriver() {
        AnnotationDefinition annotationDefinition;

        annotationDefinition = new DataObjectAnnotationDefinition();
        configuredAnnotations.put(annotationDefinition.getName(), annotationDefinition);
        configuredAnnotationsDriver.put(annotationDefinition.getName(), new DefaultAnnotationDriver());

        annotationDefinition = new EqualsAnnotationDefinition();
        configuredAnnotations.put(annotationDefinition.getName(), annotationDefinition);
        configuredAnnotationsDriver.put(annotationDefinition.getName(), new DefaultAnnotationDriver());

        annotationDefinition = new RequiredAnnotationDefinition();
        configuredAnnotations.put(annotationDefinition.getName(), annotationDefinition);
        configuredAnnotationsDriver.put(annotationDefinition.getName(), new DefaultAnnotationDriver());

    }

    @Override
    public DataModel loadModel(IOService ioService, Collection<Path> rootPaths, boolean recursiveScan) throws IOException {

        FileScanner fileScanner = new FileScanner();
        DataModelParser modelParser;
        DataModel dataModel;
        String fileContent;

        dataModel = createModel();

        Collection<ScanResult> scanResults = fileScanner.scan(ioService, rootPaths, ".java", true);
        if (scanResults != null) {
            for (ScanResult scanResult : scanResults) {

                fileContent = ioService.readAllString(scanResult.getFile());
                try {
                    modelParser = new DataModelParser(fileContent);
                    modelParser.parse();
                } catch (Exception e) {
                    logger.error("An error was produced during file parsing: " + scanResult.getFile());
                    throw new IOException(e);
                }


            }
        }


                

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void generateModel(IOService ioService, Path root) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<AnnotationDefinition> getConfiguredAnnotations() {
        List<AnnotationDefinition> result = new ArrayList<AnnotationDefinition>();
        result.addAll(configuredAnnotations.values());
        return result;
    }

    @Override
    public AnnotationDefinition getConfiguredAnnotation(String annotationName) {
        return configuredAnnotations.get(annotationName);
    }

    @Override
    public AnnotationDriver getAnnotationDriver(String annotationName) {
        return configuredAnnotationsDriver.get(annotationName);
    }

    @Override
    public DataModel createModel() {
        return new DataModelImpl(null, null);
    }
}
