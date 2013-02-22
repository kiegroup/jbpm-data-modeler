package org.jbpm.datamodeler.core;

import java.util.Map;

public interface DataObject extends ModelElement {

    String getPackageName();

    void setPackageName(String packageName);

    String getClassName();

    boolean hasSuperClass();

    String getSuperClassName();

    void setSuperClassName(String superClass);

    Map<String, ObjectProperty> getProperties();
    
    ObjectProperty addProperty(String name, String className);

    ObjectProperty addProperty(String name, String className, boolean multiple);

    ObjectProperty removeProperty(String name);
    
}
