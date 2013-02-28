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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@Templated(value = "DataModelEditorViewImpl.html")
public class DataModelEditorViewImpl extends Composite
    implements DataModelEditorPresenter.DataModelEditorView {


    private DataModelEditorPresenter presenter;

    @DataField
    private SimplePanel browserPanel = new SimplePanel();

    @DataField
    private SimplePanel dataObjectPanel = new SimplePanel();

    @DataField
    private SimplePanel propertiesPanel = new SimplePanel();

    @Inject
    private PropertyEditor propertyEditor;

    @Inject
    private DataModelBrowser dataModelBrowser;

    @Inject
    private DataObjectEditor dataObjectEditor;

    private DataModelTO dataModel;

    public DataModelEditorViewImpl() {
    }

    @Override
    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;

        dataModelBrowser.setDataModel(dataModel);
        dataModelBrowser.setModelEditorPresenter(presenter);

        dataObjectEditor.setDataModel(dataModel);
        dataObjectEditor.setModelEditorPresenter(presenter);
    }

    @Override
    public void deleteDataObject(DataObjectTO dataObject, int index) {
        dataModelBrowser.deleteDataObject(dataObject, index);
    }

    @Override
    public void addDataObject(String text) {
        dataModelBrowser.addDataObject(new DataObjectTO(text));
    }

    @Override
    public void modelSelected() {
        propertyEditor.loadProperties("Propiedades del modelo", "","");
    }

    @Override
    public void selectDataObject(DataObjectTO dataObject) {
        dataObjectEditor.setDataObject(dataObject);
        propertyEditor.loadProperties("Properties (" + dataObject.getName() + ")", dataObject.getName(), "");
    }

    @Override
    public void selectDataObjectProperty(ObjectPropertyTO selectedProperty) {
        propertyEditor.loadProperties("Properties (" + selectedProperty.getName() +")", selectedProperty.getName(), selectedProperty.getClassName());
    }

    @Override
    public void addDataObjectProperty(ObjectPropertyTO objectProperty) {
        dataObjectEditor.addDataObjectProperty(objectProperty);
    }

    @Override
    public void deleteDataObjectProperty(ObjectPropertyTO property, int index) {
        dataObjectEditor.deleteDataObjectProperty(property, index);
    }

    @Override
    public void init(final DataModelEditorPresenter presenter) {
        this.presenter = presenter;
        
        browserPanel.add(dataModelBrowser);
        dataObjectPanel.add(dataObjectEditor);
        propertiesPanel.add(propertyEditor);
    }

}
