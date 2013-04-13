package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.impl.AbstractAttributeDefinition;
import org.jbpm.datamodeler.core.impl.AttributeParamDefinitionImpl;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class JPATableAttributeDefinition extends AbstractAttributeDefinition {

    public JPATableAttributeDefinition(String name, String shortDescription, String description) {
        super("@Table", "Table", "JPA Table");
        addAttributeParam(new AttributeParamDefinitionImpl("name", "name", "name parameter", "java.lang.String"));

        addAttributeParam(new AttributeParamDefinitionImpl("catalog", "catalog", "catalog parameter", "java.lang.String"));

        addAttributeParam(new AttributeParamDefinitionImpl("name", "name", "name parameter", "java.lang.String"));

        addAttributeParam(new AttributeParamDefinitionImpl("schema", "schema", "schema parameter", "java.lang.String"));

        addAttributeParam(new AttributeParamDefinitionImpl("uniqueConstraints", "uniqueConstraints", "uniqueConstraints parameter", "another annotation"));

    }
}
