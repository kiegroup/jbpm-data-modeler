package org.jbpm.datamodeler.core;


public interface ObjectProperty extends ModelElement {
    
    String getClassName();

    void setClassName(String className);

    boolean isMultiple();

    void setMultiple(boolean multiple);

    String getBag();
}
