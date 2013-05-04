package org.jbpm.datamodeler.driver.impl.annotations;


import org.jbpm.datamodeler.annotations.Label;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

public class LabelAnnotationDefinition extends AbstractAnnotationDefinition {

    public LabelAnnotationDefinition() {
        super("@Label", Label.class.getName(), "Label", "Label annotation", true, true);
        addMember(new AnnotationMemberDefinitionImpl("value", String.class.getName(), false, "", "value", "value"));
    }

    public static LabelAnnotationDefinition getInstance() {
        return new LabelAnnotationDefinition();
    }

}
