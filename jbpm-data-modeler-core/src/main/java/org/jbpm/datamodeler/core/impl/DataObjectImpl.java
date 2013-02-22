package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.ObjectProperty;

import java.util.HashMap;
import java.util.Map;


public class DataObjectImpl extends ModelElementImpl implements DataObject {

    private String packageName;
    
    private String superClassName;
    
    private Map<String, ObjectProperty> properties = new HashMap<String, ObjectProperty>();

    public DataObjectImpl(String packageName, String name) {
        super(name);
        this.packageName = packageName;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String getClassName() {
        return (packageName != null ? packageName+"." : "") + getName();
    }

    @Override
    public boolean hasSuperClass() {
        return superClassName != null;
    }

    @Override
    public String getSuperClassName() {
        return superClassName;
    }

    @Override
    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    @Override
    public Map<String, ObjectProperty> getProperties() {
        return properties;
    }

    @Override
    public ObjectProperty addProperty(String name, String className) {
        return addProperty(name, className, false);
    }

    @Override
    public ObjectProperty addProperty(String name, String className, boolean multiple) {
        ObjectProperty property = ModelFactoryImpl.getInstance().newProperty(name, className, multiple);
        properties.put(name, property);
        return property;
    }

    @Override
    public ObjectProperty removeProperty(String name) {
        return properties.remove(name);
    }

}
