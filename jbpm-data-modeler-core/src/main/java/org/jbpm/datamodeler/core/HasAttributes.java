package org.jbpm.datamodeler.core;


import java.util.Map;

public interface HasAttributes {

    Map<String, Attribute> getAttributes();
    
    Attribute getAttribute(String attributeName);

    void addAttribute(Attribute attribute);
    
    Attribute removeAttribute(String attributeName);

}
