package org.jbpm.datamodeler.editor.client.editors;


import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@Templated(value = "PropertyEditor.html")
public class PropertyEditor extends Composite {

    @DataField
    private Label dataObjectPropertiesLabel = new Label("Nada seleccionado");

    @DataField
    private DivElement button = DOM.createDiv().cast();

    @Inject
    @DataField
    private TextBox name;

    @Inject
    @DataField
    private TextBox documentation;

    public PropertyEditor() {
    }

    @EventHandler("button")
    public void clickButton(ClickEvent event) {
        Window.alert("The button was clicked: " + event.getSource());
    }

    public void loadProperties(String objectName, String name, String documentation) {
        dataObjectPropertiesLabel.setText(objectName);
        this.name.setText(name);
        this.documentation.setText(documentation);
    }
}
