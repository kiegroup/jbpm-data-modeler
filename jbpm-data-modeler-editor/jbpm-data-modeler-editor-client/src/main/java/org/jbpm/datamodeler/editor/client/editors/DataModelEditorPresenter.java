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

import com.google.gwt.user.client.Command;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor.PropertyChangeError;
import org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor.PropertyEditor;
import org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor.PropertyEditorListener;
import org.jbpm.datamodeler.editor.client.type.DataModelResourceType;
import org.jbpm.datamodeler.editor.client.validation.ValidatorCallback;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.annotations.*;
import org.uberfire.client.common.ErrorPopup;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;
import org.uberfire.client.workbench.widgets.menu.MenuFactory;
import org.uberfire.client.workbench.widgets.menu.MenuItem;
import org.uberfire.client.workbench.widgets.menu.Menus;
import org.uberfire.shared.mvp.PlaceRequest;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.uberfire.client.workbench.widgets.menu.MenuFactory.newSimpleItem;


@Dependent
@WorkbenchEditor(identifier = "DataModelEditor", supportedTypes = {DataModelResourceType.class })
public class DataModelEditorPresenter {

    public interface DataModelEditorView
            extends
            UberView<DataModelEditorPresenter> {

        void setDataModel(DataModelTO dataModel);

        void deleteDataObject(DataObjectTO dataObject, int index);

        void addDataObject(DataObjectTO dataObject);

        void modelSelected();

        void selectDataObject(DataObjectTO dataObject, boolean clearBreadcrums);

        void selectDataObjectProperty(ObjectPropertyTO selectedProperty);

        void addDataObjectProperty(ObjectPropertyTO objectProperty);

        void deleteDataObjectProperty(ObjectPropertyTO property, int index);

        void setBaseTypes(List<PropertyTypeTO> baseTypes);

        void refreshObjectEditor();
    }

    @Inject
    private ValidatorService validatorService;

    @Inject
    DataModelEditorView view;

    @Inject
    private Event<NotificationEvent> notification;
    
    private Path path;

    @Inject
    private Caller<DataModelerService> modelerService;

    private Menus menus;

    @Inject
    private DataModelEditorSelectionModel selectionModel;
    
    @WorkbenchPartTitle
    public String getTitle() {
        return Constants.INSTANCE.modelEditor_screen_name() + " [" + (path != null ? path.getFileName() : "") + "]";
    }

    @WorkbenchPartView
    public UberView<DataModelEditorPresenter> getView() {
        return view;
    }

    public DataModelTO getDataModel() {
        return selectionModel.getSelectedModel();
    }

    public void setDataModel(DataModelTO dataModel) {
        selectionModel.setSelectedModel(dataModel);
        validatorService.notifyDataModelSelected(dataModel);
    }

