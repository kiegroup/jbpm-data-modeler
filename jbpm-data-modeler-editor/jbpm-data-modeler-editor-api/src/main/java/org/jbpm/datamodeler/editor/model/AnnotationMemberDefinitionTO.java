package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class AnnotationMemberDefinitionTO {

    private String name;
    
    private String description;
    
    private String shortDescription;

    private Object defaultValue;

    private boolean array = false;

    private String className;

    private boolean enumMember = false;

    private boolean primitiveType = false;

    public AnnotationMemberDefinitionTO() {
    }

    public AnnotationMemberDefinitionTO(String name, String className, boolean primitiveType, boolean enumMember, Object defaultValue, String shortDescription, String description) {
        this.name = name;
        this.className = className;
        this.primitiveType = primitiveType;
        this.enumMember = enumMember;
        this.defaultValue = defaultValue;
        this.shortDescription = shortDescription;
        this.description = description;
    }

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


    public String getClassName() {
        return className;
    }
    
    public boolean isEnum() {
        return enumMember;
    }

    public boolean isPrimitiveType() {
        return primitiveType;
    }

    public boolean isArray() {
        return array;
    }

    public boolean isString() {
        return "java.lang.String".equals(className);
    }

}
