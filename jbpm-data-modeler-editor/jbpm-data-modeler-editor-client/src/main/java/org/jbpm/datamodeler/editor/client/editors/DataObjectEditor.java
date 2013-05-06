package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;
import org.jbpm.datamodeler.editor.client.editors.widgets.PackageSelector;
import org.jbpm.datamodeler.editor.client.editors.widgets.SuperclassSelector;
import org.jbpm.datamodeler.editor.client.editors.widgets.ErrorPopup;
import org.jbpm.datamodeler.editor.client.validation.ValidatorCallback;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectChangeEvent;
import org.jbpm.datamodeler.editor.events.DataObjectDeletedEvent;
import org.jbpm.datamodeler.editor.events.DataObjectSelectedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class DataObjectEditor extends Composite {

    interface DataObjectDetailEditorUIBinder
            extends UiBinder<Widget, DataObjectEditor> {

    };

    private static DataObjectDetailEditorUIBinder uiBinder = GWT.create(DataObjectDetailEditorUIBinder.class);

    @UiField
    TextBox name;

    @UiField
    Label titleLabel;

    @UiField
    TextBox shortName;

    @UiField
    TextArea description;

    @UiField
    SimplePanel packageSelectorPanel;

    @Inject
    PackageSelector packageSelector;

    @UiField
    SuperclassSelector superclassSelector;

    @UiField
    ListBox roleSelector;

    @Inject
    Event<DataModelerEvent> dataModelerEvent;

    DataObjectTO dataObject;

    DataModelTO dataModel;

    @Inject
    private ValidatorService validatorService;

    private DataObjectEditorErrorPopup ep = new DataObjectEditorErrorPopup();

    public DataObjectEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @PostConstruct
    void init() {
        packageSelectorPanel.add(packageSelector);
    }
       
    public DataObjectTO getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
        superclassSelector.setDataModel(dataModel);
    }

    // event Observers
    private void onDataObjectSelected(@Observes DataObjectSelectedEvent event) {

        if (event.isFrom(getDataModel())) {
            //TODO populate all the fields, etc.
            setDataObject(event.getCurrentDataObject());
            superclassSelector.setDataObject(event.getCurrentDataObject());
            name.setText(getDataObject().getName());
            description.setText(getDataObject().getClassName());
        }
    }

    //como me registro para saber el cambio en la clase:

    //todo en el lugar que toque.
//        superclassSelector.getSuperclassList().addChangeHandler(null);

    private void loadDataObject(DataObjectTO dataObject) {
        //TODO
        //Cargar el objeto correctamente.

    }


    private void onDataObjectDeleted(@Observes DataObjectDeletedEvent event) {
        //when all objects from current model was deleted clean
        if (event.isFrom(getDataModel())) {
            if (getDataModel().getDataObjects().size() == 0) {
                //TODO, when we clean this editor dataObject must be set to null
                name.setText(null);
                description.setText(null);
            }
        }
    }

    // event notifications
    private void notifyObjectChange(String memberName, Object oldValue, Object newValue) {
        getDataModel().getHelper().dataModelChanged();
        dataModelerEvent.fire(new DataObjectChangeEvent(DataModelerEvent.DATA_OBJECT_EDITOR, getDataModel(), getDataObject(), memberName, oldValue, getDataObject().getName()));
    }

    // Event handlers

    @UiHandler("name")
    void nameChanged(final ValueChangeEvent<String> event) {
        // Set widgets to errorpopup for styling purposes etc.
        ep.setTitleWidget(titleLabel);
        ep.setValueWidget(name);

        final String packageName = getDataObject().getPackageName();
        final String oldValue = getDataObject().getName();
        final String newValue = name.getValue();

        // In case an invalid name (entered before), was corrected to the original value, don't do anything but reset the label style
        if (oldValue.equalsIgnoreCase(newValue)) {
            titleLabel.setStyleName(null);
            return;
        }
        // Otherwise validate
        validatorService.canChangeObjectName(getDataObject(), getDataModel(), new ValidatorCallback() {
            @Override
            public void onFailure() {
                ep.showMessage("Cannot change this object's name because it is being referenced from other DataObjects");
            }

            @Override
            public void onSuccess() {
                validatorService.isValidIdentifier(newValue, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        ep.showMessage("Invalid data object identifier: " + newValue + " is not a valid Java identifier");
                    }

                    @Override
                    public void onSuccess() {
                        validatorService.isUniqueEntityName(packageName, newValue, getDataModel(), new ValidatorCallback() {
                            @Override
                            public void onFailure() {
                                ep.showMessage("A data object with identifier: " + newValue + " already exists in the model.");
                            }

                            @Override
                            public void onSuccess() {
                                titleLabel.setStyleName(null);
                                dataObject.setName(newValue);
                                notifyObjectChange("name", oldValue, getDataObject().getName());
                            }
                        });
                    }
                });
            }
        });

    }

    private class DataObjectEditorErrorPopup extends ErrorPopup {
        private Widget titleWidget;
        private Widget valueWidget;
        private DataObjectEditorErrorPopup() {
            setAfterCloseEvent(new Command() {
                @Override
                public void execute() {
                    titleWidget.setStyleName("text-error");
                    if (valueWidget instanceof Focusable) ((FocusWidget)valueWidget).setFocus(true);
                    if (valueWidget instanceof ValueBoxBase) ((ValueBoxBase)valueWidget).selectAll();
                    clearWidgets();
                }
            });
        }
        private void setTitleWidget(Widget titleWidget){this.titleWidget = titleWidget;}
        private void setValueWidget(Widget valueWidget){this.valueWidget = valueWidget;}
        private void clearWidgets() {
            titleWidget = null;
            valueWidget = null;
        }
    }
}
