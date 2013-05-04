package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class PropertyTypeTO {

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
