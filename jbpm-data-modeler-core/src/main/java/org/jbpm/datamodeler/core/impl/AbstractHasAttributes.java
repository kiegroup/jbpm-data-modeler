package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.Attribute;
import org.jbpm.datamodeler.core.HasAttributes;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractHasAttributes implements HasAttributes {

    private Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    @Override
    public Map<String, Attribute> getAttributes() {
        return attributes;               
    }

    @Override
    public Attribute getAttribute(String attributeName) {
        return attributes.get(attributeName);
    }

    @Override
    public void addAttribute(Attribute attribute) {
        attributes.put(attribute.getName(), attribute);
    }

    @Override
    public Attribute removeAttribute(String attributeName) {
        return attributes.remove(attributeName);
    }
}
