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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

//@Dependent
//@Templated(value = "DataModelerScreenViewImpl.html")
public class DataModelerScreenViewImpl extends Composite
    implements DataModelerScreenPresenter.DataModelerScreenView {

    interface DataModelerScreenViewBinder
            extends
            UiBinder<Widget, DataModelerScreenViewImpl> {

    }

    private static DataModelerScreenViewBinder uiBinder = GWT.create(DataModelerScreenViewBinder.class);

    private DataModelerScreenPresenter presenter;

    //@DataField
    @UiField
    SimplePanel browserPanel = new SimplePanel();

    //@DataField
    @UiField
    SimplePanel dataObjectPanel = new SimplePanel();

    //@DataField
    @UiField
    SimplePanel propertiesPanel = new SimplePanel();

    @Inject
    private ModelPropertiesEditor modelPropertiesEditor;

    @Inject
    private DataModelBrowser dataModelBrowser;

    @Inject
    private DataObjectBrowser dataObjectBrowser;

    public DataModelerScreenViewImpl() {
        initWidget( uiBinder.createAndBindUi( this ) );
        /*
        browserPanel.add(dataModelBrowser);
        dataObjectPanel.add(dataObjectBrowser);
        propertiesPanel.add(modelPropertiesEditor);
        */
    }

    @PostConstruct
    private void initUI() {
        browserPanel.add(dataModelBrowser);
        dataObjectPanel.add(dataObjectBrowser);
        propertiesPanel.add(modelPropertiesEditor);
    }

    @Override
    public void setDataModel(DataModelTO dataModel) {

        dataModelBrowser.setDataModel(dataModel);
        dataModelBrowser.setModelerScreenPresenter(presenter);

        dataObjectBrowser.setDataModel(dataModel);
        dataObjectBrowser.setModelerScreenPresenter(presenter);

        modelPropertiesEditor.setDataModel(dataModel);
    }

    @Override
    public void init(final DataModelerScreenPresenter presenter) {
        this.presenter = presenter;
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
