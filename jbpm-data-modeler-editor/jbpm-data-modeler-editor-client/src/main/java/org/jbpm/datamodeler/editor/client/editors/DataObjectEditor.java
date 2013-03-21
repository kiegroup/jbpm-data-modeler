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

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.editors.resources.images.ImagesResources;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DataObjectEditor  extends Composite {

    interface DataObjectEditorUIBinder
            extends UiBinder<Widget, DataObjectEditor> {

    };

    private static DataObjectEditorUIBinder uiBinder = GWT.create(DataObjectEditorUIBinder.class);

    @UiField
    VerticalPanel mainPanel;

    @UiField
    Label objectName;

    @UiField(provided = true)
    CellTable<ObjectPropertyTO> dataObjectPropertiesTable = new CellTable<ObjectPropertyTO>(1000, GWT.<CellTable.SelectableResources>create(CellTable.SelectableResources.class));

    @UiField
    TextBox newPropertyName;

    @UiField
    com.github.gwtbootstrap.client.ui.ListBox newPropertyType;

    @UiField
    Button newPropertyButton;

    @UiField
    com.github.gwtbootstrap.client.ui.RadioButton newPropertyBasicType;

    @UiField
    com.github.gwtbootstrap.client.ui.RadioButton newPropertyDataObjectType;

    @UiField
    com.github.gwtbootstrap.client.ui.CheckBox newPropertyIsMultiple;

    //@UiField(provided = true)
    //SimplePager pager = new SimplePager(SimplePager.TextLocation.RIGHT, false, true);

    final SingleSelectionModel<ObjectPropertyTO> selectionModel = new SingleSelectionModel<ObjectPropertyTO>();

    private DataModelTO dataModel;
    
    private DataObjectTO dataObject;

    private ListDataProvider<ObjectPropertyTO> dataObjectPropertiesProvider = new ListDataProvider<ObjectPropertyTO>();

    private List<ObjectPropertyTO> dataObjectProperties = new ArrayList<ObjectPropertyTO>();

    private DataModelEditorPresenter modelEditorPresenter;

    private List<PropertyTypeTO> baseTypes;

    public DataObjectEditor() {
        initWidget(uiBinder.createAndBindUi(this));


        objectName.setText(Constants.INSTANCE.objectEditor_objectUnknown());
        dataObjectPropertiesProvider.setList(dataObjectProperties);

        //Init data objects table

        dataObjectPropertiesTable.setEmptyTableWidget(new com.github.gwtbootstrap.client.ui.Label(Constants.INSTANCE.objectEditor_emptyTable()));


        //Init delete column
        Column<ObjectPropertyTO, ImageResource> deletePropertyColumn = new Column<ObjectPropertyTO, ImageResource>(new ClickableImageResourceCell(true)) {

            @Override
            public ImageResource getValue(ObjectPropertyTO objectProperty) {
                return ImagesResources.INSTANCE.Delete();
            }
        };

        deletePropertyColumn.setFieldUpdater(new FieldUpdater<ObjectPropertyTO, ImageResource>() {

            @Override
            public void update(final int index,
                               final ObjectPropertyTO objectProperty,
                               final ImageResource value) {

                Command deleteCommand = modelEditorPresenter.createDeleteCommand(dataObject, objectProperty, index);
                deleteCommand.execute();
            }
        });

        /*
        final com.github.gwtbootstrap.client.ui.ButtonCell deletePropertyButton = new com.github.gwtbootstrap.client.ui.ButtonCell();
        deletePropertyButton.setType( ButtonType.DEFAULT );
        deletePropertyButton.setIcon( IconType.REMOVE );

        final TooltipCellDecorator<String> decorator = new TooltipCellDecorator<String>(deletePropertyButton);
        decorator.setText("click to delete this property");

        final Column<ObjectPropertyTO, String> deletePropertyColumn = new Column<ObjectPropertyTO, String>(decorator) {
            @Override
            public String getValue( final ObjectPropertyTO global ) {
                return "";
            }
        };
        deletePropertyColumn.setFieldUpdater( new FieldUpdater<ObjectPropertyTO, String>() {
            public void update( final int index,
                                final ObjectPropertyTO property,
                                final String value ) {

                Command deleteCommand = modelEditorPresenter.createDeleteCommand(dataObject, property, index);
                deleteCommand.execute();
            }
        } );
        */

        dataObjectPropertiesTable.addColumn(deletePropertyColumn);
        dataObjectPropertiesTable.setColumnWidth(deletePropertyColumn, 20, Style.Unit.PX);


        //Init property name column
        final TextColumn<ObjectPropertyTO> propertyNameColumn = new TextColumn<ObjectPropertyTO>() {

            @Override
            public String getValue( final ObjectPropertyTO objectProperty) {
                return objectProperty.getName();
            }
        };

        propertyNameColumn.setSortable(true);
        dataObjectPropertiesTable.addColumn(propertyNameColumn, Constants.INSTANCE.objectEditor_columnName());

        ColumnSortEvent.ListHandler<ObjectPropertyTO> propertyNameColHandler = new ColumnSortEvent.ListHandler<ObjectPropertyTO>(dataObjectPropertiesProvider.getList());
        propertyNameColHandler.setComparator(propertyNameColumn, new Comparator<ObjectPropertyTO>() {

            @Override
            public int compare(ObjectPropertyTO o1, ObjectPropertyTO o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        dataObjectPropertiesTable.addColumnSortHandler(propertyNameColHandler);


        //Init property type column
        final TextColumn<ObjectPropertyTO> propertyTypeColumn = new TextColumn<ObjectPropertyTO>() {

            @Override
            public String getValue(final ObjectPropertyTO objectProperty) {
                return propertyTypeDisplay(objectProperty);
            }
        };

        propertyTypeColumn.setSortable(true);
        dataObjectPropertiesTable.addColumn(propertyTypeColumn, Constants.INSTANCE.objectEditor_columnType());

        ColumnSortEvent.ListHandler<ObjectPropertyTO> propertyTypeColHandler = new ColumnSortEvent.ListHandler<ObjectPropertyTO>(dataObjectPropertiesProvider.getList());
        propertyTypeColHandler.setComparator(propertyTypeColumn, new Comparator<ObjectPropertyTO>() {

            @Override
            public int compare(ObjectPropertyTO o1, ObjectPropertyTO o2) {
                return o1.getName() .compareTo(o2.getClassName());
            }
        });
        dataObjectPropertiesTable.addColumnSortHandler(propertyTypeColHandler);


        dataObjectPropertiesTable.getColumnSortList().push(propertyTypeColumn);
        dataObjectPropertiesTable.getColumnSortList().push(propertyNameColumn);


        //Init the selection model
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                ObjectPropertyTO selectedPropertyTO = selectionModel.getSelectedObject();
                Command selectCommand = modelEditorPresenter.createSelectCommand(selectedPropertyTO);
                selectCommand.execute();
            }
        });

        dataObjectPropertiesTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.BOUND_TO_SELECTION);
        dataObjectPropertiesTable.setSelectionModel(selectionModel);


        //pager.setDisplay(dataObjectPropertiesTable);
        //pager.setPageSize(10);

        dataObjectPropertiesProvider.addDataDisplay(dataObjectPropertiesTable);
        dataObjectPropertiesProvider.refresh();

        newPropertyIsMultiple.setVisible(false);
        newPropertyBasicType.setValue(true);
        newPropertyButton.setIcon(IconType.PLUS_SIGN);
    }

    private void populateBaseTypes() {
        newPropertyType.clear();
        for (PropertyTypeTO type : baseTypes) {
            newPropertyType.addItem(type.getName(), type.getClassName());
        }
    }

    private void populateObjectTypes() {
        List<DataObjectTO> dataObjects = dataModel.getDataObjects();
        newPropertyType.clear();
        for (DataObjectTO dataObject : dataObjects) {
            newPropertyType.addItem(dataObject.getName(), dataObject.getClassName());
        }        
    }

    @UiHandler("newPropertyButton")
    void newPropertyClick(ClickEvent event) {
        Command createPropertyCommand = modelEditorPresenter.createAddDataObjectPropertyCommand(dataObject, newPropertyName.getText(), newPropertyType.getValue(), newPropertyIsMultiple.getValue());
        createPropertyCommand.execute();
    }

    @UiHandler("newPropertyDataObjectType")
    void dataObjectTypeSelected(ClickEvent event) {
        newPropertyIsMultiple.setVisible(true);
        populateObjectTypes();
    }

    @UiHandler("newPropertyBasicType")
    void basicTypeSelected(ClickEvent event) {
        newPropertyIsMultiple.setVisible(false);
        populateBaseTypes();
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }

    public void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
        objectName.setText(dataObject.getName());

        dataObjectProperties = dataObject.getProperties();
        dataObjectPropertiesProvider.getList().clear();
        dataObjectPropertiesProvider.getList().addAll(dataObjectProperties);
        dataObjectPropertiesProvider.flush();
        dataObjectPropertiesProvider.refresh();
        selectionModel.clear();
    }

    public void addDataObjectProperty(ObjectPropertyTO objectProperty) {
        dataObjectPropertiesProvider.getList().add(objectProperty);
        dataObjectPropertiesProvider.flush();
        dataObjectPropertiesProvider.refresh();
    }

    public void deleteDataObjectProperty(ObjectPropertyTO objectProperty, int index) {
        dataObjectPropertiesProvider.getList().remove(index);
        dataObjectPropertiesProvider.flush();
        dataObjectPropertiesProvider.refresh();
    }

    public void setModelEditorPresenter(DataModelEditorPresenter modelEditorPresenter) {
        this.modelEditorPresenter = modelEditorPresenter;
    }

    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        this.baseTypes = baseTypes;
        populateBaseTypes();
    }
    
    private String propertyTypeDisplay(ObjectPropertyTO propertyTO) {
        String className = propertyTO.getClassName();
        if (propertyTO.isMultiple()) {
            className += "[1..N]";
        }
        return className;
    }
}
