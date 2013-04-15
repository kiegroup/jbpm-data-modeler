package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class JPATableAnnotationDefinition extends AbstractAnnotationDefinition {

    public JPATableAnnotationDefinition(String name, String shortDescription, String description) {
        super("@Table", "javax.persistence.Entity", "Table", "JPA Table");

        addMember(new AnnotationMemberDefinitionImpl("name", "name", "name parameter", "java.lang.String"));

        addMember(new AnnotationMemberDefinitionImpl("catalog", "catalog", "catalog parameter", "java.lang.String"));

        addMember(new AnnotationMemberDefinitionImpl("name", "name", "name parameter", "java.lang.String"));

        addMember(new AnnotationMemberDefinitionImpl("schema", "schema", "schema parameter", "java.lang.String"));

        addMember(new AnnotationMemberDefinitionImpl("uniqueConstraints", "uniqueConstraints", "uniqueConstraints parameter", "another annotation"));

    }
}
