package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;

@Portable
public class PropertyTypeTO implements Serializable {

    private String name;

    private String className;

    public PropertyTypeTO() {
    }

    public PropertyTypeTO(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
