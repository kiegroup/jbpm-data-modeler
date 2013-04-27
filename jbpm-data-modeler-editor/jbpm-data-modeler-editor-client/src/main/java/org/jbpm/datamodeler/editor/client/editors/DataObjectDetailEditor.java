package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.editors.widgets.PackageSelector;
import org.jbpm.datamodeler.editor.client.editors.widgets.SuperclassSelector;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/26/13
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataObjectDetailEditor extends Composite {


    interface DataObjectDetailEditorUIBinder
            extends UiBinder<Widget, DataObjectDetailEditor> {

    };

    private static DataObjectDetailEditorUIBinder uiBinder = GWT.create(DataObjectDetailEditorUIBinder.class);

    @UiField
    TextBox name;

    @UiField
    TextBox shortName;

    @UiField
    TextArea description;

    @UiField
    PackageSelector packageSelector;

    @UiField
    SuperclassSelector superclassSelector;

    @UiField
    ListBox roleSelector;

    @UiField
    Button sendEvent;

    @Inject
    Event<DataModelerEvent> dataModelerEventEvent;

    public DataObjectDetailEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    
    @UiHandler("sendEvent")
    void sendEvent(ClickEvent e) {
        dataModelerEventEvent.fire(new DataModelerEvent("evento: " + new Date() + ""));
    }
    
    void print(@Observes DataModelerEvent event) {
        Window.alert(event.message);
    }


}
