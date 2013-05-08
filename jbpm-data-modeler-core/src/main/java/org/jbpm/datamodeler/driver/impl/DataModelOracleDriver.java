package org.jbpm.datamodeler.driver.impl;


import org.jbpm.datamodeler.commons.NamingUtils;
import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.ObjectProperty;
import org.jbpm.datamodeler.core.impl.DataModelImpl;
import org.jbpm.datamodeler.driver.AnnotationDriver;
import org.jbpm.datamodeler.driver.ModelDriver;
import org.jbpm.datamodeler.driver.ModelDriverException;
import org.jbpm.datamodeler.driver.impl.annotations.*;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.Path;
import org.kie.guvnor.datamodel.model.Annotation;
import org.kie.guvnor.datamodel.model.ModelField;
import org.kie.guvnor.datamodel.oracle.ProjectDataModelOracle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DataModelOracleDriver implements ModelDriver {
    
    private static final Logger logger = LoggerFactory.getLogger(DataModelOracleDriver.class);

    private List<AnnotationDefinition> configuredAnnotations = new ArrayList<AnnotationDefinition>();

    private Map<String, AnnotationDriver> annotationDrivers = new HashMap<String, AnnotationDriver>();

    public DataModelOracleDriver() {
        AnnotationDefinition annotationDefinition = DescriptionAnnotationDefinition.getInstance();
        configuredAnnotations.add(annotationDefinition);
        annotationDrivers.put(annotationDefinition.getClassName(), new DefaultOracleAnnotationDriver());

        annotationDefinition = EqualsAnnotationDefinition.getInstance();
        configuredAnnotations.add(annotationDefinition);
        annotationDrivers.put(annotationDefinition.getClassName(), new DefaultOracleAnnotationDriver());

        annotationDefinition = LabelAnnotationDefinition.getInstance();
        configuredAnnotations.add(annotationDefinition);
        annotationDrivers.put(annotationDefinition.getClassName(), new DefaultOracleAnnotationDriver());

        annotationDefinition = RoleAnnotationDefinition.getInstance();
        configuredAnnotations.add(annotationDefinition);
        annotationDrivers.put(annotationDefinition.getClassName(), new DefaultOracleAnnotationDriver());

        annotationDefinition = PositionAnnotationDefinition.getInstance();
        configuredAnnotations.add(annotationDefinition);
        annotationDrivers.put(annotationDefinition.getClassName(), new DefaultOracleAnnotationDriver());
                
    }

    @Override
    public List<AnnotationDefinition> getConfiguredAnnotations() {
        return configuredAnnotations;
    }

    @Override
    public AnnotationDefinition getConfiguredAnnotation(String annotationClassName) {
        for (AnnotationDefinition annotationDefinition : configuredAnnotations) {
            if (annotationClassName.equals(annotationDefinition.getClassName())) return annotationDefinition;
        }
        return null;
    }

    @Override
    public AnnotationDriver getAnnotationDriver(String annotationClassName) {
        return annotationDrivers.get(annotationClassName);
    }

    @Override
    public DataModel loadModel(IOService ioService, Collection<Path> rootPaths, boolean recursiveScan) throws IOException {
        //TODO check implementations
        return null;
    }

    @Override
    public void generateModel(IOService ioService, Path root) throws IOException {
        //TODO
    }

    @Override
    public DataModel createModel() {
        return new DataModelImpl();
    }

    public void addOracleModel(DataModel dataModel, ProjectDataModelOracle oracleDataModel) throws ModelDriverException {

        logger.debug("Adding oracleDataModel: " + oracleDataModel + " to dataModel: " + dataModel);
        
        String[] factTypes = oracleDataModel.getFactTypes();
        
        if (factTypes != null && factTypes.length > 0) {
            for (int i = 0; i < factTypes.length; i++) {
                //skip .drl declared fact types.
                if (isDataObject(oracleDataModel, factTypes[i])) {
                    addFactType(dataModel, oracleDataModel, factTypes[i]);
                }
            }
        } else {
            logger.debug("oracleDataModel hasn't defined fact types");
        }
    }

    private void addFactType(DataModel dataModel, ProjectDataModelOracle oracleDataModel, String factType) throws ModelDriverException {

        String packageName = NamingUtils.getInstance().extractPackageName(factType);
        String className = NamingUtils.getInstance().extractClassName(factType);
        String superClass = oracleDataModel.getSuperType(factType);

        logger.debug("Adding factType: " + factType + ", to dataModel: " + dataModel + ", from oracleDataModel: " + oracleDataModel);
        DataObject dataObject = dataModel.addDataObject(factType);
        dataObject.setSuperClassName(superClass);

        //process type annotations
        Set<Annotation> typeAnnotations = oracleDataModel.getTypeAnnotations(factType);
        if (typeAnnotations != null) {
            for (Annotation annotation : typeAnnotations) {
                addFactTypeAnnotation(dataObject, annotation);
            }
        }
        
        Map<String, ModelField[]> fields = oracleDataModel.getModelFields();
        if (fields != null) {
            ModelField[] factFields = fields.get(factType);
            ModelField field;
            ObjectProperty property;
            Map<String, Set<Annotation>> typeFieldsAnnotations = oracleDataModel.getTypeFieldsAnnotations(factType);
            Set<Annotation> fieldAnnotations;
            if (factFields != null && factFields.length > 0) {
                for (int j = 0; j < factFields.length ; j++) {
                    field = factFields[j];
                    if (isLoadableField(field)) {
                        
                        if (field.getType().equals("Collection")) {
                            //particular processing for collection types
                            //read the correction bag and item classes.
                            String bag = oracleDataModel.getFieldClassName(factType, field.getName());
                            String itemsClass = oracleDataModel.getParametricFieldType(factType, field.getName());
                            property = dataObject.addProperty(field.getName(), itemsClass, true, bag);

                        } else {
                            property = dataObject.addProperty(field.getName(), getFieldType(oracleDataModel, packageName, field.getClassName()));
                        }

                        //process property annotations
                        if (typeFieldsAnnotations != null && (fieldAnnotations = typeFieldsAnnotations.get(field.getName())) != null) {
                            for (Annotation fieldAnnotation : fieldAnnotations) {
                                addFieldAnnotation(dataObject, property, fieldAnnotation);
                            }
                        }
                    }
                }
            }
        } else {
            logger.debug("No fields for factTye: " + factType);
        }
    }

    private void addFactTypeAnnotation(DataObject dataObject, Annotation annotationToken) throws ModelDriverException {
        org.jbpm.datamodeler.core.Annotation annotation = createAnnotation(annotationToken);
        if (annotation != null) dataObject.addAnnotation(annotation);
    }

    private void addFieldAnnotation(DataObject dataObject, ObjectProperty property, Annotation annotationToken) throws ModelDriverException {
        org.jbpm.datamodeler.core.Annotation annotation = createAnnotation(annotationToken);
        if (annotation != null) property.addAnnotation(annotation);
    }

    private org.jbpm.datamodeler.core.Annotation createAnnotation(Annotation annotationToken) throws ModelDriverException {

        AnnotationDefinition annotationDefinition = getConfiguredAnnotation(annotationToken.getQualifiedTypeName());
        org.jbpm.datamodeler.core.Annotation annotation = null;

        if (annotationDefinition != null) {
            AnnotationDriver annotationDriver = getAnnotationDriver(annotationDefinition.getClassName());
            if (annotationDriver != null) {
                annotation = annotationDriver.buildAnnotation(annotationDefinition, annotationToken);
            } else {
                logger.warn("AnnotationDriver for annotation: " + annotationToken.getQualifiedTypeName() + " is not configured for this driver");
            }
        } else {
            logger.warn("Annotation: " + annotationToken.getQualifiedTypeName() + " is not configured for this driver.");
        }
        return annotation;
    }

    /**
     * 
     * @param fieldType
     * @return
     */
    private String getFieldType(ProjectDataModelOracle oracleDataModel, String packageName, String fieldType) {
        //TODO review what happens if we read things like int, boolean, etc.

        return fieldType;
    }

    /**
     * True if the given fact type is a DataObject.
     */
    private boolean isDataObject(ProjectDataModelOracle oracleDataModel, String factType) {
        return !oracleDataModel.isDeclaredType(factType);
    }

    /**
     * Indicates if this field should be loaded or not.
     * Some fields like a filed with name "this" shouldn't be loaded.
     */
    private boolean isLoadableField(ModelField field) {
        return !"this".equals(field.getName());
    }
}
