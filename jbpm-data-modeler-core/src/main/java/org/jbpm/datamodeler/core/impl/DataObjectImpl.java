/**
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.ObjectProperty;

import java.util.HashMap;
import java.util.Map;


public class DataObjectImpl extends ModelElementImpl implements DataObject {

    private String packageName;
    
    private String superClassName;
    
    private Map<String, ObjectProperty> properties = new HashMap<String, ObjectProperty>();

    public DataObjectImpl(String packageName, String name) {
        super(name);
        this.packageName = packageName;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String getClassName() {
        return ( (packageName != null && !"".equals(packageName)) ? packageName+"." : "") + getName();
    }

    @Override
    public boolean hasSuperClass() {
        return superClassName != null;
    }

    @Override
    public String getSuperClassName() {
        return superClassName;
    }

    @Override
    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    @Override
    public Map<String, ObjectProperty> getProperties() {
        return properties;
    }

    @Override
    public ObjectProperty addProperty(String name, String className) {
        return addProperty(name, className, false);
    }

    @Override
    public ObjectProperty addProperty(String name, String className, boolean multiple) {
        ObjectProperty property = ModelFactoryImpl.getElementFactoryInstance().newProperty(name, className, multiple);
        properties.put(name, property);
        return property;
    }

    @Override
    public ObjectProperty removeProperty(String name) {
        return properties.remove(name);
    }

}
