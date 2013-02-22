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

import org.jbpm.datamodeler.core.ObjectProperty;

public class ObjectPropertyImpl extends ModelElementImpl implements ObjectProperty {

    private String className;
    
    private String bag;
    
    private boolean multiple;

    public ObjectPropertyImpl(String name, String className, boolean multiple) {
        super(name);
        this.className = className;
        setMultiple(multiple);
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
        if (multiple) {
            setBag("java.util.List");
        } else {
            setBag(null);
        }
    }

    @Override
    public boolean isMultiple() {
        return multiple;
    }
}
