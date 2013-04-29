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
    private ModelPropertiesEditor modelPropertiesEditor;

    @Inject
    private DataModelBrowser dataModelBrowser;

    @Inject
    private DataObjectBrowser dataObjectBrowser;

    public DataModelEditorViewImpl() {
    }

    @Override
    public void setDataModel(DataModelTO dataModel) {

        dataModelBrowser.setDataModel(dataModel);
        dataModelBrowser.setModelEditorPresenter(presenter);

        dataObjectBrowser.setDataModel(dataModel);
        dataObjectBrowser.setModelEditorPresenter(presenter);

        modelPropertiesEditor.setDataModel(dataModel);
    }

    @Override
    public void init(final DataModelEditorPresenter presenter) {
        this.presenter = presenter;
        
        browserPanel.add(dataModelBrowser);
        dataObjectPanel.add(dataObjectBrowser);
        propertiesPanel.add(modelPropertiesEditor);
    }

    @Override
    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        dataObjectBrowser.setBaseTypes(baseTypes);
    }

    @Override
    public void refreshObjectEditor() {
        dataObjectBrowser.refresh();
    }

}
