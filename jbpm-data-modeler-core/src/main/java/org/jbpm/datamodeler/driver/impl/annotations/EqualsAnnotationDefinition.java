package org.jbpm.datamodeler.driver.impl.annotations;


import org.jbpm.datamodeler.annotations.Equals;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;

public class EqualsAnnotationDefinition extends AbstractAnnotationDefinition {

    public EqualsAnnotationDefinition() {
        super("@Equals", Equals.class.getName(), "Equals", "Equals annotation", false, true);
    }

    public static EqualsAnnotationDefinition getInstance() {
        return new EqualsAnnotationDefinition();
    }
}
