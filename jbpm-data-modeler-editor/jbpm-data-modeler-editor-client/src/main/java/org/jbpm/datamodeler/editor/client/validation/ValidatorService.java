package org.jbpm.datamodeler.editor.client.validation;

import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.jbpm.datamodeler.editor.validation.ValidationUtils;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@ApplicationScoped
public class ValidatorService implements DataObjectReferencingListener {

    private DataObjectReferenceCache refCache = new DataObjectReferenceCache();

    @Inject
    private Caller<DataModelerService> modelerService;

    @Inject
    private Event<NotificationEvent> notification;

    public ValidatorService() {
    }

    //TODO Generify this!!
    public void isValidIdentifier(String identifier, ValidatorCallback callback) {
        if (ValidationUtils.isJavaIdentifier(identifier)) callback.onSuccess();
        else callback.onFailure();
//        modelerService.call(
//            new RemoteCallback<Boolean>() {
//                @Override
//                public void callback(Boolean b) {
//                    if (b) {
//                        callback.onSuccess();
//                    }
//                    else {
//                        callback.onFailure();
//                    }
//                }
//            },
//            new DataModelerErrorCallback("An error occurred during the server validation process")
//        )
//        .isValidIdentifier(identifier);
    }


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

    public void isDataObjectDeletable(DataObjectTO object, ValidatorCallback callback) {
        if (refCache.objectCanBeDeleted(object.getClassName())) callback.onSuccess();
        else callback.onFailure();
    }

    // DataObjectReferencingListener methods
    // TODO investigate some way to get the validator notified without having to explicitly call the validator listener methods?

    @Override
    public void notifyDataObjectReferenced(String objectClassName, String subjectClassName) {
        refCache.objectReferenced(objectClassName, subjectClassName);
    }

    @Override
    public void notifyDataObjectUnReferenced(String objectClassName, String subjectClassName) {
        refCache.objectUnReferenced(objectClassName, subjectClassName);
    }

    public void notifyDataObjectDeleted(String objectClassName) {
        refCache.objectDeleted(objectClassName);
    }

    @Override
    // TODO for now recalculate all preexisting object references every time a model is selected; can be improved if performance becomes an issue
    public void notifyDataModelSelected(DataModelTO model) {
        refCache.init(model);
    }

    private class DataObjectReferenceCache {
        private DataObjectReferenceCache(){}
        private Map<String, List<String>> referencedBy = new HashMap<String, List<String>>(10);
        private Map<String, List<String>> references = new HashMap<String, List<String>>(10);

        private void init(DataModelTO model) {
            referencedBy.clear();
            references.clear();
            for (DataObjectTO object : model.getDataObjects()) {
                for (ObjectPropertyTO prop : object.getProperties()) {
                    if (!prop.isBaseType()) {
                        objectReferenced(prop.getClassName(), object.getClassName());
                    }
                }
            }
        }

        private boolean objectCanBeDeleted(String className) {
            List<String> refs = referencedBy.get(className);
            if (refs != null && refs.size() > 0) return false;
            return true;
        }

        private void objectReferenced(String objectClassName, String subjectClassName) {
            List<String> refs = referencedBy.get(objectClassName);
            if (refs == null) refs = new ArrayList<String>(5);
            refs.add(subjectClassName);
            referencedBy.put(objectClassName, refs);

            refs = references.get(subjectClassName);
            if (refs == null) refs = new ArrayList<String>(5);
            refs.add(objectClassName);
            references.put(subjectClassName, refs);
        }

        private void objectUnReferenced(String objectClassName, String subjectClassName) {
            List<String> refs = referencedBy.get(objectClassName);
            if (refs != null && refs.size() > 0) {
                refs.remove(subjectClassName);
            } else notification.fire(new NotificationEvent("Error de-referencing data object (referenced object)."));

            refs = references.get(subjectClassName);
            if (refs != null && refs.size() > 0) {
                refs.remove(objectClassName);
            } else notification.fire(new NotificationEvent("Error de-referencing data object (referring object)."));
        }

        private void objectDeleted(String subjectClassName) {
            List<String> refs = references.get(subjectClassName);
            if (refs != null) {
                for (String objectClassName : refs) {
                    List objRefs = referencedBy.get(objectClassName);
                    if (!objRefs.remove(subjectClassName)) notification.fire(new NotificationEvent("Reference-error when deleting data object (referring object)."));
                }
                refs.remove(subjectClassName);
            }
        }
    }
}
