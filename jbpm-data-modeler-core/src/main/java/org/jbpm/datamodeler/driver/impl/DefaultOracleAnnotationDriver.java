package org.jbpm.datamodeler.driver.impl;


import org.jbpm.datamodeler.core.Annotation;
import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.AnnotationMemberDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationImpl;
import org.jbpm.datamodeler.driver.AnnotationDriver;
import org.jbpm.datamodeler.driver.ModelDriverException;

public class DefaultOracleAnnotationDriver implements AnnotationDriver {

    @Override
    public Annotation buildAnnotation(AnnotationDefinition annotationDefinition, Object annotationToken) throws ModelDriverException {

        org.kie.guvnor.datamodel.model.Annotation oracleAnnotationToken = (org.kie.guvnor.datamodel.model.Annotation)annotationToken;
        AnnotationImpl annotation = new AnnotationImpl(annotationDefinition);
        if (annotationDefinition.isMarker()) {
            return annotation;
        } else if (oracleAnnotationToken.getAttributes() != null) {
            String currentAttributeValue;
            for (AnnotationMemberDefinition annotationMember : annotationDefinition.getAnnotationMembers()) {
                currentAttributeValue = oracleAnnotationToken.getAttributes().get(annotationMember.getName());
                if (currentAttributeValue != null) {
                    annotation.setValue(annotationMember.getName(), currentAttributeValue);
                }
            }
        }

        return annotation;
    }
}
