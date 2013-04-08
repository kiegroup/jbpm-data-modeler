package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;


public class PropertyChangeError {

    String msg;

    public PropertyChangeError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
