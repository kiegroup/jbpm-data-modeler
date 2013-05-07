package org.jbpm.datamodeler.editor.client.validation;

import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.DataModelerErrorCallback;
import org.jbpm.datamodeler.editor.client.util.DataModelerUtils;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;


@ApplicationScoped
public class ValidatorService {

    @Inject
    private Caller<DataModelerService> modelerService;

    public ValidatorService() {
    }

    // TODO Generify this!!
    // TODO replace this service call by a call to evaluateIdentifiers
    public void isValidIdentifier(String identifier, final ValidatorCallback callback) {
        modelerService.call(
            new RemoteCallback<Boolean>() {
                @Override
                public void callback(Boolean b) {
                    if (b) {
                        callback.onSuccess();
                    } else {
                        callback.onFailure();
                    }
                }
            },
            new DataModelerErrorCallback("An error occurred during the server validation process")
        )
        .isValidIdentifier(identifier);
    }
    
    public void isValidPackageIdentifier(String identifier, final ValidatorCallback callback) {
        String[] packageTerms = DataModelerUtils.getInstance().getPackageTerms(identifier);
        modelerService.call(
                new RemoteCallback<Map<String, Boolean>>() {
                    @Override
                    public void callback(Map<String, Boolean> evaluatedTerms) {
                        // TODO the service is prepared for term-based evaluation, but for now the callback
                        // doesn't support returning params
                        boolean nok = evaluatedTerms.containsValue(Boolean.FALSE);
                        if (nok) {
                            callback.onFailure();
                        } else {
                            callback.onSuccess();
                        }
                    }
                },
                new DataModelerErrorCallback("An error occurred during the server validation process")
        )
        .evaluateIdentifiers(packageTerms);
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
