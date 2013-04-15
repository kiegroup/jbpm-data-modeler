package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class JPAEntityAnnotationDefinition extends AbstractAnnotationDefinition {

    public JPAEntityAnnotationDefinition() {
        super("@Entity", "javax.persistence.Entity", "Entity", "JPA Entity");
        addMember(new AnnotationMemberDefinitionImpl("name", "java.lang.String", "name", "name"));
    }
}
