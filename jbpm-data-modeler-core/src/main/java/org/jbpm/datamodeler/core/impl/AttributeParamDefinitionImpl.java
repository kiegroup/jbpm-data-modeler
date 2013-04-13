package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.AttributeParamDefinition;

public class AttributeParamDefinitionImpl implements AttributeParamDefinition {

    private String name;

    private String shortDescription;

    private String description;
    
    private String className;

    public AttributeParamDefinitionImpl(String name, String shortDescription, String description, String className) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
