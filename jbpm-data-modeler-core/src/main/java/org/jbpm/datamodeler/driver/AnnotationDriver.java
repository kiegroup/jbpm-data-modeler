package org.jbpm.datamodeler.driver;


import org.jbpm.datamodeler.core.Annotation;
import org.jbpm.datamodeler.core.AnnotationDefinition;

public interface AnnotationDriver {

    Annotation buildAnnotation(AnnotationDefinition annotationDefinition, Object annotationToken) throws ModelDriverException;

}
