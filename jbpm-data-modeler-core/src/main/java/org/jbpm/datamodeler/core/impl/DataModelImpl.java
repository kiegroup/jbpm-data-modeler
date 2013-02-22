package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataModelImpl extends ModelElementImpl implements DataModel {

    Map<String, DataObject> dataObjects = new HashMap<String, DataObject>();
    
    String version;

    public DataModelImpl(String name) {
        super(name);
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Set<DataObject> getDataObjects() {
        HashSet<DataObject> set = new HashSet<DataObject>();
        set.addAll(dataObjects.values());
        return set;
    }

    @Override
    public DataObject getDataObject(String className) {
        return dataObjects.get(className);
    }

    @Override
    public DataObject removeDataObject(String className) {
        return dataObjects.remove(className);
    }

    @Override
    public DataObject addDataObject(String packageName, String name) {
        DataObject dataObject = ModelFactoryImpl.getInstance().newDataObject(packageName, name);
        dataObjects.put(dataObject.getClassName(), dataObject);
        return dataObject;
    }
}
