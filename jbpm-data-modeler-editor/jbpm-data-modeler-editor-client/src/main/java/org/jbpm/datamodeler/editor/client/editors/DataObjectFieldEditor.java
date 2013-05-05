package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.CheckBox;
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
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectFieldChangeEvent;
import org.jbpm.datamodeler.editor.events.DataObjectFieldSelectedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class DataObjectFieldEditor extends Composite {

    interface DataObjectFieldEditorUIBinder
            extends UiBinder<Widget, DataObjectFieldEditor> {

    };

    private static DataObjectFieldEditorUIBinder uiBinder = GWT.create(DataObjectFieldEditorUIBinder.class);

    @UiField
    TextBox name;

    @UiField
    TextBox shortName;

    @UiField
    TextArea description;

    @UiField
    ListBox typeSelector;

    @UiField
    CheckBox equalsSelector;

    @UiField
    CheckBox requiredSelector;

    @UiField
    TextBox positionText;

    @Inject
    Event<DataModelerEvent> dataModelerEventEvent;

    DataObjectTO dataObject;

    ObjectPropertyTO objectField;
    
    DataModelTO dataModel;

    public DataObjectFieldEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public DataObjectTO getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
    }

    public ObjectPropertyTO getObjectField() {
        return objectField;
    }

    public void setObjectField(ObjectPropertyTO objectField) {
        this.objectField = objectField;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }

    // event notifications

    private void notifyFieldChange(String memberName, Object oldValue, Object newValue) {
        // TODO getDataModel().getHelper().dataModelChanged();
        dataModelerEventEvent.fire(new DataObjectFieldChangeEvent(DataModelerEvent.DATA_OBJECT_FIELD_EDITOR, getDataModel(), getDataObject(), getObjectField(), memberName, oldValue, newValue));
    }

    // event Observers
    private void onFieldSelected(@Observes DataObjectFieldSelectedEvent event) {

        if (event.isFrom(getDataModel())) {
            //TODO populate all the values from the selected field to the editor.
            setDataObject(event.getCurrentDataObject());
            setObjectField(event.getCurrentField());

            if (getObjectField() != null) {
                name.setText(getObjectField().getName());
                description.setText(getObjectField().getClassName());
            } else {
                //if no object field is present
                //clean the editor.
                name.setText(null);
                description.setText(null);
            }
        }
    }

    // Event handlers
    @UiHandler("name")
    void nameChanged(ValueChangeEvent<String> event) {

        //TODO add validation.
        //Nombre correcto y no repetidas

        String oldValue = objectField.getName();

        boolean validationOk = true;

        if (validationOk) {
            objectField.setName(event.getValue());
            notifyFieldChange("name", oldValue, getObjectField().getName());
        }
    }

    /*    VALIDACIONES QUE ESTABAN EN EL PRESENTER

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
                       validatorService.isUniqueEntityName(null, pendingValue.toString(), getDataModel(), new ValidatorCallback() {
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

    */
}