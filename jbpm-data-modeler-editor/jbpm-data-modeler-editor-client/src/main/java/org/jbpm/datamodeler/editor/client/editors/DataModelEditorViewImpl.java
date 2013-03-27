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
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

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

    @DataField
    private Anchor editorTitle = new Anchor();

    @Inject
    private TabbedPropertyEditor tabbedPropertyEditor;

    @Inject
    private DataModelBrowser dataModelBrowser;

    @Inject
    private DataObjectEditor dataObjectEditor;

    private DataModelTO dataModel;

    public DataModelEditorViewImpl() {
        editorTitle.setText(Constants.INSTANCE.modelEditor_title());
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
    public void addDataObject(DataObjectTO dataObject) {
        dataModelBrowser.addDataObject(dataObject);
    }

    @Override
    public void modelSelected() {
        //TODO complete this implementation when the properties editor is ready
        tabbedPropertyEditor.modelProperties.loadProperties("Model properties", "","");
    }

    @Override
    public void selectDataObject(DataObjectTO dataObject, boolean clearBreadcrums) {
        dataModelBrowser.selectDataObject(dataObject);
        dataObjectEditor.setDataObject(dataObject, clearBreadcrums);
        //TODO complete this implementation when the properties editor is ready
        tabbedPropertyEditor.objectProperties.loadProperties("Data Object properties (" + dataObject.getName() + ")", dataObject.getName(), "");
    }

    @Override
    public void selectDataObjectProperty(ObjectPropertyTO selectedProperty) {
        //TODO complete this implementation when the properties editor is ready
        tabbedPropertyEditor.fieldProperties.loadProperties("Field properties (" + (selectedProperty != null ? selectedProperty.getName() : "") +")",
                (selectedProperty != null ? selectedProperty.getName() : ""),
                (selectedProperty != null ? selectedProperty.getClassName() : ""));
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
        propertiesPanel.add(tabbedPropertyEditor);
    }

    @Override
    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        dataObjectEditor.setBaseTypes(baseTypes);
    }

}
