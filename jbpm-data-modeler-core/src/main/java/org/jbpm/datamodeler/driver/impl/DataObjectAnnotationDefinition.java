package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;

public class DataObjectAnnotationDefinition extends AbstractAnnotationDefinition {

    public DataObjectAnnotationDefinition() {
        super("@DataObject", DataObject.class.getName(), "DataObject", "DataObject annotation");
    }
}
