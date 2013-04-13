package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.impl.AbstractAttributeDefinition;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class JPAEntityAttributeDefinition extends AbstractAttributeDefinition {

    public JPAEntityAttributeDefinition() {
        super("@Entity", "Entity", "JPA Entity");
    }
}
