package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;

@Portable
public class ObjectPropertyTO implements Serializable {

    private String className;

    private String name;

    public ObjectPropertyTO() {
    }

    public ObjectPropertyTO(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
