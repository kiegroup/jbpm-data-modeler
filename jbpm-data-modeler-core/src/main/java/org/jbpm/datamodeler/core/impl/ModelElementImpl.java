package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.Attribute;
import org.jbpm.datamodeler.core.ModelElement;

import java.util.HashMap;
import java.util.Map;

public abstract class ModelElementImpl implements ModelElement {
    
    private String name;
    
    private Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    protected ModelElementImpl() {
    }

    protected ModelElementImpl(String name) {
        this.name = name;
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
    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Attribute addAttribute(String name, String value) {
        Attribute attribute = ModelFactoryImpl.getInstance().newAttribute(name, value);
        attributes.put(attribute.getName(), attribute);
        return attribute;
    }

    @Override
    public Attribute removeAttribute(String name) {
        return attributes.remove(name);
    }
}
