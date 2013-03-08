package org.jbpm.datamodeler.editor.client.editors.resources.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface Constants extends Messages {

    public static final Constants INSTANCE = GWT.create(Constants.class);

    public String modelBrowser_modelUnknown();

    public String modelBrowser_emptyTable();

    public String modelBrowser_create();
    
    public String modelBrowser_createDataObject();

    public String objectEditor_objectUnknown();
    
    public String objectEditor_createProperty();

    public String objectEditor_create();

    public String objectEditor_emptyTable();

    public String objectEditor_columnName();

    public String objectEditor_columnType();

}
