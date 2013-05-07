package org.jbpm.datamodeler.editor.client.validation;

import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.DataModelerErrorCallback;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class ValidatorService {

    @Inject
    private Caller<DataModelerService> modelerService;

    public ValidatorService() {
    }

    //TODO Generify this!!
    public void isValidIdentifier(String identifier, final ValidatorCallback callback) {
        modelerService.call(
            new RemoteCallback<Boolean>() {
                @Override
                public void callback(Boolean b) {
                    if (b) {
                        callback.onSuccess();
                    }
                    else {
                        callback.onFailure();
                    }
                }
            },
            new DataModelerErrorCallback("An error occurred during the server validation process")
        )
        .isValidIdentifier(identifier);
    }
    
    public void isValidPackageIdentifier(String identifier, final ValidatorCallback callback) {
        //complete implementation.
        if ("error".equals(identifier)) {
            callback.onFailure();
        } else {
            callback.onSuccess();
        }
    }


    // Todo drop dependency on datamodel, all components (should) know which model is being treated
    public void isUniqueEntityName(String packageName, String name, DataModelTO model, ValidatorCallback callback) {
        Boolean b = Boolean.TRUE;
        String className = packageName != null ? packageName + "." + name : name;
        for (DataObjectTO d : model.getDataObjects()) {
            if (d.getClassName().equalsIgnoreCase(className)) {
                b = Boolean.FALSE;
                break;
            }
        }
        if (b) callback.onSuccess();
        else callback.onFailure();
    }

    public void isUniqueAttributeName(String name, DataObjectTO object, ValidatorCallback callback) {
        for (ObjectPropertyTO prop : object.getProperties()) {
            if (prop.getName().equalsIgnoreCase(name)) {
                callback.onFailure();
                return;
            }
        }
        callback.onSuccess();
    }

    public void canDeleteDataObject(DataObjectTO object, DataModelTO model, ValidatorCallback callback) {
        if (model.getHelper().objectCanBeDeleted(object.getClassName())) callback.onSuccess();
        else callback.onFailure();
    }

    public void canChangeObjectName(DataObjectTO object, DataModelTO model, ValidatorCallback callback) {
        Boolean referenced = model.getHelper().isDataObjectReferenced(object.getClassName());
        if (!referenced) callback.onSuccess();
        else callback.onFailure();
    }
}
