package org.jbpm.datamodeler.editor.backend.server;


import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.ObjectProperty;
import org.jbpm.datamodeler.core.PropertyTypeFactory;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.jbpm.datamodeler.core.impl.PropertyTypeFactoryImpl;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

import java.util.ArrayList;
import java.util.List;

public class DataModelHelper {

    public static DataModelHelper getInstance() {
        return new DataModelHelper();
    }

    public DataModel to2Domain(DataModelTO dataModelTO) {
        DataModel dataModel = ModelFactoryImpl.getInstance().newModel(dataModelTO.getName());
        List<DataObjectTO> dataObjects = dataModelTO.getDataObjects();
        DataObject dataObject;

        if (dataObjects != null) {
            for (DataObjectTO dataObjectTO  : dataObjects) {
                dataObject = dataModel.addDataObject(dataObjectTO.getPackageName(), dataObjectTO.getName());
                to2Domain(dataObjectTO, dataObject);
            }
        }
        return dataModel;
    }

    public DataModelTO domain2To(DataModel dataModel, Integer status) {
        DataModelTO dataModelTO = new DataModelTO(dataModel.getName());
        List<DataObject> dataObjects = new ArrayList<DataObject>();
        dataObjects.addAll(dataModel.getDataObjects());

        DataObjectTO dataObjectTO;

        if (dataObjects != null) {
            for (DataObject dataObject  : dataObjects) {
                dataObjectTO = new DataObjectTO(dataObject.getName(), dataObject.getPackageName(), dataObject.getSuperClassName());
                if (status != null) {
                    dataObjectTO.setStatus(status);
                }
                domain2To(dataObject, dataObjectTO);
                dataModelTO.getDataObjects().add(dataObjectTO);
            }
        }
        return dataModelTO;
    }

    public void domain2To(DataObject dataObject, DataObjectTO dataObjectTO) {
        dataObjectTO.setName(dataObject.getName());
        dataObjectTO.setOriginalClassName(dataObject.getClassName());
        dataObjectTO.setSuperClassName(dataObject.getSuperClassName());
        List<ObjectProperty> properties = new ArrayList<ObjectProperty>();
        properties.addAll(dataObject.getProperties().values());

        List<ObjectPropertyTO> propertiesTO = new ArrayList<ObjectPropertyTO>();
        PropertyTypeFactory typeFactory = PropertyTypeFactoryImpl.getInstance();

        if (properties != null) {
            for (ObjectProperty property : properties) {
                propertiesTO.add(new ObjectPropertyTO(property.getName(), property.getClassName(), property.isMultiple(), typeFactory.isBasePropertyType(property.getClassName())));
            }
        }
        dataObjectTO.setProperties(propertiesTO);
    }

    public void to2Domain(DataObjectTO dataObjectTO, DataObject dataObject) {
        dataObject.setName(dataObjectTO.getName());
        List<ObjectPropertyTO> properties = dataObjectTO.getProperties();

        if (properties != null) {
            for (ObjectPropertyTO propertyTO : properties) {
                dataObject.addProperty(propertyTO.getName(), propertyTO.getClassName(), propertyTO.isMultiple());
            }
        }
    }
}
