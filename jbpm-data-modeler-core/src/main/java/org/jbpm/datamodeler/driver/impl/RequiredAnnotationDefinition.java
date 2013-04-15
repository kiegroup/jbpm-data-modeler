package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.annotations.Required;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;

public class RequiredAnnotationDefinition extends AbstractAnnotationDefinition {

    public RequiredAnnotationDefinition() {
        super("@Required", Required.class.getName(), "Required", "Required attribute");
    }
}
