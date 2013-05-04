package org.jbpm.datamodeler.driver.impl.annotations;


import org.jbpm.datamodeler.annotations.Description;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

public class DescriptionAnnotationDefinition extends AbstractAnnotationDefinition {

    public DescriptionAnnotationDefinition() {
        super("@Description", Description.class.getName(), "Description", "Description annotation", true, true);
        addMember(new AnnotationMemberDefinitionImpl("value", String.class.getName(), false, "", "value", "value"));
    }

    public static DescriptionAnnotationDefinition getInstance() {
        return new DescriptionAnnotationDefinition();
    }
}
