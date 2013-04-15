package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.Annotation;
import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.impl.AnnotationImpl;
import org.jbpm.datamodeler.driver.ModelDriver;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.Path;

import java.util.*;


public class PojoDriver implements ModelDriver {

    @Override
    public DataModel loadModel(IOService ioService, Collection<Path> rootPaths, boolean recursiveScan) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void generateModel(IOService ioService, Path root) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<AnnotationDefinition> getConfiguredAttributes() {
        List<AnnotationDefinition> list = new ArrayList<AnnotationDefinition> ();
        list.add(new EqualsAnnotationDefinition());
        list.add(new RequiredAnnotationDefinition());

        return list;
    }

    @Override
    public Annotation newAttribute(AnnotationDefinition annotationDefinition) {
        //check if the definition is valid for this driver
        return new AnnotationImpl(annotationDefinition);
    }
}
