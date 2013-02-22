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

import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.TooltipCellDecorator;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.TextHeader;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

import java.util.ArrayList;
import java.util.List;


public class DataModelBrowser extends Composite {

    interface DataModelBrowserUIBinder
            extends UiBinder<Widget, DataModelBrowser> {

    };

    private static DataModelBrowserUIBinder uiBinder = GWT.create(DataModelBrowserUIBinder.class);

    @UiField
    VerticalPanel mainPanel;
    
    @UiField Label modelName;

    @UiField
    CellTable<DataObjectTO> dataObjectsTable;

    @UiField
    TextBox newEntityName;

    @UiField
    com.github.gwtbootstrap.client.ui.Button newEntityButton;

    private DataModelTO dataModel;

    private ListDataProvider<DataObjectTO> dataObjectsProvider = new ListDataProvider<DataObjectTO>();

    private List<DataObjectTO> dataObjects = new ArrayList<DataObjectTO>();

    private DataModelEditorPresenter modelEditorPresenter;

    public DataModelBrowser(DataModelEditorPresenter modelEditorPresenter) {
        this.modelEditorPresenter = modelEditorPresenter;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
        this.dataObjects = dataModel.getDataObjects();

        dataObjectsProvider.setList(dataModel.getDataObjects());
        dataObjectsProvider.flush();
        dataObjectsProvider.refresh();
    }

    public DataModelBrowser() {
        initWidget(uiBinder.createAndBindUi(this));

        modelName.setText("The model name");

        //Init data objects table

        dataObjectsTable.setEmptyTableWidget( new com.github.gwtbootstrap.client.ui.Label( "Empty table" ) );

        //init data objects table columns
        final TextColumn<DataObjectTO> dataObjectColumn = new TextColumn<DataObjectTO>() {

            @Override
            public String getValue( final DataObjectTO dataObject) {
                return dataObject.getName();
            }
        };

        final com.github.gwtbootstrap.client.ui.ButtonCell deleteDataObjectButton = new com.github.gwtbootstrap.client.ui.ButtonCell();
        deleteDataObjectButton.setType( ButtonType.DEFAULT );
        deleteDataObjectButton.setIcon( IconType.REMOVE );

        final TooltipCellDecorator<String> decorator = new TooltipCellDecorator<String>(deleteDataObjectButton);
        decorator.setText("click to delete this data object");
        
        final Column<DataObjectTO, String> deleteDataObjectColumn = new Column<DataObjectTO, String>(deleteDataObjectButton) {
            @Override
            public String getValue( final DataObjectTO global ) {
                return "";
            }
        };
        deleteDataObjectColumn.setFieldUpdater( new FieldUpdater<DataObjectTO, String>() {
            public void update( final int index,
                                final DataObjectTO object,
                                final String value ) {

                Command deleteCommand = modelEditorPresenter.createDeleteCommand(object, index);
                deleteCommand.execute();
            }
        } );
        
        dataObjectsTable.addColumn(deleteDataObjectColumn);
        dataObjectsTable.addColumn(dataObjectColumn);


        //Init the selection model
        final SingleSelectionModel<DataObjectTO> selectionModel = new SingleSelectionModel<DataObjectTO>();

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                DataObjectTO selectedObjectTO = selectionModel.getSelectedObject();
                //Window.alert("The selected entity is: " + selectedObjectTO.getName());
                Command selectCommand = modelEditorPresenter.createSelectCommand(selectedObjectTO);
                selectCommand.execute();
            }
        });

        dataObjectsTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.BOUND_TO_SELECTION);
        dataObjectsTable.setSelectionModel(selectionModel);
        

        dataObjectsProvider.addDataDisplay(dataObjectsTable);
        dataObjectsProvider.setList(dataObjects);
        dataObjectsProvider.refresh();
    }

    @UiHandler("newEntityButton")
    void newEntityClick( ClickEvent event ) {
        Command addCommand = modelEditorPresenter.createAddDataObjectCommand(newEntityName.getText());
        addCommand.execute();
    }

    @UiHandler("modelName")
    void modelSelected( ClickEvent event) {
        Command modelSelectedCommand = modelEditorPresenter.createModelSelectionCommand();        
        //Window.alert("Model clicked: " + event.getSource());
        modelSelectedCommand.execute();
    }

    public void deleteDataObject(DataObjectTO dataObject, int index) {
        dataObjectsProvider.getList().remove(dataObject);
        dataObjectsProvider.flush();
        dataObjectsProvider.refresh();
    }
    
    public void addDataObject(DataObjectTO dataObject) {
        dataObjectsProvider.getList().add(new DataObjectTO(newEntityName.getText()));
        dataObjectsProvider.flush();
        dataObjectsProvider.refresh();
    }

    public DataModelEditorPresenter getModelEditorPresenter() {
        return modelEditorPresenter;
    }

    public void setModelEditorPresenter(DataModelEditorPresenter modelEditorPresenter) {
        this.modelEditorPresenter = modelEditorPresenter;
    }
}