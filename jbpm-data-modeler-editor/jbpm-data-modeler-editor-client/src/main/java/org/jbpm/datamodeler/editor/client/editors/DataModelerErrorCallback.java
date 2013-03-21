package org.jbpm.datamodeler.editor.client.editors;

import com.google.gwt.user.client.Window;
import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.Message;

public class DataModelerErrorCallback implements ErrorCallback {
    
    String localMessage = "";

    public DataModelerErrorCallback() {
    }

    public DataModelerErrorCallback(String localMessage) {
        this.localMessage = localMessage;
    }

    @Override
    public boolean error( final Message message,
                          final Throwable throwable ) {
        //TODO show a popup
        Window.alert("Error: \n" + localMessage + "\n\nThe server error is: \n" + throwable.getMessage());
        return true;
    }
}
