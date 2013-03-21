package org.jbpm.datamodeler.core;

import java.util.List;

public interface PropertyTypeFactory {

    List<PropertyType> getBasePropertyTypes();

    boolean isBasePropertyType(String className);

}
