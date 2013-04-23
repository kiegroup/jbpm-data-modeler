package org.jbpm.datamodeler.editor.client.editors.resources.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface Constants extends Messages {

    public static final Constants INSTANCE = GWT.create(Constants.class);

    public String modelEditor_newModel();

    public String modelEditor_menu_file();

    public String modelEditor_screen_name();
    
    public String modelEditor_menu_save();

    public String modelEditor_menu_generate();

    public String modelEditor_notification_dataObject_created(String name);

    public String modelEditor_notification_dataObject_deleted(String name);

    public String modelEditor_notification_dataModel_generated();

    public String modelEditor_notification_dataModel_loaded(String name);

    public String modelBrowser_modelUnknown();

    public String modelBrowser_emptyTable();

    public String modelBrowser_create();
    
    public String modelBrowser_createDataObject();

    public String modelBrowser_action_deleteDataObject();

    public String objectEditor_objectUnknown();
    
    public String objectEditor_createProperty();

    public String objectEditor_create();

    public String objectEditor_emptyTable();

    public String objectEditor_columnName();

    public String objectEditor_columnType();

    public String objectEditor_basicType();
    
    public String objectEditor_dataObjectType();
    
    public String objectEditor_multiple();

    public String objectEditor_action_deleteProperty();

}
