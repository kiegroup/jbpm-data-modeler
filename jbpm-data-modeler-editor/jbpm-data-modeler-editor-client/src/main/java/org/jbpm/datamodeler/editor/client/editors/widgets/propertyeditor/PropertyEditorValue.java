package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;

import java.util.ArrayList;
import java.util.List;

public class PropertyEditorValue {

    Object oldValue;

    Object value;

    Object pendingValue;
    
    String type;

    String name;

    List<PropertyChangeError> errors = new ArrayList<PropertyChangeError>();

    boolean hasError = false;

    boolean needsRedraw = false;

    public PropertyEditorValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public PropertyEditorValue(String name, Object value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
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

    public Object getPendingValue() {
        return pendingValue;
    }

    public void setPendingValue(Object pendingValue) {
        this.pendingValue = pendingValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
        if (!hasError) errors.clear();
    }

    public boolean isNeedsRedraw() {
        return needsRedraw;
    }

    public void setNeedsRedraw(boolean needsRedraw) {
        this.needsRedraw = needsRedraw;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public List<PropertyChangeError> getErrors() {
        return errors;
    }

    public void setErrors(List<PropertyChangeError> errors) {
        this.errors = errors;
    }
}