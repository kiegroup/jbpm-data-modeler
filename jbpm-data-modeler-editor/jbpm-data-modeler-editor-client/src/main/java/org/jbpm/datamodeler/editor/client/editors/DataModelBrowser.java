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
import com.github.gwtbootstrap.client.ui.SimplePager;
import com.github.gwtbootstrap.client.ui.TooltipCellDecorator;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import org.jbpm.datamodeler.editor.client.editors.resources.images.ImagesResources;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
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

    @UiField(provided = true)
    CellTable<DataObjectTO> dataObjectsTable = new CellTable<DataObjectTO>(10, GWT.<CellTable.SelectableResources>create(CellTable.SelectableResources.class));

    @UiField
    TextBox newEntityName;

    @UiField
    com.github.gwtbootstrap.client.ui.Button newEntityButton;

    @UiField(provided = true)
    SimplePager pager = new SimplePager(SimplePager.TextLocation.RIGHT, false, true);

    SingleSelectionModel<DataObjectTO> selectionModel = new SingleSelectionModel<DataObjectTO>();

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

        modelName.setText(dataModel.getName());
        dataObjectsProvider.getList().clear();
        dataObjectsProvider.getList().addAll(dataObjects);
        dataObjectsProvider.flush();
        dataObjectsProvider.refresh();
    }

    public DataModelBrowser() {
        initWidget(uiBinder.createAndBindUi(this));

        modelName.setText(Constants.INSTANCE.modelBrowser_modelUnknown());
        dataObjectsProvider.addDataDisplay(dataObjectsTable);

        //Init delete column

        ClickableImageResourceCell clickableImageResourceCell = new ClickableImageResourceCell(true);
        final TooltipCellDecorator<ImageResource> decorator = new TooltipCellDecorator<ImageResource>(clickableImageResourceCell);
        decorator.setText("delete data object");

        final Column<DataObjectTO, ImageResource> deleteDataObjectColumnImg = new Column<DataObjectTO, ImageResource>(decorator) {
            @Override
            public ImageResource getValue( final DataObjectTO global ) {
                return ImagesResources.INSTANCE.Delete();
            }
        };

        deleteDataObjectColumnImg.setFieldUpdater( new FieldUpdater<DataObjectTO, ImageResource>() {
            public void update( final int index,
                                final DataObjectTO object,
                                final ImageResource value ) {

                Command deleteCommand = modelEditorPresenter.createDeleteCommand(object, index);
                deleteCommand.execute();
            }
        } );

        /*
        Column<DataObjectTO, ImageResource> deleteDataObjectColumn = new Column<DataObjectTO, ImageResource>(new ClickableImageResourceCell(true)) {

            @Override
            public ImageResource getValue(DataObjectTO dataObject) {
                return ImagesResources.INSTANCE.Delete();
            }
        };

        deleteDataObjectColumn.setFieldUpdater( new FieldUpdater<DataObjectTO, ImageResource>() {

            @Override
            public void update( final int index,
                                final DataObjectTO object,
                                final ImageResource value ) {

                Command deleteCommand = modelEditorPresenter.createDeleteCommand(object, index);
                deleteCommand.execute();
            }
        } );
        */

        //Init data object column
        final TextColumn<DataObjectTO> dataObjectColumn = new TextColumn<DataObjectTO>() {

            @Override
            public void render(Cell.Context context, DataObjectTO object, SafeHtmlBuilder sb) {
                SafeHtml startDiv = new SafeHtml() {
                    @Override
                    public String asString() {
                        return "<div style=\"cursor: pointer;\">";
                    }
                };
                SafeHtml endDiv = new SafeHtml() {
                    @Override
                    public String asString() {
                        return "</div>";
                    }
                };

                sb.append(startDiv);
                super.render(context, object, sb);
                sb.append(endDiv);
            }

            @Override
            public String getValue( final DataObjectTO dataObject) {
                return dataObject.getName();
            }
        };

        //add columns
        dataObjectsTable.setEmptyTableWidget( new com.github.gwtbootstrap.client.ui.Label(Constants.INSTANCE.modelBrowser_emptyTable()));

        dataObjectsTable.addColumn(deleteDataObjectColumnImg);
        dataObjectsTable.setColumnWidth(deleteDataObjectColumnImg, 20, Style.Unit.PX);
        dataObjectsTable.addColumn(dataObjectColumn);

        //Init the selection model
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                DataObjectTO selectedObjectTO = selectionModel.getSelectedObject();
                Command selectCommand = modelEditorPresenter.createSelectCommand(selectedObjectTO);
                selectCommand.execute();
            }
        });


        dataObjectsTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.BOUND_TO_SELECTION);
        dataObjectsTable.setSelectionModel(selectionModel);

        pager.setDisplay(dataObjectsTable);
        pager.setPageSize(10);

        dataObjectsProvider.setList(dataObjects);
        dataObjectsProvider.refresh();
        //selectionModel.clear();

        newEntityButton.setIcon(IconType.PLUS_SIGN);
    }

    @UiHandler("newEntityButton")
    void newEntityClick( ClickEvent event ) {
        Command addCommand = modelEditorPresenter.createAddDataObjectCommand(newEntityName.getText());
        addCommand.execute();
    }

    @UiHandler("modelName")
    void modelSelected( ClickEvent event) {
        Command modelSelectedCommand = modelEditorPresenter.createModelSelectionCommand();        
        modelSelectedCommand.execute();
    }

    public void deleteDataObject(DataObjectTO dataObject, int index) {
        dataObjectsProvider.getList().remove(index);
        dataObjectsProvider.flush();
        dataObjectsProvider.refresh();
    }
    
    public void addDataObject(DataObjectTO dataObject) {
        dataObjectsProvider.getList().add(dataObject);
        dataObjectsProvider.flush();
        dataObjectsProvider.refresh();

        //Workaround, to enable the selection of the last created object.
        //TODO review this later
        selectionModel = new SingleSelectionModel<DataObjectTO>();
        //Init the selection model
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                DataObjectTO selectedObjectTO = selectionModel.getSelectedObject();
                Command selectCommand = modelEditorPresenter.createSelectCommand(selectedObjectTO);
                selectCommand.execute();
            }
        });


        dataObjectsTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.BOUND_TO_SELECTION);
        dataObjectsTable.setSelectionModel(selectionModel);

        selectionModel.setSelected(dataObject, true);
        //this method is invoked to ensure that de selection updates
        selectionModel.getSelectedObject();
    }

    public DataModelEditorPresenter getModelEditorPresenter() {
        return modelEditorPresenter;
    }

    public void setModelEditorPresenter(DataModelEditorPresenter modelEditorPresenter) {
        this.modelEditorPresenter = modelEditorPresenter;
    }

}