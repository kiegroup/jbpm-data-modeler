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

import org.jbpm.datamodeler.core.*;


public class ModelFactoryImpl implements ModelFactory, ModelElementFactory {
    
    private static String CURRENT_FORMAT = "1";

    public static ModelFactory getInstance() {
        return new ModelFactoryImpl();
    }

    static ModelElementFactory getElementFactoryInstance() {
        return new ModelFactoryImpl();
    }

    @Override
    public DataModel newModel(String name, String format) {
        return new DataModelImpl(name, format);
    }

    @Override
    public DataModel newModel(String name) {
        return new DataModelImpl(name, CURRENT_FORMAT);
    }
    

    @Override
    public DataObject newDataObject(String packageName, String name) {
        return new DataObjectImpl(packageName, name);
    }

    @Override
    public ObjectProperty newProperty(String name, String className, boolean multiple) {
        return new ObjectPropertyImpl(name, className, multiple);
    }

    @Override
    public Attribute newAttribute(String name, Object value) {
        return new AttributeImpl(name, value);
    }
}
