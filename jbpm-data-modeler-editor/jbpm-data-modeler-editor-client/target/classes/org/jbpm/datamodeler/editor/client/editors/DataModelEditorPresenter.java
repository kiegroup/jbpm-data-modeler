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
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Dependent
@WorkbenchScreen(identifier = "DataModelEditor")
public class DataModelEditorPresenter {

    public interface DataModelEditorView
            extends
            UberView<DataModelEditorPresenter> {

        void deleteDataObject(DataObjectTO dataObject, int index);

        void addDataObject(String text);

        void modelSelected();

        void selectDataObject(DataObjectTO dataObject);

        void selectDataObjectProperty(ObjectPropertyTO selectedProperty);

        void addDataObjectProperty(ObjectPropertyTO objectProperty);

        void deleteDataObjectProperty(ObjectPropertyTO property, int index);
    }

    @Inject
    DataModelEditorView view;

    @Inject
    private Event<NotificationEvent> notification;

    private DataModelTO dataModel;


    @PostConstruct
    public void init() {

        //TODO: implement the correct model loading
        dataModel = new DataModelTO("TestModel");
        List<DataObjectTO> dataObjects = new ArrayList<DataObjectTO>();
        for (int i=0; i< 10 ; i++) {
            dataObjects.add(new DataObjectTO(i));
        }
        dataModel.setDataObjects(dataObjects);
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Data model editor";
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

                //Window.alert("Aqui controlamos si el dataobject es puede borrar, si se puede, entones a la vista");
                view.deleteDataObject(dataObjectTO, index);
                notification.fire(new NotificationEvent("Data object: " + dataObjectTO.getName() + " was deleted"));
            }
        };
    }

    public Command createAddDataObjectCommand(final String text) {

        return new Command() {
            @Override
            public void execute() {

                //Window.alert("Aqui controlamos si el nombre es correcto");
                view.addDataObject(text);
                notification.fire(new NotificationEvent("Data object: " + text + " was created"));
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

    public Command createSelectCommand(final DataObjectTO selectedObject) {
        return new Command() {
            @Override
            public void execute() {
                view.selectDataObject(selectedObject);
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

    public Command createDeleteCommand(final ObjectPropertyTO property, final int index) {
        return new Command() {
            @Override
            public void execute() {

                view.deleteDataObjectProperty(property, index);
            }
        };
    }

    public Command createAddDataObjectPropertyCommand(final String propertyName, final String propertyType) {

        return new Command() {
            @Override
            public void execute() {

                //Window.alert("Aqui controlamos si el nombre es correcto");
                view.addDataObjectProperty(new ObjectPropertyTO(propertyName, propertyType));
            }
        };
    }

}
