package org.jbpm.datamodeler.editor.events;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/27/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */

@Portable
public class DataModelerEvent {

    public DataModelerEvent() {
    }

    
    public DataModelerEvent(String message) {
        this.message = message;
    }

    public String action;
    
    public String message;

    public DataObjectTO dataObjectTO;

    public ObjectPropertyTO propertyTO;

}
