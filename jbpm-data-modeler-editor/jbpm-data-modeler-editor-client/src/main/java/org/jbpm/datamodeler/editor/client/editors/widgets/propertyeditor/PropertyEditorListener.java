package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;


import java.util.EventListener;
import java.util.List;

public interface PropertyEditorListener extends EventListener {

    boolean doBeforePropertyChange(PropertyEditor source, String propertyName, Object pendingValue, Object currentValue, List<PropertyChangeError> errors);

    void onPropertyChange(PropertyEditor source, String propertyName, Object newValue, Object currentValue);

}
