package org.jbpm.datamodeler.driver.impl;


import org.jbpm.datamodeler.commons.NamingUtils;
import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.impl.DataModelImpl;
import org.jbpm.datamodeler.driver.AnnotationDriver;
import org.jbpm.datamodeler.driver.ModelDriver;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.Path;
import org.kie.guvnor.datamodel.model.ModelField;
import org.kie.guvnor.datamodel.oracle.ProjectDataModelOracle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataModelOracleDriver implements ModelDriver {
    
    private static final Logger logger = LoggerFactory.getLogger(DataModelOracleDriver.class);

    @Override
    public List<AnnotationDefinition> getConfiguredAnnotations() {
        //TODO implement annotations
        return null;
    }

    @Override
    public AnnotationDefinition getConfiguredAnnotation(String annotationName) {
        //TODO implement annotations
        return null;
    }

    @Override
    public AnnotationDriver getAnnotationDriver(String annotationName) {
        //TODO implement annotations
        return null;
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

    public void addOracleModel(DataModel dataModel, ProjectDataModelOracle oracleDataModel) {

        logger.debug("Adding oracleDataModel: " + oracleDataModel + " to dataModel: " + dataModel);
        
        String[] factTypes = oracleDataModel.getFactTypes();
        
        if (factTypes != null && factTypes.length > 0) {
            for (int i = 0; i < factTypes.length; i++) {
                addFactType(dataModel, oracleDataModel, factTypes[i]);
            }
        } else {
            logger.debug("oracleDataModel hasn't defined fact types");
        }
    }

    private void addFactType(DataModel dataModel, ProjectDataModelOracle oracleDataModel, String factType) {

        String packageName = NamingUtils.getInstance().extractPackageName(factType);
        String className = NamingUtils.getInstance().extractClassName(factType);

        logger.debug("Adding factType: " + factType + ", to dataModel: " + dataModel + ", from oracleDataModel: " + oracleDataModel);
        DataObject dataObject = dataModel.addDataObject(factType);

        Map<String, ModelField[]> fields = oracleDataModel.getModelFields();
        ModelField[] factFields = fields.get(factType);
        ModelField field;
        if (factFields != null || factFields.length > 0) {
            for (int j = 0; factFields != null && j < factFields.length; j++) {
                field = factFields[j];
                if (isLoadableField(field)) {
                    dataObject.addProperty(field.getName(), getFieldType(oracleDataModel, packageName, field.getClassName()));
                }
            }
        } else {
            logger.debug("No fields for factTye: " + factType);
        }
        
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
     * True if the type readed is another field type in the model.
     *
     * @param fieldType
     * @return
     */
    private boolean isDataObject(ProjectDataModelOracle oracleDataModel, String fieldType) {
        String factTypes[] = oracleDataModel.getFactTypes();
        boolean result = false;
        if (factTypes != null && fieldType != null) {
            for (int i = 0; i < factTypes.length; i++) {
                if (fieldType.equals(factTypes[i])) return true;
            }
        }
        return result;
    }

    /**
     * Indicates if this field should be loaded or not.
     * Some fields like a filed with name "this" shouldn't be loaded.
     */
    private boolean isLoadableField(ModelField field) {
        //TODO check other cases
        return !"this".equals(field.getName());
    }
}
