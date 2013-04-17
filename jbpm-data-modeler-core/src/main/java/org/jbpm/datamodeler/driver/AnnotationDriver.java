package org.jbpm.datamodeler.driver;


import org.jbpm.datamodeler.codegen.parser.tokens.AnnotationToken;
import org.jbpm.datamodeler.core.Annotation;
import org.jbpm.datamodeler.core.AnnotationDefinition;

public interface AnnotationDriver {

    Annotation buildAnnotation(AnnotationDefinition annotationDefinition, AnnotationToken annotationToken) throws ModelDriverException;

}
