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
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.annotations.*;
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

    }

    @Inject
    DataModelEditorView view;

    @Inject
    private Event<NotificationEvent> notification;

    private DataModelTO dataModel;
    
    private Path path;

    @Inject
    private Caller<DataModelerService> modelerService;

    private Menus menus;
    
    @WorkbenchPartTitle
    public String getTitle() {
        return Constants.INSTANCE.modelEditor_screen_name() + " [" + (path != null ? path.getFileName() : "") + "]";
    }

    @WorkbenchPartView
    public UberView<DataModelEditorPresenter> getView() {
        return view;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }

    public Command createDeleteCommand(final DataObjectTO dataObjectTO, final int index) {
        return new Command() {
            @Override
            public void execute() {

                //TODO implement the required controls to ensure the requested object can be deleted
                dataModel.getDataObjects().remove(dataObjectTO);
                view.deleteDataObject(dataObjectTO, index);
                notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataObject_deleted(dataObjectTO.getName())));
            }
        };
    }

    public Command createAddDataObjectCommand(final String text) {

        return new Command() {
            @Override
            public void execute() {

                //TODO implement the required controls to ensure the name valid, etc.
                DataObjectTO dataObject = new DataObjectTO(text);
                dataObject.setPackageName(dataModel.getDefaultPackage());
                dataModel.getDataObjects().add(dataObject);
                view.addDataObject(dataObject);
                notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataObject_created(text)));
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
            }
        };
    }

    public Command createSelectTypeCommand(final String className) {
        return new Command() {
            @Override
            public void execute() {
                DataObjectTO dataObject = dataModel.getDataObjectByClassName(className);
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
            }
        };
    }

    public Command createAddDataObjectPropertyCommand(final DataObjectTO dataObject, final String propertyName, final String propertyType, final boolean multiple, final boolean baseType) {

        return new Command() {
            @Override
            public void execute() {
                //TODO implement the required controls to ensure the property can be created
                ObjectPropertyTO property = new ObjectPropertyTO(propertyName, propertyType, multiple, baseType);
                dataObject.getProperties().add(property);
                view.addDataObjectProperty(property);
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


                }
            },
            new DataModelerErrorCallback("An error was produced during data model saving.")
        ).saveModel(dataModel, path);
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

        modelerService.call(new RemoteCallback<Object>() {
            @Override
            public void callback(Object response) {
                notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataModel_generated()));
            }
        },
                new DataModelerErrorCallback("An error was produced during data model generation.")
        ).generateModel(dataModel, path);
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

        if ( saveCommand != null ) {
            menuItems.add(newSimpleItem(Constants.INSTANCE.modelEditor_menu_save())
                    .respondsWith(saveCommand)
                    .endMenu().build().getItems().get(0));
        }


        return menuItems;
    }
}

