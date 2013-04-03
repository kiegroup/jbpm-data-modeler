package org.jbpm.datamodeler.editor.client.editors.widgets;

import java.util.Date;

public class PropertyEditorValue {

    Object value;
    
    String type;

    String name;

    public PropertyEditorValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public boolean isString() {
        return value instanceof String;
    }
    
    public boolean isBoolean() {
        return value instanceof Boolean;
    }
    
    public boolean isDate() {
        return value instanceof Date;
    }

}
