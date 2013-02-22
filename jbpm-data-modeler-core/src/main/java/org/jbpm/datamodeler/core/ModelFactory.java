package org.jbpm.datamodeler.core;

public interface ModelFactory {

    public DataModel newModel(String name);

    public DataObject newDataObject(String packageName, String name);

    public ObjectProperty newProperty(String name, String className, boolean multiple);

    public Attribute newAttribute(String name, String value);
}
