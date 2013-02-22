package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.ObjectProperty;

public class ObjectPropertyImpl extends ModelElementImpl implements ObjectProperty {

    private String className;
    
    private String bag;
    
    private boolean multiple;

    public ObjectPropertyImpl(String name, String className, boolean multiple) {
        super(name);
        this.className = className;
        setMultiple(multiple);
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
        if (multiple) {
            setBag("java.util.List");
        } else {
            setBag(null);
        }
    }

    @Override
    public boolean isMultiple() {
        return multiple;
    }
}
