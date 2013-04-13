package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.AttributeDefinition;
import org.jbpm.datamodeler.core.AttributeParamDefinition;

import java.util.HashSet;
import java.util.Set;


public class AbstractAttributeDefinition implements AttributeDefinition {
    
    protected String name;

    protected String shortDescription;

    protected String description;

    protected Set<AttributeParamDefinition> attributeParams = new HashSet<AttributeParamDefinition>();

    protected AbstractAttributeDefinition(String name, String shortDescription, String description) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Set<AttributeParamDefinition> getAttributeParams() {
        return attributeParams;
    }

    protected void addAttributeParam(AttributeParamDefinition attributeParam) {
        attributeParams.add(attributeParam);
    }
}
