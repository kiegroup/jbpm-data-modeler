package org.jbpm.datamodeler.editor.client.editors;

import org.jbpm.datamodeler.editor.model.DataModelHelper;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.*;

public class DataModelHelperImpl extends DataModelHelper {

    private DataModelTO dataModel;
    private DataObjectTO currentDataObject;

    // Map linking Objects with the Objects they are being referenced by (e.g. x.y.A --> {u.v.B} means B holds a reference to A)
    private Map<String, Set<String>> referencedBy = new HashMap<String, Set<String>>(10);
    // Map linking DataObjects with the Objects they are referencing by (e.g. u.v.B --> {x.y.A} means B references A)
    private Map<String, Set<String>> references = new HashMap<String, Set<String>>(10);
    // List of all class names that coexist within a project
    private List<String> classNames = new ArrayList<String>(10);

    @Inject
    private Event<NotificationEvent> notification;

    public DataModelHelperImpl() {
    }

    public DataModelHelperImpl(DataModelTO dataModel) {
        init(dataModel);
    }

    public Boolean objectCanBeDeleted(String className) {
        Set<String> refs = referencedBy.get(className);
        if (refs != null && refs.size() > 0) return false;
        return true;
    }

    public List<String> getClassList() {
        return Collections.unmodifiableList(classNames);
    }

    // TODO change from listener methods to event observers
    // DataModelHelper methods

    @Override
    public void dataModelChanged() {
        reset();
    }

    @Override
    public void dataObjectReferenced(String objectClassName, String subjectClassName) {
        objectReferenced(objectClassName, subjectClassName);
    }

    @Override
    public void dataObjectUnReferenced(String objectClassName, String subjectClassName) {
        objectUnReferenced(objectClassName, subjectClassName);
    }

    @Override
    public void dataObjectDeleted(String objectClassName) {
        objectDeleted(objectClassName);
    }

    @Override
    public void dataObjectCreated(String objectClassName) {
        //TODO Review if this invocation is correct.
        reset();
    }

    @Override
    public void dataObjectSelected(String objectClassName) {
        //TODO  Review if this invocation is correct.
        //JAN, cuando puse este codigo, este metodo no se invoca en ningun lugar del proyecto.
        //he puesto la invocacion por las dudas.
        reset();
    }

    @Override
    public void dataObjectUnSelected(String objectClassName) {
        //TODO Review if this invocation is correct.
        //JAN, cuando puse este codigo, este metodo tampoco se invoca en ningun lugar del proyecto.
        //he puesto la invocacion por las dudas.
        reset();
    }

    @Override
    public Boolean isDataObjectReferenced(String objectClassName) {
        Set refdBy = referencedBy.get(objectClassName);
        return refdBy != null && refdBy.size() > 0;
    }

//    private void onDataObjectChanged(@Observes DataObjectChangeEvent event) {
//        if (event.isFrom(dataModel)) {
//            String propName = event.getPropertyName();
//            if ("name".equalsIgnoreCase(propName) ||
//                "packageName".equalsIgnoreCase(propName) ||
//                "superClassName".equalsIgnoreCase(propName)) {
//                reset();
//            }
//        }
//    }

    public void init(DataModelTO dataModel) {
        this.dataModel = dataModel;
        reset();
    }

    // Todo can be improved if required for performance reasons
    // Recalculate all
    private void reset() {
        referencedBy.clear();
        references.clear();
        classNames.clear();
        classNames.addAll(dataModel.getExternalClasses());
        for (DataObjectTO object : dataModel.getDataObjects()) {
            classNames.add(object.getClassName());
            for (ObjectPropertyTO prop : object.getProperties()) {
                if (!prop.isBaseType()) {
                    objectReferenced(prop.getClassName(), object.getClassName());
                }
            }
        }
    }

//    private void onDataObjectSelected(@Observes DataObjectSelectedEvent event) {
//        if (event.isFrom(dataModel)) {
//            if (event.getCurrentDataObject() != null) {
//                currentDataObject = event.getCurrentDataObject();
//            } else currentDataObject = null;
//        }
//    }

    private void objectReferenced(String objectClassName, String subjectClassName) {
        Set<String> refs = referencedBy.get(objectClassName);
        if (refs == null) refs = new HashSet<String>();
        refs.add(subjectClassName);
        referencedBy.put(objectClassName, refs);

        refs = references.get(subjectClassName);
        if (refs == null) refs = new HashSet<String>();
        refs.add(objectClassName);
        references.put(subjectClassName, refs);
    }

    private void objectUnReferenced(String objectClassName, String subjectClassName) {
        Set<String> refs = referencedBy.get(objectClassName);
        if (refs != null && refs.size() > 0) {
            refs.remove(subjectClassName);
        } else notification.fire(new NotificationEvent("Error de-referencing data object (referenced object)."));

        refs = references.get(subjectClassName);
        if (refs != null && refs.size() > 0) {
            refs.remove(objectClassName);
        } else notification.fire(new NotificationEvent("Error de-referencing data object (referring object)."));
    }

    private void objectDeleted(String subjectClassName) {
        // For all the Objects that this Object might be referencing, update the corresponding referencedBy list
        Set<String> refs = references.get(subjectClassName);
        if (refs != null) {
            for (String objectClassName : refs) {
                Set objRefs = referencedBy.get(objectClassName);
                if (!objRefs.remove(subjectClassName)) notification.fire(new NotificationEvent("Reference-error when deleting data object (referring object)."));
            }
            refs.remove(subjectClassName);
        }
    }
}