    public Command createDeleteCommand(final DataObjectTO dataObjectTO, final int index) {
        return new Command() {
            @Override
            public void execute() {
                validatorService.isDataObjectDeletable(dataObjectTO, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        ErrorPopup.showMessage("The data object with identifier: " + dataObjectTO.getName() + " cannot be deleted because it is still referenced within the model.");
                    }

                    @Override
                    public void onSuccess() {
                        getDataModel().removeDataObject(dataObjectTO);
                        view.deleteDataObject(dataObjectTO, index);
                        validatorService.notifyDataObjectDeleted(dataObjectTO.getClassName());
                        notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataObject_deleted(dataObjectTO.getName())));
                    }
                });
            }
        };
    }

    public Command createAddDataObjectCommand(final String text) {
        return new Command() {
            @Override
            public void execute() {
                validatorService.isValidIdentifier(text, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        ErrorPopup.showMessage("Invalid data object identifier: " + text + " is not a valid Java identifier");
                    }

                    @Override
                    public void onSuccess() {
                        validatorService.isUniqueEntityName(text, getDataModel(), new ValidatorCallback() {
                            @Override
                            public void onFailure() {
                                ErrorPopup.showMessage("A data object with identifier: " + text + " already exists in the model.");
                            }

                            @Override
                            public void onSuccess() {
                                DataObjectTO dataObject = new DataObjectTO(text);
                                dataObject.setPackageName(getDataModel().getDefaultPackage());
                                getDataModel().getDataObjects().add(dataObject);
                                view.addDataObject(dataObject);
                                selectionModel.setSelectedObject(dataObject);
                                notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataObject_created(text)));
                            }
                        });
                    }
                });
            }
        };
    }

    public Command createModelSelectionCommand() {

        return new Command() {
            @Override
            public void execute() {
                view.modelSelected();
            }
        };
    }

    public Command createSelectCommand(final DataObjectTO selectedObject, final boolean clearBreadcrums) {
        return new Command() {
            @Override
            public void execute() {
                view.selectDataObject(selectedObject, clearBreadcrums);
                selectionModel.setSelectedObject(selectedObject);
            }
        };
    }

    public Command createSelectTypeCommand(final String className) {
        return new Command() {
            @Override
            public void execute() {
                DataObjectTO dataObject = getDataModel().getDataObjectByClassName(className);
                if (dataObject != null) {
                    view.selectDataObject(dataObject, false);
                }
            }
        };
    }

    public Command createSelectCommand(final ObjectPropertyTO selectedProperty) {
        return new Command() {
            @Override
            public void execute() {
                view.selectDataObjectProperty(selectedProperty);
                selectionModel.setSelectedProperty(selectedProperty);
            }
        };
    }

    public Command createDeleteCommand(final DataObjectTO dataObject, final ObjectPropertyTO property, final int index) {
        return new Command() {
            @Override
            public void execute() {
                //TODO implement the required controls to ensure the property can be deleted from the dataObject
                dataObject.getProperties().remove(property);
                view.deleteDataObjectProperty(property, index);
                validatorService.notifyDataObjectUnReferenced(property.getClassName(), dataObject.getClassName());
            }
        };
    }

    public Command createAddDataObjectPropertyCommand(final DataObjectTO dataObject, final String propertyName, final String propertyType, final boolean multiple, final boolean baseType) {

        return new Command() {
            @Override
            public void execute() {
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
                                dataObject.getProperties().add(property);
                                view.addDataObjectProperty(property);
                                selectionModel.setSelectedProperty(property);
                                if (!baseType) validatorService.notifyDataObjectReferenced(property.getClassName(), dataObject.getClassName());
                            }
                        });
                    }
                });
            }
        };
    }
    
    public PropertyEditorListener getDataModelEditorListener() {
        return new PropertyEditorListener() {

            @Override
            public boolean doBeforePropertyChange(PropertyEditor source, String propertyName, Object pendingValue, Object currentValue, List<PropertyChangeError> errors) {

                //TODO Implement validation for model properties
                return true;
            }

            @Override
            public void onPropertyChange(PropertyEditor source, String propertyName, Object newValue, Object currentValue) {
                //TODO Implement model property change
                //Window.alert("model property change, propertyName: " + propertyName + ", newValue: " + newValue + ", currentValue: " + currentValue);
            }
        };
    }

    public PropertyEditorListener getDataObjectEditorListener() {
        return new PropertyEditorListener() {
            @Override
            public boolean doBeforePropertyChange(final PropertyEditor source, final String propertyName, final Object pendingValue, final Object currentValue, final List<PropertyChangeError> errors) {
                validatorService.isValidIdentifier(pendingValue.toString(), new ValidatorCallback() {
                    public boolean returnValue(boolean b) {
                        return b;
                    }

                    @Override
                    public void onFailure() {
                        errors.add(new PropertyChangeError("Invalid data object identifier: " + pendingValue + " is not a valid Java identifier"));
                        returnValue(false);
                    }

                    @Override
                    public void onSuccess() {
                        validatorService.isUniqueEntityName(pendingValue.toString(), getDataModel(), new ValidatorCallback() {
                            @Override
                            public void onFailure() {
                                errors.add(new PropertyChangeError("A data object with identifier: " + pendingValue + " already exists in the model."));
                                returnValue(false);
                            }

                            @Override
                            public void onSuccess() {
                                returnValue(true);
                            }
                        });
                    }
                });
                return false;
            }

            @Override
            public void onPropertyChange(PropertyEditor source, String propertyName, Object newValue, Object currentValue) {
                //TODO Implement model property change
                //Window.alert("data object property change, propertyName: " + propertyName + ", newValue: " + newValue + ", currentValue: " + currentValue);
                changeSelectedDataObjectProperty(propertyName, newValue, currentValue);
            }
        };
    }

    public PropertyEditorListener getDataObjectFieldEditorListener() {
        return new PropertyEditorListener() {

            @Override
            public boolean doBeforePropertyChange(final PropertyEditor source, final String propertyName, final Object pendingValue, final Object currentValue, final List<PropertyChangeError> errors) {
                validatorService.isValidIdentifier(pendingValue.toString(), new ValidatorCallback() {
                    public boolean returnValue(boolean b) {
                        return b;
                    }

                    @Override
                    public void onFailure() {
                        errors.add(new PropertyChangeError("Invalid data object attribute identifier: " + pendingValue + " is not a valid Java identifier"));
                        returnValue(false);
                    }

                    @Override
                    public void onSuccess() {
                        validatorService.isUniqueEntityName(pendingValue.toString(), getDataModel(), new ValidatorCallback() {
                            @Override
                            public void onFailure() {
                                errors.add(new PropertyChangeError("An attribute with identifier: " + pendingValue + " already exists in the data object."));
                                returnValue(false);
                            }

                            @Override
                            public void onSuccess() {
                                returnValue(true);
                            }
                        });
                    }
                });
                return false;
                //TODO Implement validation for the properties of a data object
                //ej...
//                if ("name".equals(propertyName) && ("void".equals(pendingValue) || "int".equals(pendingValue) || "boolean".equals(pendingValue)) ) {
//                    errors.add(new PropertyChangeError("Invalid name"));
//                    return false;
//                }
//
//                return true;
            }

            @Override
            public void onPropertyChange(PropertyEditor source, String propertyName, Object newValue, Object currentValue) {
                //TODO Implement change for a data object property
                //Window.alert("data object field property change, propertyName: " + propertyName + ", newValue: " + newValue + ", currentValue: " + currentValue);
                changeSelectedDataObjectFieldProperty(propertyName, newValue, currentValue);
            }
        };
    }

    private void changeSelectedDataObjectProperty(String propertyName, Object newValue, Object currentValue) {
        //TODO improve this
        if ("name".equals(propertyName)) {
            selectionModel.getSelectedObject().setName(newValue.toString());
        }
        view.refreshObjectEditor();
    }

    private void changeSelectedDataObjectFieldProperty(String propertyName, Object newValue, Object currentValue) {
        //TODO improve this
        if ("name".equals(propertyName)) {
            selectionModel.getSelectedProperty().setName(newValue.toString());
        }
        view.refreshObjectEditor();
    }

    @IsDirty
    public boolean isDirty() {
        //Window.alert("isDirty invoked");
        return false;
    }

    @OnClose
    public void onClose() {
        //Window.alert("onClose invoked");
    }

    @OnFocus
    public void onFocus() {
        //Window.alert("onFocus invoked");
    }

    @OnMayClose
    public boolean onMayClose() {
        //Window.alert("onMayClose");
        return true;
    }

    @OnSave
    public void onSave() {
        modelerService.call(new RemoteCallback<Object>() {
                @Override
                public void callback(Object response) {
                    //when the model is saved without errors
                    //clean the deleted dataobjects status, mark all dataobjects as persisted, etc.
                    restoreModelStatus();
                }
            },
            new DataModelerErrorCallback("An error was produced during data model saving.")
        ).saveModel(getDataModel(), path);
    }

    @OnStart
    public void onStart(Path path, PlaceRequest placeRequest) {

        //The onStart method must read the file and load the DataModel to be edited.
        makeMenuBar();

        this.path = path;

        modelerService.call(
                new RemoteCallback<List<PropertyTypeTO>>() {

                    @Override
                    public void callback(List<PropertyTypeTO> baseTypes) {
                        view.setBaseTypes(baseTypes);
                    }
                },
                new DataModelerErrorCallback("An error was produced when property types was loaded from server.")
        ).getBasePropertyTypes();

        modelerService.call(
                new RemoteCallback<DataModelTO>() {

                    @Override
                    public void callback(DataModelTO dataModel) {
                        setDataModel(dataModel);
                        view.setDataModel(dataModel);
                        notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataModel_loaded(dataModel.getName())));
                    }

                    },
                new DataModelerErrorCallback("An error was produced when the requested data model was loaded from server.")
        ).loadModel(path);
    }

    /**
     * This method generates the model by creating the output pojos to de sources directory.
     */
    void onGenerate() {

        /*
        modelerService.call(new RemoteCallback<Object>() {
            @Override
            public void callback(Object response) {
                notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataModel_generated()));
            }

            },
            new DataModelerErrorCallback("An error was produced during data model generation.")
        ).generateModel(getDataModel(), path);
        */
    }

    @OnReveal
    public void onReveal() {
        //Window.alert("onReveal");
    }

    @WorkbenchMenu
    public Menus getMenus() {
        return menus;
    }

    private void makeMenuBar() {
        menus = MenuFactory
                    .newTopLevelMenu(Constants.INSTANCE.modelEditor_menu_file())
                    .withItems( getItems() )
                    .endMenu().build();
    }

    
    private List<MenuItem> getItems() {

        final List<MenuItem> menuItems = new ArrayList<MenuItem>();

        //TODO take a look at guvnor editors to see if class org.kie.guvnor.commons.ui.client.menu.FileMenuBuilder
        //can be used

        org.uberfire.client.mvp.Command saveCommand = new org.uberfire.client.mvp.Command() {
            @Override
            public void execute() {
                onSave();
            }
        };

        /*
        org.uberfire.client.mvp.Command generateCommand = new org.uberfire.client.mvp.Command() {
            @Override
            public void execute() {
                onGenerate();
            }
        };

        if ( generateCommand != null ) {
            menuItems.add(newSimpleItem(Constants.INSTANCE.modelEditor_menu_generate())
                    .respondsWith(generateCommand)
                    .endMenu().build().getItems().get(0));
        }
        */

        if ( saveCommand != null ) {
            menuItems.add(newSimpleItem(Constants.INSTANCE.modelEditor_menu_save())
                    .respondsWith(saveCommand)
                    .endMenu().build().getItems().get(0));
        }


        return menuItems;
    }

    private void restoreModelStatus() {
        getDataModel().setPersistedStatus();
    }
}

