/**
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
@Templated(value = "PropertyEditor2.html")
public class PropertyEditor2 extends Composite {

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

    public PropertyEditor2() {
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
