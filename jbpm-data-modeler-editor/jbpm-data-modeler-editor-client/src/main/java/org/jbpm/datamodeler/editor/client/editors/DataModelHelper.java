package org.jbpm.datamodeler.editor.client.editors;

import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

import java.util.*;

public class DataModelHelper {

    private DataModelTO dataModel;
    private DataObjectTO currentDataObject;

    // Map linking Objects with the Objects they are being referenced by (e.g. x.y.A --> {u.v.B} means B holds a reference to A)
    private Map<String, Set<String>> referencedBy = new HashMap<String, Set<String>>(10);
    // Map linking DataObjects with the Objects they are referencing by (e.g. u.v.B --> {x.y.A} means B references A)
    private Map<String, Set<String>> references = new HashMap<String, Set<String>>(10);
    // Map that keeps track of the siblings a parent class has.
    private Map<String, Set<String>> siblingsMap = new HashMap<String, Set<String>>(10);
    // List of all class names that coexist within a project
    private List<String> classNames = new ArrayList<String>(10);

    public DataModelHelper() {
    }

    public DataModelHelper(DataModelTO dataModel) {
        init(dataModel);
    }

    public Boolean objectCanBeDeleted(String className) {
        Set<String> refs = referencedBy.get(className);
        if ( (refs != null && refs.size() > 0) || siblingsMap.containsKey(className)) return false;
        return true;
    }

    public List<String> getClassList() {
        return Collections.unmodifiableList(classNames);
    }

    // TODO change from listener methods to event observers
    // DataModelHelper methods

    public void dataModelChanged() {
        reset();
    }

    public void dataObjectReferenced(String objectClassName, String subjectClassName) {
        objectReferenced(objectClassName, subjectClassName);
    }

    public void dataObjectUnReferenced(String objectClassName, String subjectClassName) {
        objectUnReferenced(objectClassName, subjectClassName);
    }

    public void dataObjectExtended(String parentClassName, String siblingClassName, Boolean _extends) {
        objectExtended(parentClassName, siblingClassName, _extends);
    }

    public void dataObjectDeleted(String objectClassName) {
        reset();
    }

    public void dataObjectCreated(String objectClassName) {
        reset();
    }

    public void dataObjectSelected(String objectClassName) {
    }

    public void dataObjectUnSelected(String objectClassName) {
    }

    public Boolean isDataObjectReferenced(String objectClassName) {
        Set refdBy = referencedBy.get(objectClassName);
        return refdBy != null && refdBy.size() > 0;
    }

    public Boolean isBeingExtended(String parentClassName) {
        Set s = siblingsMap.get(parentClassName);
        return s != null && s.size() > 0;
    }

    public void init(DataModelTO dataModel) {
        this.dataModel = dataModel;
        reset();
    }

    // Todo can be improved if required for performance reasons
    // Brute force recalculate all
    private void reset() {
        referencedBy.clear();
        references.clear();
        classNames.clear();
        classNames.addAll(dataModel.getExternalClasses());
        for (DataObjectTO object : dataModel.getDataObjects()) {
            String className = object.getClassName();
            classNames.add(className);

            String superClassName = object.getSuperClassName();
            if (superClassName != null &&  !"".equals(superClassName)) objectExtended(superClassName, className, true);

            for (ObjectPropertyTO prop : object.getProperties()) {
                if (!prop.isBaseType()) {
                    objectReferenced(prop.getClassName(), object.getClassName());
                }
            }
        }
    }

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
        }
//        else ("Error de-referencing data object (referenced object)."));

        refs = references.get(subjectClassName);
        if (refs != null && refs.size() > 0) {
            refs.remove(objectClassName);
        }
//        else ("Error de-referencing data object (referring object)."));
    }

    private void objectExtended(String parentClassName, String siblingClassName, Boolean _extends) {
        Set<String> _siblings = siblingsMap.get(parentClassName);

        if (_extends) {
            if (_siblings != null ) _siblings.add(siblingClassName);
            else {
                _siblings = new HashSet<String>();
                _siblings.add(siblingClassName);
                siblingsMap.put(parentClassName, _siblings);
            }
        } else {
            if (_siblings != null && _siblings.size() > 0) _siblings.remove(siblingClassName);
            if (_siblings.size() == 0) siblingsMap.remove(parentClassName);
//            else ("Superclass referencing error"));
        }
    }
}
