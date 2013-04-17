package org.jbpm.datamodeler.driver;


import org.jbpm.datamodeler.codegen.parser.tokens.AnnotationToken;
import org.jbpm.datamodeler.codegen.parser.tokens.DataObjectPropertyToken;
import org.jbpm.datamodeler.codegen.parser.tokens.DataObjectToken;
import org.jbpm.datamodeler.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DataObjectBuilder {
    
    Logger logger = LoggerFactory.getLogger(DataObjectBuilder.class);

    ModelDriver modelDriver;

    public DataObjectBuilder(ModelDriver modelDriver) {
        this.modelDriver = modelDriver;
    }

    /**
     *  Knows how to create a DataObject from the parsed token.
     */
    public DataObject buildDataObject(DataModel dataModel, DataObjectToken dataObjectToken) throws ModelDriverException {
        
        //TODO add validations
        DataObject dataObject = dataModel.addDataObject(dataObjectToken.getClassName());
        dataObject.setSuperClassName(dataObjectToken.getSuperClassName());

        List<DataObjectPropertyToken> properties = dataObjectToken.getProperties();
        if (properties != null) {
            for (DataObjectPropertyToken property : properties) {
                buildProperty(dataObject, property);
            }
        }

        return dataObject;
    }
    
    private ObjectProperty buildProperty(DataObject dataObject, DataObjectPropertyToken propertyToken) throws ModelDriverException {
        ObjectProperty property = dataObject.addProperty(propertyToken.getName(), propertyToken.getType());
        addPropertyAnnotations(property, propertyToken.getAnnotations());
        return property;
    }

    private void addPropertyAnnotations(ObjectProperty property, List<AnnotationToken> annotationTokens) throws ModelDriverException {
        AnnotationDriver annotationDriver;
        AnnotationDefinition annotationDefinition;
        Annotation annotation;
                
        if (annotationTokens != null) {
            for(AnnotationToken annotationToken : annotationTokens) {
                //1) check if the given annotation is recognized by current configuration.
                //2) add the annotation to the data object property
                annotationDefinition = modelDriver.getConfiguredAnnotation(annotationToken.getName());
                if (annotationDefinition == null) {
                    logger.error("Annotation definition could'n be found for annotation: " + annotationToken.getName());
                    throw new ModelDriverException("Annotation definition could'n be found for annotation: " + annotationToken.getName());
                }

                annotationDriver = modelDriver.getAnnotationDriver(annotationToken.getName());
                if (annotationDriver == null) {
                    logger.error("Annotation driver could'n be found for annotation: " + annotationToken.getName());
                    throw new ModelDriverException("Annotation driver could'n be found for annotation: " + annotationToken.getName());
                }

                annotation = annotationDriver.buildAnnotation(annotationDefinition, annotationToken);
                property.addAnnotation(annotation);
            }
        }
    }


    public void addDataObjectAnnotations() {
        
    }
    
    
}
