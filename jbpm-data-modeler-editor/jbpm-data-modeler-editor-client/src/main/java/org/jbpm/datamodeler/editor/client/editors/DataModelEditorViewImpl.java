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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
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

    @Inject
    private TabbedPropertyEditor tabbedPropertyEditor;

    @Inject
    private DataModelBrowser dataModelBrowser;

    @Inject
    private DataObjectEditor dataObjectEditor;

    private DataModelTO dataModel;

    private DataObjectTO selectedDataObject;

    public DataModelEditorViewImpl() {
    }

    @Override
    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;

        dataModelBrowser.setDataModel(dataModel);
        dataModelBrowser.setModelEditorPresenter(presenter);

        dataObjectEditor.setDataModel(dataModel);
        dataObjectEditor.setModelEditorPresenter(presenter);

        tabbedPropertyEditor.setDataModel(dataModel);

        if (dataModel != null && dataModel.getDataObjects().size() > 0) {
            presenter.createSelectCommand(dataModel.getDataObjects().get(0), true).execute();
        }
    }

    @Override
    public void deleteDataObject(DataObjectTO dataObject, int index) {
        dataModelBrowser.deleteDataObject(dataObject, index);
        dataObjectEditor.notifyDataModelChanged();
    }

    @Override
    public void addDataObject(DataObjectTO dataObject) {
        dataModelBrowser.addDataObject(dataObject);
        dataObjectEditor.notifyDataModelChanged();
    }

    @Override
    public void modelSelected() {
        //TODO complete this implementation when the properties editor is ready
        tabbedPropertyEditor.tabPanel.selectTab(0);
    }

    @Override
    public void selectDataObject(DataObjectTO dataObject, boolean clearBreadcrums) {
        this.selectedDataObject = dataObject;
        dataModelBrowser.selectDataObject(dataObject);
        dataObjectEditor.setDataObject(dataObject, clearBreadcrums);
        //TODO complete this implementation when the properties editor is ready
        tabbedPropertyEditor.setDataObject(dataObject);
        tabbedPropertyEditor.tabPanel.selectTab(1);
    }

    @Override
    public void selectDataObjectProperty(ObjectPropertyTO selectedProperty) {
        //TODO complete this implementation when the properties editor is ready
        tabbedPropertyEditor.setDataObjectProperty(selectedProperty);
        tabbedPropertyEditor.tabPanel.selectTab(2);
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
        tabbedPropertyEditor.modelProperties.addPropertyEditorListener(presenter.getDataModelEditorListener());
        tabbedPropertyEditor.objectProperties.addPropertyEditorListener(presenter.getDataObjectEditorListener());
        tabbedPropertyEditor.fieldProperties.addPropertyEditorListener(presenter.getDataObjectFieldEditorListener());
    }

    @Override
    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        dataObjectEditor.setBaseTypes(baseTypes);
    }

    @Override
    public void refreshObjectEditor() {
        dataObjectEditor.refresh();
    }

}
