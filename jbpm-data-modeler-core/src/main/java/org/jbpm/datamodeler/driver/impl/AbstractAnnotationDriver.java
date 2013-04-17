package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.codegen.parser.tokens.AnnotationToken;
import org.jbpm.datamodeler.codegen.parser.tokens.AnnotationValuePairToken;
import org.jbpm.datamodeler.codegen.parser.tokens.TokenList;
import org.jbpm.datamodeler.core.Annotation;
import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationImpl;
import org.jbpm.datamodeler.driver.AnnotationDriver;
import org.jbpm.datamodeler.driver.ModelDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractAnnotationDriver implements AnnotationDriver {

    private static final Logger logger = LoggerFactory.getLogger(AbstractAnnotationDriver.class);

    @Override
    public Annotation buildAnnotation(AnnotationDefinition annotationDefinition, AnnotationToken annotationToken) throws ModelDriverException {

        if (!annotationDefinition.getName().equals(normalizeAnnotationName(annotationToken.getName()))) {
            //TODO review this policy, maybe in the future we use a less restrictive system. E.g. if a token cant be
            //recognized by the driver we can create a generic annotation.
            //The same applies for annotation members.
            logger.debug("Annotation definition: " + annotationDefinition.getName() + " is not suited for this token: + " + annotationToken.getName());
            throw new ModelDriverException("Annotation definition: " + annotationDefinition.getName() + " is not suited for this token: + " + annotationToken.getName(), null);
        }

        Annotation annotation = new AnnotationImpl(annotationDefinition);
        TokenList<AnnotationValuePairToken> valuePairTokens = annotationToken.getValuePairs();
        if (valuePairTokens != null) {
            for (AnnotationValuePairToken valuePairToken : valuePairTokens) {
                if (annotationDefinition.hasMember(valuePairToken.getName())) {
                    annotation.setValue(valuePairToken.getName(), convertValue(valuePairToken.getValue()));
                } else {
                    //TODO review this policy, another option could be to skip invalid tokens.
                    logger.debug("Annotation member: " + valuePairToken.getName() + " is not present for the annotation: " +  annotationDefinition.getName());
                    throw new ModelDriverException("Annotation member: " + valuePairToken.getName() + " is not present for the annotation: " +  annotationDefinition.getName(), null);
                }
            }
        }
        return annotation;
    }
    
    protected abstract Object convertValue(String tokenValue) throws ModelDriverException;

    public String normalizeAnnotationName(String name) {
        return "@"+name;
        
    }

}
