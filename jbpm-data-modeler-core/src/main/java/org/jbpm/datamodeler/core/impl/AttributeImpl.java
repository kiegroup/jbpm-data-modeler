package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.Attribute;

public class AttributeImpl implements Attribute {

    private String name;
    
    private String value;

    public AttributeImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }


}
