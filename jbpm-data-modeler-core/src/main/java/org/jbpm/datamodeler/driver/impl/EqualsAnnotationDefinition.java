package org.jbpm.datamodeler.driver.impl;


import org.jbpm.datamodeler.annotations.Equals;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;

public class EqualsAnnotationDefinition extends AbstractAnnotationDefinition {

    public EqualsAnnotationDefinition() {
        super("@Equals", Equals.class.getName(), "Equals", "Equals annotation");
    }
}
