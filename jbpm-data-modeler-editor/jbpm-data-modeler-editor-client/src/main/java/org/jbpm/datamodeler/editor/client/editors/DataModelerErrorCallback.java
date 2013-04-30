package org.jbpm.datamodeler.editor.client.editors;

import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.Message;
import org.kie.guvnor.commons.ui.client.popups.errors.ErrorPopup;
import org.uberfire.client.common.BusyPopup;

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
        BusyPopup.close();
        ErrorPopup.showMessage("Error: " + localMessage + ".\nThe server error is: \n" + throwable.getMessage());
        return true;
    }
}
