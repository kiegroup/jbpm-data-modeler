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
import com.github.gwtbootstrap.client.ui.TooltipCellDecorator;
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
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.editors.resources.images.ImagesResources;
import org.jbpm.datamodeler.editor.client.validation.ValidatorCallback;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectFieldDeletedEvent;
import org.jbpm.datamodeler.editor.events.DataObjectFieldSelectedEvent;
import org.jbpm.datamodeler.editor.events.DataObjectSelectedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.uberfire.client.common.ErrorPopup;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataObjectBrowser extends Composite {

    interface DataObjectEditorUIBinder
            extends UiBinder<Widget, DataObjectBrowser> {

    };

    private static DataObjectEditorUIBinder uiBinder = GWT.create(DataObjectEditorUIBinder.class);

    @UiField
    VerticalPanel mainPanel;

    @UiField
    SimplePanel breadCrumbsPanel;

    @Inject
    DataObjectBreadcrums dataObjectNavigation;

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

    final PropertyTypeCell typeCell = new PropertyTypeCell(true, this);

    final SingleSelectionModel<ObjectPropertyTO> selectionModel = new SingleSelectionModel<ObjectPropertyTO>();

    private DataModelTO dataModel;
    
    private DataObjectTO dataObject;

    private ListDataProvider<ObjectPropertyTO> dataObjectPropertiesProvider = new ListDataProvider<ObjectPropertyTO>();

    private List<ObjectPropertyTO> dataObjectProperties = new ArrayList<ObjectPropertyTO>();

    private DataModelEditorPresenter modelEditorPresenter;

    private List<PropertyTypeTO> baseTypes;

    @Inject
    private ValidatorService validatorService;

    @Inject
    Event<DataModelerEvent> dataModelerEvent;

    public DataObjectBrowser() {
        initWidget(uiBinder.createAndBindUi(this));

        objectName.setText(Constants.INSTANCE.objectEditor_objectUnknown());
        dataObjectPropertiesProvider.setList(dataObjectProperties);

        //Init data objects table

        dataObjectPropertiesTable.setEmptyTableWidget(new com.github.gwtbootstrap.client.ui.Label(Constants.INSTANCE.objectEditor_emptyTable()));

        //Init delete column
        ClickableImageResourceCell clickableImageResourceCell = new ClickableImageResourceCell(true);
        final TooltipCellDecorator<ImageResource> decorator = new TooltipCellDecorator<ImageResource>(clickableImageResourceCell);
        decorator.setText(Constants.INSTANCE.objectEditor_action_deleteProperty());

        final Column<ObjectPropertyTO, ImageResource> deletePropertyColumnImg = new Column<ObjectPropertyTO, ImageResource>(decorator) {
            @Override
            public ImageResource getValue( final ObjectPropertyTO global ) {
                return ImagesResources.INSTANCE.Delete();
            }
        };

        deletePropertyColumnImg.setFieldUpdater( new FieldUpdater<ObjectPropertyTO, ImageResource>() {
            public void update( final int index,
                                final ObjectPropertyTO property,
                                final ImageResource value ) {

                deleteDataObjectProperty(property, index);
            }
        } );


        dataObjectPropertiesTable.addColumn(deletePropertyColumnImg);
        dataObjectPropertiesTable.setColumnWidth(deletePropertyColumnImg, 20, Style.Unit.PX);


        //Init property name column

        final TextColumn<ObjectPropertyTO> propertyNameColumn = new TextColumn<ObjectPropertyTO>() {

            @Override
            public void render(Cell.Context context, ObjectPropertyTO object, SafeHtmlBuilder sb) {
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
            public String getValue( final ObjectPropertyTO objectProperty) {
                return objectProperty.getName();
            }
        };


        propertyNameColumn.setSortable(true);
        dataObjectPropertiesTable.addColumn(propertyNameColumn, Constants.INSTANCE.objectEditor_columnName());
        //dataObjectPropertiesTable.setColumnWidth(propertyNameColumn, 100, Style.Unit.PX);


        ColumnSortEvent.ListHandler<ObjectPropertyTO> propertyNameColHandler = new ColumnSortEvent.ListHandler<ObjectPropertyTO>(dataObjectPropertiesProvider.getList());
        propertyNameColHandler.setComparator(propertyNameColumn, new ObjectPropertyComparator("name"));
        dataObjectPropertiesTable.addColumnSortHandler(propertyNameColHandler);

        final Column<ObjectPropertyTO, String> propertyTypeColumn = new Column<ObjectPropertyTO, String>(typeCell)  {

            @Override
            public String getValue(final ObjectPropertyTO objectProperty) {
                return propertyTypeDisplay(objectProperty);
            }

        };
        propertyTypeColumn.setSortable(true);
        dataObjectPropertiesTable.addColumn(propertyTypeColumn, Constants.INSTANCE.objectEditor_columnType());
        //dataObjectPropertiesTable.setColumnWidth(propertyTypeColumn, 100, Style.Unit.PX);


        ColumnSortEvent.ListHandler<ObjectPropertyTO> propertyTypeColHandler = new ColumnSortEvent.ListHandler<ObjectPropertyTO>(dataObjectPropertiesProvider.getList());
        propertyTypeColHandler.setComparator(propertyTypeColumn, new ObjectPropertyComparator("className"));
        dataObjectPropertiesTable.addColumnSortHandler(propertyTypeColHandler);


        dataObjectPropertiesTable.getColumnSortList().push(propertyTypeColumn);
        dataObjectPropertiesTable.getColumnSortList().push(propertyNameColumn);

        //Init the selection model
        dataObjectPropertiesTable.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                ObjectPropertyTO selectedPropertyTO = ((SingleSelectionModel<ObjectPropertyTO>)dataObjectPropertiesTable.getSelectionModel()).getSelectedObject();
                notifyFieldSelected(selectedPropertyTO);
            }
        });

        dataObjectPropertiesTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.BOUND_TO_SELECTION);

        dataObjectPropertiesProvider.addDataDisplay(dataObjectPropertiesTable);
        dataObjectPropertiesProvider.refresh();

        newPropertyIsMultiple.setVisible(false);
        newPropertyIsMultiple.setValue(false);
        newPropertyBasicType.setValue(true);
        newPropertyButton.setIcon(IconType.PLUS_SIGN);
    }
    
    @PostConstruct
    void completeUI() {
        dataObjectNavigation.setDivider(">");
        breadCrumbsPanel.add(dataObjectNavigation);
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
        dataObjectNavigation.setDataModel(dataModel);
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

    private void createNewProperty(final DataObjectTO dataObject, final String propertyName, final String propertyType, final boolean multiple, final boolean baseType) {

        validatorService.isValidIdentifier(propertyName, new ValidatorCallback() {
            @Override
            public void onFailure() {
                ErrorPopup.showMessage("Invalid data object attribute identifier: " + propertyName + " is not a valid Java identifier");
            }

            @Override
            public void onSuccess() {
                validatorService.isUniqueAttributeName(propertyName, dataObject, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        ErrorPopup.showMessage("An attribute with identifier: " + propertyName + " already exists in the data object.");
                    }

                    @Override
                    public void onSuccess() {
                        ObjectPropertyTO property = new ObjectPropertyTO(propertyName, propertyType, multiple, baseType);
                        addDataObjectProperty(property);
                        if (!baseType)
                            validatorService.notifyDataObjectReferenced(property.getClassName(), dataObject.getClassName());
                    }
                });
            }
        });
    }
    
    private void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
        objectName.setText(dataObject.getName() + "::" + dataObject.getPackageName());

        //We create a new selection model due to a bug found in GWT when we change e.g. from one data object with 9 rows
        // to one with 3 rows and the table was sorted.
        //Several tests has been done and the final workaround (not too bad) we found is to
        // 1) sort the table again
        // 2) create a new selection model
        // 3) populate the table with new items
        // 3) select the first row
        dataObjectPropertiesTable.getColumnSortList().push(dataObjectPropertiesTable.getColumn(0));
        SingleSelectionModel selectionModel2 = new SingleSelectionModel<ObjectPropertyTO>();
        dataObjectPropertiesTable.setSelectionModel(selectionModel2);

        selectionModel2.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                ObjectPropertyTO selectedPropertyTO = ((SingleSelectionModel<ObjectPropertyTO>)dataObjectPropertiesTable.getSelectionModel()).getSelectedObject();
                notifyFieldSelected(selectedPropertyTO);
                //Command selectCommand = modelEditorPresenter.createSelectCommand(selectedPropertyTO);
                //selectCommand.execute();
            }
        });

        ArrayList<ObjectPropertyTO> sortBuffer = new ArrayList<ObjectPropertyTO>();
        sortBuffer.addAll(dataObject.getProperties());
        Collections.sort(sortBuffer, new ObjectPropertyComparator("name"));

        dataObjectProperties = dataObject.getProperties();
        dataObjectPropertiesProvider.getList().clear();
        dataObjectPropertiesProvider.getList().addAll(sortBuffer);
        dataObjectPropertiesProvider.flush();
        dataObjectPropertiesProvider.refresh();

        dataObjectPropertiesTable.getColumnSortList().push(dataObjectPropertiesTable.getColumn(0));

        if (dataObjectProperties.size() > 0) {
            dataObjectPropertiesTable.setKeyboardSelectedRow(0);
            selectionModel2.setSelected(sortBuffer.get(0), true);
        }

        //set the first row selected again. Sounds crazy, but's part of the workaround, don't remove this line.
        if (dataObjectProperties.size() > 0) {
            dataObjectPropertiesTable.setKeyboardSelectedRow(0);
        }

        ColumnSortEvent.fire(dataObjectPropertiesTable, dataObjectPropertiesTable.getColumnSortList());
        if (dataObjectProperties.size() == 0) {
            //there are no properties.
            //fire an empty property seleccion event in order to notify the
            notifyFieldSelected(null);
        }
    }

    private void addDataObjectProperty(ObjectPropertyTO objectProperty) {
        dataObject.getProperties().add(objectProperty);
        dataObjectPropertiesProvider.getList().add(objectProperty);
        dataObjectPropertiesProvider.flush();
        dataObjectPropertiesProvider.refresh();
        dataObjectPropertiesTable.setKeyboardSelectedRow(dataObjectPropertiesProvider.getList().size() - 1);
    }

    private void deleteDataObjectProperty(ObjectPropertyTO objectProperty, int index) {
        
        dataObject.getProperties().remove(objectProperty);
        dataObjectPropertiesProvider.getList().remove(index);
        dataObjectPropertiesProvider.flush();
        dataObjectPropertiesProvider.refresh();
        validatorService.notifyDataObjectUnReferenced(objectProperty.getClassName(), dataObject.getClassName());
        notifyFieldDeleted(objectProperty);

    }

    public void setModelEditorPresenter(DataModelEditorPresenter modelEditorPresenter) {
        this.modelEditorPresenter = modelEditorPresenter;
    }

    public DataModelEditorPresenter getModelEditorPresenter() {
        return modelEditorPresenter;
    }

    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        this.baseTypes = baseTypes;
        populateBaseTypes();
    }

    public void refresh() {
        dataObjectPropertiesProvider.refresh();
    }

    private String propertyTypeDisplay(ObjectPropertyTO propertyTO) {
        String className = propertyTO.getClassName();
        if (propertyTO.isMultiple()) {
            className += "[1..N]";
        }
        return className;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public DataObjectTO getDataObject() {
        return dataObject;
    }

    public void onTypeCellSelection(ObjectPropertyTO property) {

        DataObjectTO dataObject = dataModel.getDataObjectByClassName(property.getClassName());
        if (dataObject != null) {
            notifyObjectSelected(dataObject);
        }
    }

    //Event handlers

    @UiHandler("newPropertyButton")
    void newPropertyClick(ClickEvent event) {
        createNewProperty(dataObject, newPropertyName.getText(), newPropertyType.getValue(), newPropertyIsMultiple.getValue(), newPropertyBasicType.getValue());
    }

    @UiHandler("newPropertyDataObjectType")
    void dataObjectTypeSelected(ClickEvent event) {
        newPropertyIsMultiple.setVisible(true);
        populateObjectTypes();
    }

    @UiHandler("newPropertyBasicType")
    void basicTypeSelected(ClickEvent event) {
        newPropertyIsMultiple.setVisible(false);
        newPropertyIsMultiple.setValue(false);
        populateBaseTypes();
    }

    //Event Observers

    private void onDataObjectSelected(@Observes DataObjectSelectedEvent event) {
        if (event.isFrom(getDataModel())) {
            if (event.getCurrentDataObject() != null) {
                setDataObject(event.getCurrentDataObject());
            } else {
                //TODO clear the editor because any object is selected
                //this is the case when we are deleting the objects
                //and the las object is deleted
            }
        }
    }


    // Event notifications
    private void notifyFieldSelected(ObjectPropertyTO selectedPropertyTO) {
        dataModelerEvent.fire(new DataObjectFieldSelectedEvent(DataModelerEvent.DATA_OBJECT_BROWSER, getDataModel(), getDataObject(), selectedPropertyTO));
    }

    private void notifyFieldDeleted(ObjectPropertyTO deletedPropertyTO) {
        dataModelerEvent.fire(new DataObjectFieldDeletedEvent(DataModelerEvent.DATA_OBJECT_BROWSER, getDataModel(), getDataObject(), deletedPropertyTO));
    }

    private void notifyObjectSelected(DataObjectTO dataObject) {
        dataModelerEvent.fire(new DataObjectSelectedEvent(DataModelerEvent.DATA_OBJECT_BROWSER, getDataModel(), dataObject));
    }

}
