package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataObjectAnnotationDefinition extends AbstractAnnotationDefinition {

    public DataObjectAnnotationDefinition(String name, String className, String shortDescription, String description) {
        super("@DataObject", DataObject.class.getName(), "DataObject", "DataObject annotation");
    }
}
