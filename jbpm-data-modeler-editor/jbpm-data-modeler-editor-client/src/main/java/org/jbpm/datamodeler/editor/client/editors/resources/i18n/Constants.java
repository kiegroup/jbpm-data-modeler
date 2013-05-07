package org.jbpm.datamodeler.editor.client.editors.resources.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface Constants extends Messages {

    public static final Constants INSTANCE = GWT.create(Constants.class);

    public String modelEditor_newModel();

    public String modelEditor_menu_main();
    
    public String modelEditor_menu_file();

    public String modelEditor_screen_name();
    
    public String modelEditor_menu_save();

    public String modelEditor_menu_new_dataObject();

    public String modelEditor_menu_generate();

    public String modelEditor_loading();

    public String modelEditor_notification_dataObject_created(String name);

    public String modelEditor_notification_dataObject_deleted(String name);

    public String modelEditor_notification_dataModel_generated();

    public String modelEditor_notification_dataModel_loaded(String name);

    public String modelEditor_notification_dataModel_saved();

    public String modelBrowser_modelUnknown();

    public String modelBrowser_emptyTable();

    public String modelBrowser_create();
    
    public String modelBrowser_createDataObject();

    public String modelBrowser_action_deleteDataObject();

    public String modelBrowser_columnName();

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

    public String new_dataobject_popup_title();
    
    public String new_dataobject_popup_name();

    public String new_dataobject_placeholder();
    
    public String new_dataobject_popup_new_package();
    
    public String new_dataobject_popup_existing_package();

    public String new_dataobject_popup_superclass();

    public String validation_error_invalid_object_identifier(String name);

    public String validation_error_invalid_package_identifier(String packageName);

    public String validation_error_object_already_exists(String name, String packageName);

}
