package org.jbpm.datamodeler.editor.backend.server;


import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.ObjectProperty;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

import java.util.ArrayList;
import java.util.List;

public class DataModelHelper {

    //TODO provide a better implementation or another way to access domain objects from client code
    public static DataModel to2Domain(DataModelTO dataModelTO) {
        DataModel dataModel = ModelFactoryImpl.getInstance().newModel(dataModelTO.getName());
        List<DataObjectTO> dataObjects = dataModelTO.getDataObjects();
        DataObject dataObject;

        if (dataObjects != null) {
            for (DataObjectTO dataObjectTO  : dataObjects) {
                dataObject = dataModel.addDataObject("default", dataObjectTO.getName());
                to2Domain(dataObjectTO, dataObject);
            }
        }

        return dataModel;
    }

    //TODO provide a better implementation or another way to access domain objects from client code
    public static DataModelTO domain2To(DataModel dataModel) {
        DataModelTO dataModelTO = new DataModelTO(dataModel.getName());
        List<DataObject> dataObjects = new ArrayList<DataObject>();
        dataObjects.addAll(dataModel.getDataObjects());

        DataObjectTO dataObjectTO;

        if (dataObjects != null) {
            for (DataObject dataObject  : dataObjects) {
                dataObjectTO = new DataObjectTO(dataObject.getName());
                domain2To(dataObject, dataObjectTO);
                dataModelTO.getDataObjects().add(dataObjectTO);
            }
        }

        return dataModelTO;
    }

    //TODO provide a better implementation or another way to access domain objects from client code
    public static void domain2To(DataObject dataObject, DataObjectTO dataObjectTO) {
        dataObjectTO.setName(dataObject.getName());
        List<ObjectProperty> properties = new ArrayList<ObjectProperty>();
        properties.addAll(dataObject.getProperties().values());

        List<ObjectPropertyTO> propertiesTO = new ArrayList<ObjectPropertyTO>();
        if (properties != null) {
            for (ObjectProperty property : properties) {
                propertiesTO.add(new ObjectPropertyTO(property.getName(), property.getClassName()));
            }
        }
    }

    //TODO provide a better implementation or another way to access domain objects from client code
    public static void to2Domain(DataObjectTO dataObjectTO, DataObject dataObject) {
        dataObject.setName(dataObjectTO.getName());
        List<ObjectPropertyTO> properties = dataObjectTO.getProperties();

        if (properties != null) {
            for (ObjectPropertyTO propertyTO : properties) {
                dataObject.addProperty(propertyTO.getName(), propertyTO.getClassName());
            }
        }
    }
}
