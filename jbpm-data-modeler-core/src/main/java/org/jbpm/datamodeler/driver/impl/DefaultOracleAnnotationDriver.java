/**
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
