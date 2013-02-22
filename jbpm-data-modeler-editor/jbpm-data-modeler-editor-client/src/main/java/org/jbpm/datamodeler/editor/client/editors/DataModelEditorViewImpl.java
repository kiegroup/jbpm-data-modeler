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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
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

    //this field is not injected because we are creating it here
    @DataField
    private HorizontalPanel contentsPanel = new HorizontalPanel();
    
    @Inject
    private PropertyEditor propertyEditor;

    
    private DataModelTO dataModel;

    @Inject
    private DataModelBrowser dataModelBrowser;

    @Inject
    private DataObjectEditor dataObjectEditor;

    public DataModelEditorViewImpl() {
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public void deleteDataObject(DataObjectTO dataObject, int index) {
        //Window.alert("le piden a la vista que borre el elemento: " + dataObject + "index: " + index);
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
        this.dataModel = presenter.getDataModel();

        dataModelBrowser.setDataModel(dataModel);
        dataModelBrowser.setModelEditorPresenter(presenter);

        dataObjectEditor.setDataModel(dataModel);
        dataObjectEditor.setModelEditorPresenter(presenter);


        contentsPanel.add(dataModelBrowser);
        contentsPanel.add(dataObjectEditor);
        contentsPanel.add(propertyEditor);
    }

}
