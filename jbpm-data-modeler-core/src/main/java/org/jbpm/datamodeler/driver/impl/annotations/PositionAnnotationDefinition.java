package org.jbpm.datamodeler.driver.impl.annotations;

import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

public class PositionAnnotationDefinition extends AbstractAnnotationDefinition {

    public PositionAnnotationDefinition() {

        super("@Position", org.kie.api.definition.type.Position.class.getName(), "Position", "Position annotation", false, true);
        addMember(new AnnotationMemberDefinitionImpl("value", Integer.class.getName(), false, "", "value", "value"));
    }

    public static PositionAnnotationDefinition getInstance() {
        return new PositionAnnotationDefinition();
    }
}
