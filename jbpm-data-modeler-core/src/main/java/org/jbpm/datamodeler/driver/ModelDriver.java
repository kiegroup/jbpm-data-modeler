package org.jbpm.datamodeler.driver;


import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.DataModel;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.Path;

import java.util.Collection;
import java.util.List;

public interface ModelDriver {

    List<AnnotationDefinition> getConfiguredAnnotations();

    AnnotationDefinition getConfiguredAnnotation(String annotationName);

    AnnotationDriver getAnnotationDriver(String annotationName);

    DataModel loadModel(IOService ioService, Collection<Path> rootPaths, boolean recursiveScan) throws IOException;

    void generateModel(IOService ioService, Path root) throws IOException;

    DataModel createModel();
}
