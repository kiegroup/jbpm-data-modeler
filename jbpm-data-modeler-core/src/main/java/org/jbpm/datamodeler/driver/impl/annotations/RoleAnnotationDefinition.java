package org.jbpm.datamodeler.driver.impl.annotations;

import org.jbpm.datamodeler.annotations.Role;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

public class RoleAnnotationDefinition extends AbstractAnnotationDefinition {

    public RoleAnnotationDefinition() {
        super("@Role", Role.class.getName(), "Role", "Role annotation", true, true);
        addMember(new AnnotationMemberDefinitionImpl("value", String.class.getName(), false, "", "value", "value"));
    }

    public static RoleAnnotationDefinition getInstance() {
        return new RoleAnnotationDefinition();
    }
}

