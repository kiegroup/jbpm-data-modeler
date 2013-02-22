package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.*;


public class ModelFactoryImpl implements ModelFactory {
    
    public static ModelFactory getInstance() {
        return new ModelFactoryImpl();
    }

    @Override
    public DataModel newModel(String name) {
        return new DataModelImpl(name);
    }

    @Override
    public DataObject newDataObject(String packageName, String name) {
        return new DataObjectImpl(packageName, name);
    }

    @Override
    public ObjectProperty newProperty(String name, String className, boolean multiple) {
        return new ObjectPropertyImpl(name, className, multiple);
    }

    @Override
    public Attribute newAttribute(String name, String value) {
        return new AttributeImpl(name, value);
    }
}
