package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.Attribute;
import org.jbpm.datamodeler.core.AttributeDefinition;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAttribute implements Attribute {

    private AttributeDefinition attributeDefinition;

    private Map<String, Object> values = new HashMap<String, Object>();

    public AbstractAttribute(AttributeDefinition attributeDefinition) {
        this.attributeDefinition = attributeDefinition;
    }

    @Override
    public String getName() {
        return attributeDefinition.getName();
    }

    @Override
    public Object getValue(String paramName) {
        return values.get(paramName);
    }

    @Override
    public Map<String, Object> getValues() {
        return values;
    }

    @Override
    public void setValue(String paramName, Object value) {
        values.put(paramName, value);
    }

    @Override
    public AttributeDefinition getAttributeDefinition() {
        return attributeDefinition;
    }
}