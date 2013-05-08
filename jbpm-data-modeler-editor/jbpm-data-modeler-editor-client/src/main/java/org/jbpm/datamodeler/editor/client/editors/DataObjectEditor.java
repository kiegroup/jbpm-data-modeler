package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.widgets.ErrorPopup;
import org.jbpm.datamodeler.editor.client.editors.widgets.PackageSelector;
import org.jbpm.datamodeler.editor.client.editors.widgets.SuperclassSelector;
import org.jbpm.datamodeler.editor.client.validation.ValidatorCallback;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectChangeEvent;
import org.jbpm.datamodeler.editor.events.DataObjectDeletedEvent;
import org.jbpm.datamodeler.editor.events.DataObjectSelectedEvent;
import org.jbpm.datamodeler.editor.model.AnnotationDefinitionTO;
import org.jbpm.datamodeler.editor.model.AnnotationTO;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class DataObjectEditor extends Composite {

    interface DataObjectDetailEditorUIBinder
            extends UiBinder<Widget, DataObjectEditor> {

    };

    public static final String NOT_SELECTED = "NOT_SELECTED";

    @UiField
    TextBox name;

    @UiField
    Label titleLabel;

    @UiField
    TextBox label;

    @UiField
    TextArea description;

    @UiField
    Label packageNameLabel;

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

    @Inject
    private Caller<DataModelerService> modelerService;

    private DataObjectEditorErrorPopup ep = new DataObjectEditorErrorPopup();
    
    private Map<String, AnnotationDefinitionTO> annotationDefinitions = new HashMap<String, AnnotationDefinitionTO>();

    private static DataObjectDetailEditorUIBinder uiBinder = GWT.create(DataObjectDetailEditorUIBinder.class);

    public DataObjectEditor() {
        initWidget(uiBinder.createAndBindUi(this));

        superclassSelector.getSuperclassList().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                superClassChanged(event);
            }
        });

        roleSelector.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                roleChanged(event);
            }
        });
        // TODO Change this when necessary (for now hardcoded here)
        roleSelector.addItem("", NOT_SELECTED);
        roleSelector.addItem("Fact", "Fact");
        roleSelector.addItem("Event", "Event");
        roleSelector.setSelectedValue(NOT_SELECTED);
    }

    @PostConstruct
    void init() {
        packageSelectorPanel.add(packageSelector);
        // TODO o bien mover todos los addChangehandlers aquí, o bien mover éste al initWidget()
        packageSelector.getPackageList().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                packageChanged(event);
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
        packageSelector.setDataModel(dataModel);
        superclassSelector.setDataModel(dataModel);

        modelerService.call(
                new RemoteCallback<Map<String, AnnotationDefinitionTO>>() {
                    @Override
                    public void callback(Map<String, AnnotationDefinitionTO> defs) {
                        setAnnotationDefinitions(defs);
                    }
                },
                new DataModelerErrorCallback("An error was produced when loading the Annotation Definitions from the server.")
        ).getAnnotationDefinitions();
    }

    public void setAnnotationDefinitions(Map<String, AnnotationDefinitionTO> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }

    public Map<String, AnnotationDefinitionTO> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    // Event observers
    private void onDataObjectSelected(@Observes DataObjectSelectedEvent event) {
        if (event.isFrom(getDataModel())) {
            loadDataObject(event.getCurrentDataObject());
        }
    }

    private void loadDataObject(DataObjectTO dataObject) {
        clean();
        if (dataObject != null) {
            setDataObject(dataObject);

            name.setText(dataObject.getName());

            AnnotationTO annotation = dataObject.getAnnotation(AnnotationDefinitionTO.LABEL_ANNOTATION);
            if (annotation != null) {
                label.setText(annotation.getValue(AnnotationDefinitionTO.VALUE_PARAM).toString());
            }

            annotation = dataObject.getAnnotation(AnnotationDefinitionTO.DESCRIPTION_ANNOTATION);
            if (annotation != null) {
                description.setText(annotation.getValue(AnnotationDefinitionTO.VALUE_PARAM).toString());
            }

            packageSelector.setDataObject(dataObject);

            superclassSelector.setDataObject(dataObject);

            annotation = dataObject.getAnnotation(AnnotationDefinitionTO.ROLE_ANNOTATION);
            if (annotation != null) {
                roleSelector.setSelectedValue(annotation.getValue(AnnotationDefinitionTO.VALUE_PARAM).toString());
            }
        }
    }

    private void onDataObjectDeleted(@Observes DataObjectDeletedEvent event) {
        // When all objects from current model have been deleted clean
        if (event.isFrom(getDataModel())) {
            if (getDataModel().getDataObjects().size() == 0) {
                clean();
            }
        }
    }

    // Event notifications
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

    @UiHandler("label")
    void labelChanged(final ValueChangeEvent<String> event) {
        final String _label = label.getValue();
        AnnotationTO annotation = getDataObject().getAnnotation(AnnotationDefinitionTO.LABEL_ANNOTATION);

        if (annotation != null) {
            if ( _label != null && !"".equals(_label) ) annotation.setValue(AnnotationDefinitionTO.VALUE_PARAM, _label);
            else getDataObject().removeAnnotation(annotation);
        } else {
            if ( _label != null && !"".equals(_label) ) {
                getDataObject().addAnnotation(getAnnotationDefinitions().get(AnnotationDefinitionTO.LABEL_ANNOTATION), AnnotationDefinitionTO.VALUE_PARAM, _label );
            }
        }
    }

    @UiHandler("description")
    void descriptionChanged(final ValueChangeEvent<String> event) {
        final String _description = description.getValue();
        AnnotationTO annotation = getDataObject().getAnnotation(AnnotationDefinitionTO.DESCRIPTION_ANNOTATION);

        if (annotation != null) {
            if ( _description != null && !"".equals(_description) ) annotation.setValue(AnnotationDefinitionTO.VALUE_PARAM, _description);
            else getDataObject().removeAnnotation(annotation);
        } else {
            if ( _description != null && !"".equals(_description) ) {
                getDataObject().addAnnotation(getAnnotationDefinitions().get(AnnotationDefinitionTO.DESCRIPTION_ANNOTATION), AnnotationDefinitionTO.VALUE_PARAM, _description );
            }
        }
    }

    private void packageChanged(ChangeEvent event) {
        // Set widgets to errorpopup for styling purposes etc.
        ep.setTitleWidget(packageNameLabel);
        ep.setValueWidget(packageSelector);

        final String packageName = packageSelector.getPackageList().getValue();
        validatorService.canChangeObjectPackage(getDataObject(), getDataModel(), new ValidatorCallback() {
            @Override
            public void onFailure() {
                ep.showMessage("Cannot change this object's package because it is being referenced from other DataObjects");
            }

            @Override
            public void onSuccess() {
                if (packageName != null &&
                        !"".equals(packageName) &&
                        !PackageSelector.NOT_SELECTED.equals(packageName))
                    getDataObject().setPackageName(packageName);
                else getDataObject().setPackageName(null);
            }
        });
    }

    private void superClassChanged(ChangeEvent event) {
        final String superClass = superclassSelector.getSuperclassList().getValue();
        if (superClass != null &&
                !"".equals(superClass) &&
                !SuperclassSelector.NOT_SELECTED.equals(superClass))
            getDataObject().setSuperClassName(superClass);
        else getDataObject().setSuperClassName(null);
    }

    void roleChanged(final ChangeEvent event) {
        final String _role = roleSelector.getValue();
        AnnotationTO annotation = getDataObject().getAnnotation(AnnotationDefinitionTO.ROLE_ANNOTATION);

        if (annotation != null) {
            if ( _role != null && !NOT_SELECTED.equals(_role) ) annotation.setValue(AnnotationDefinitionTO.VALUE_PARAM, _role);
            else getDataObject().removeAnnotation(annotation);
        } else {
            if ( _role != null && !NOT_SELECTED.equals(_role) ) {
                getDataObject().addAnnotation(getAnnotationDefinitions().get(AnnotationDefinitionTO.ROLE_ANNOTATION), AnnotationDefinitionTO.VALUE_PARAM, _role );
            }
        }
    }

    private void clean() {
        name.setText(null);
        label.setText(null);
        description.setText(null);
        packageSelector.setDataObject(null);
        superclassSelector.setDataObject(null);
        roleSelector.setSelectedValue(NOT_SELECTED);
    }

    // TODO extract this to parent widget to avoid duplicate code
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
