package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;


import org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor.PropertyChangeError;

import java.util.List;

public interface PropertyValidator {

    /**
     * Validates the value.
     *
     * @param value Object to validate.
     *
     * @return null if validation was ok, any other value indicates that validation failed.
     */
    List<PropertyChangeError> validate(Object value);

}
