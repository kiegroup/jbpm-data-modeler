package org.jbpm.datamodeler.core;

import java.util.Set;

public interface DataModel extends ModelElement {

    void setVersion(String version);
    
    String getVersion();

    Set<DataObject> getDataObjects();

    DataObject addDataObject(String packageName, String name);

    DataObject getDataObject(String className);
    
    DataObject removeDataObject(String className);

}
