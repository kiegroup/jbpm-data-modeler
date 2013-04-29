package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.editors.widgets.PackageSelector;
import org.jbpm.datamodeler.editor.client.editors.widgets.SuperclassSelector;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectChangeEvent;
import org.jbpm.datamodeler.editor.events.DataObjectDeletedEvent;
import org.jbpm.datamodeler.editor.events.DataObjectSelectedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

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
    TextBox shortName;

    @UiField
    TextArea description;

    @UiField
    PackageSelector packageSelector;

    @UiField
    SuperclassSelector superclassSelector;

    @UiField
    ListBox roleSelector;

    @Inject
    Event<DataModelerEvent> dataModelerEvent;
    
    DataObjectTO dataObject;

    DataModelTO dataModel;

    public DataObjectEditor() {
        initWidget(uiBinder.createAndBindUi(this));
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
    }

    // event Observers
    private void onDataObjectSelected(@Observes DataObjectSelectedEvent event) {

        if (event.isFrom(getDataModel())) {
            //TODO populate all the fields, etc.

            setDataObject(event.getCurrentDataObject());
            name.setText(getDataObject().getName());
            description.setText(getDataObject().getClassName());
        }
    }

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
        dataModelerEvent.fire(new DataObjectChangeEvent(DataModelerEvent.DATA_OBJECT_EDITOR, getDataModel(), getDataObject(), memberName, oldValue, getDataObject().getName()));
    }

    // event handlers

    @UiHandler("name")
    void nameChanged(ValueChangeEvent<String> event) {

        //TODO add validation.
        //data object name will be changed only if validation is successful

        String oldValue = getDataObject().getName();

        boolean validationOk = true;

        if (validationOk) {

            dataObject.setName(event.getValue());
            notifyObjectChange("name", oldValue, getDataObject().getName());
        } else {
            //1) mensaje popup
            //2) dejar el foco en el campo
            //3) texto seleccionado
            name.setFocus(true);
            
        }


        //como me registro para saber el cambio en la clase:

        //en el lugar que toque.
        //superclassSelector.getSuperclassList().addChangeHandler(null);

    }


    /*
       Valicaciones que estan en el presenter.

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
                       validatorService.isUniqueEntityName(null, pendingValue.toString(), getDataModel(), new ValidatorCallback() {
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


    */

}
