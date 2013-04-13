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

import org.jbpm.datamodeler.core.Attribute;
import org.jbpm.datamodeler.core.ModelElement;

import java.util.HashMap;
import java.util.Map;

public abstract class ModelElementImpl implements ModelElement {
    
    private String name;
    
    private Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    protected ModelElementImpl() {
    }

    protected ModelElementImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Attribute addAttribute(String name, Object value) {
        return null;
    }

    @Override
    public Attribute removeAttribute(String name) {
        return attributes.remove(name);
    }
}
