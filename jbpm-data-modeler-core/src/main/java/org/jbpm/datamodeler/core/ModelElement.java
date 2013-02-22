package org.jbpm.datamodeler.core;

import java.util.Map;

public interface ModelElement {
    
    String getName();
    
    void setName(String name);

    Map<String, Attribute> getAttributes();

    Attribute addAttribute(String name, String value);
    
    Attribute removeAttribute(String name);


}
