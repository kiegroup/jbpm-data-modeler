package org.jbpm.datamodeler.editor.model;

public class AnnotationMemberDefinitionTO {

    private String name;
    
    private String description;
    
    private String shortDescription;

    private Object defaultValue;

    private boolean array;

    private boolean className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isArray() {
        return array;
    }

    public void setArray(boolean array) {
        this.array = array;
    }

    public boolean isClassName() {
        return className;
    }

    public void setClassName(boolean className) {
        this.className = className;
    }
}
