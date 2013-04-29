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
import com.google.gwt.user.client.Window;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.type.DataModelResourceType;
import org.jbpm.datamodeler.editor.client.validation.ValidatorCallback;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectCreatedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.annotations.*;
import org.uberfire.client.common.BusyPopup;
import org.uberfire.client.common.ErrorPopup;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;
import org.uberfire.client.workbench.widgets.menu.MenuFactory;
import org.uberfire.client.workbench.widgets.menu.MenuItem;
import org.uberfire.client.workbench.widgets.menu.Menus;
import org.uberfire.client.workbench.widgets.toolbar.ToolBar;
import org.uberfire.client.workbench.widgets.toolbar.ToolBarItem;
import org.uberfire.client.workbench.widgets.toolbar.impl.DefaultToolBar;
import org.uberfire.client.workbench.widgets.toolbar.impl.DefaultToolBarItem;
import org.uberfire.shared.mvp.PlaceRequest;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.uberfire.client.workbench.widgets.menu.MenuFactory.newSimpleItem;
import static org.uberfire.client.workbench.widgets.toolbar.IconType.TABLE;


@Dependent
@WorkbenchEditor(identifier = "DataModelEditor", supportedTypes = {DataModelResourceType.class })
public class DataModelEditorPresenter {

    public interface DataModelEditorView
            extends
            UberView<DataModelEditorPresenter> {

        void setDataModel(DataModelTO dataModel);

        void setBaseTypes(List<PropertyTypeTO> baseTypes);

        void refreshObjectEditor();
    }

    @Inject
    private DataModelEditorView view;

    @Inject
    private Caller<DataModelerService> modelerService;

    @Inject
    private ValidatorService validatorService;

    private Menus menus;

    private ToolBar toolBar;

    @Inject
    private DataModelEditorSelectionModel selectionModel;

    @Inject
    Event<DataModelerEvent> dataModelerEventEvent;

    @Inject
    private Event<NotificationEvent> notification;

    private Path path;
    
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

    private void setDataModel(DataModelTO dataModel) {
        selectionModel.setSelectedModel(dataModel);
        validatorService.notifyDataModelSelected(dataModel);
        view.setDataModel(dataModel);

        if (dataModel != null && dataModel.getDataObjects().size() > 0) {
            //TODO notificar para que se seleccione el primero objeto de la lista?
        }
    }

    public Command createAddDataObjectCommand(final String packageName, final String name, final String superClassName) {
        return new Command() {

            //TODO validate that the package name is a valid java package name

            @Override
            public void execute() {
                //TODO this method remains here by now until we decide if a data object can be created from different
                //IU places. (toolbar, menu, and current button)

                validatorService.isValidIdentifier(name, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        ErrorPopup.showMessage("Invalid data object identifier: " + name + " is not a valid Java identifier");
                    }

                    @Override
                    public void onSuccess() {

                        //TODO if whe have a valid packageName and a valid class name
                        //we can proceed to uniqueEntiyName validation

                        //TODO dejar esto prolijo
                        validatorService.isUniqueEntityName(packageName, name, getDataModel(), new ValidatorCallback() {
                            @Override
                            public void onFailure() {
                                ErrorPopup.showMessage("A data object with identifier: " + name + " already exists in the model.");
                            }

                            @Override
                            public void onSuccess() {
                                DataObjectTO dataObject = new DataObjectTO(name);
                                dataObject.setPackageName(getDataModel().getDefaultPackage());
                                getDataModel().getDataObjects().add(dataObject);

                                //view.addDataObject(dataObject);
                                selectionModel.setSelectedObject(dataObject);

                                notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataObject_created(name)));
                                dataModelerEventEvent.fire(new DataObjectCreatedEvent("", getDataModel(), dataObject));

                            }
                        });
                    }
                });
            }
        };
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
        makeToolBar();

        this.path = path;
        loadContent(path);
    }

    private void loadContent(Path path) {

        BusyPopup.showMessage("Loading datamodel");

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
                        BusyPopup.close();
                        setDataModel(dataModel);
                        notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataModel_loaded(dataModel.getName())));
                    }

                },
                new DataModelerErrorCallback("An error was produced when the requested data model was loaded from server.")
        ).loadModel(path);
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

    @WorkbenchToolBar
    public ToolBar getToolBar() {
        return this.toolBar;
    }

    private void makeToolBar() {
        toolBar = new DefaultToolBar( "dataModeler" );


        org.uberfire.client.mvp.Command newDataObjectCommand = new org.uberfire.client.mvp.Command() {
            @Override
            public void execute() {
                Window.alert("Create new data object from the toolbar?");
            }
        };

        org.uberfire.client.mvp.Command newDataObjectPropertyCommand = new org.uberfire.client.mvp.Command() {
            @Override
            public void execute() {
                Window.alert("Create new property from the toolbar?");
            }
        };


        ToolBarItem item = new DefaultToolBarItem( TABLE, "New Data Object", newDataObjectCommand);
        toolBar.addItem(item);


        item = new DefaultToolBarItem( TABLE, "New Data Object Property", newDataObjectPropertyCommand);
        toolBar.addItem(item);


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

