package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Portable
public class AnnotationTO implements Serializable {

    private String className;

    private String name;

    private Map<String, Object> values = new HashMap<String, Object>();

    public AnnotationTO() {
    }

    public Object getValue(String annotationMemberName) {
        return values.get(annotationMemberName);
    }

    public Map<String, Object> getValues() {
        return null;
    }

    public void setValue(String annotationMemberName, Object value) {
        values.put(annotationMemberName,  value);
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
