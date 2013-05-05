package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.editors.widgets.PackageSelector;
import org.jbpm.datamodeler.editor.client.editors.widgets.SuperclassSelector;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectCreatedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.kie.guvnor.commons.ui.client.popups.footers.ModalFooterOKCancelButtons;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;


public class NewDataObjectPopup extends Modal {

    interface NewDataObjectPopupUIBinder extends
            UiBinder<Widget, NewDataObjectPopup> {

    }

    private static NewDataObjectPopupUIBinder uiBinder = GWT.create(NewDataObjectPopupUIBinder.class);

    @UiField
    ControlGroup nameGroup;

    @UiField
    TextBox name;

    @UiField
    ControlGroup newPackageGroup;

    @UiField
    TextBox newPackage;

    @UiField
    PackageSelector packageSelector;

    @UiField
    SuperclassSelector superclassSelector;

    @UiField
    ControlGroup errorMessagesGroup;

    @UiField
    HelpInline errorMessages;

    @Inject
    private Event<DataModelerEvent> dataModelerEvent;

    @Inject
    private ValidatorService validatorService;

    @Inject
    private Event<NotificationEvent> notification;

    private DataObjectTO dataObject;

    private DataModelTO dataModel;

    public NewDataObjectPopup() {

        setTitle( "Create new data object" );
        setMaxHeigth((Window.getClientHeight() * 0.75) + "px");
        setBackdrop( BackdropType.STATIC );
        setKeyboard( true );
        setAnimation( true );
        setDynamicSafe( true );
        //setHideOthers( false );

        add( uiBinder.createAndBindUi( this ) );

        add( new ModalFooterOKCancelButtons(
                (new Command() {
                    @Override
                    public void execute() {
                        onOk();
                    }
                }),
                (new Command() {
                    @Override
                    public void execute() {
                        onCancel();
                    }
                })
        ));

        final ListBox packages = packageSelector.getPackageList();
        packages.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                newPackage.setText(packages.getValue());
            }
        });

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

    private void onOk() {

        //TODO poner las validaciones en forma correcta.
        //Hay que validar
        //1) que nombre de clase se a valido
        //2) en caso que haya algo en el nombre del paquete que sea valido
        //3) Finalmente que no exista en el modelo un objeto con ese nombre de clase y paquete.

        //4) OTRO comentario, el popup cuando se cierra debe limpiarse a si mismo para que la proxima vez que sea abierto
        //not tenga cosas de la ultima entidad creada.
        //para eso tenemos el metodo clean.


        String newName = name.getText();
        String newPackage = this.newPackage.getText();        

        //TODO el selector de superclase tiene que tener una opcion al principio
        //que sea (not selected) o bien un primer campo que blanco
        //pero tenemos que dejar la posibilidad de NO poner super clase.

        String superClass = superclassSelector.getSuperclassList().getValue();
        //TODO aqui hay que chequear que si la opcion es not selected entonces el objeto
        //debe crease sin superclase

        boolean validationOk = true;


        //TODO poner las validaciones correctas.
        //Pongo aqui debajo como seria mas o menos los casos de exito o error.

        validationOk = !"".equals(newName) && !"Test".equals(newName);


        if (!validationOk) {
            //si la validacion NO es correcta hay que hacer esto.

            //OBS! tenemos que discriminar qué campo es que el no es valido!! si el nombre de clase o el nombre de paquete.
            //en funcion de esto vamos a encender un control group u otro.

            //En cada ronda de validacion solo tengo que poner en error el grupo que NO esta correcto
            //y si un grupo esta correcto lo tengo que poner con ControlGroupType.NONE

            nameGroup.setType(ControlGroupType.ERROR);
            errorMessages.setText("El nombre de clase no es valido: " + newName);
            errorMessagesGroup.setType(ControlGroupType.ERROR);

        } else {
            DataObjectTO dataObject = new DataObjectTO(newName, newPackage, superClass);
            getDataModel().getDataObjects().add(dataObject);
            setDataObject(dataObject);
            notifyObjectCreated(dataObject);
            clean();
            hide();
        }
    }

    private void clean() {
        //TODO programar aqui la limpieza del popup.
        //Este metodo debe dejar todos los campos en blanco y los comboboxes con nada seleccionado
        //o en su defecto con la opcion (not selected) si es que optampos por tener ese tipo de opcion.
        //programar aqui la
    }

    private void onCancel() {
        clean();
        hide();
    }

    private void notifyObjectCreated(DataObjectTO createdObjectTO) {
        getDataModel().getHelper().dataObjectCreated(createdObjectTO.getClassName());
        dataModelerEvent.fire(new DataObjectCreatedEvent(DataModelerEvent.NEW_DATA_OBJECT_POPUP, getDataModel(), createdObjectTO));
        notification.fire(new NotificationEvent(Constants.INSTANCE.modelEditor_notification_dataObject_created(createdObjectTO.getName())));
    }

}
