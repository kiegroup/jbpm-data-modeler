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

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;

import java.util.*;

public class DataModelImpl extends ModelElementImpl implements DataModel {

    Map<String, DataObject> dataObjects = new HashMap<String, DataObject>();
    
    String version;
    
    String format;

    public DataModelImpl(String name, String format) {
        super(name);
        this.format = format;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public Set<DataObject> getDataObjects() {
        HashSet<DataObject> set = new HashSet<DataObject>();
        set.addAll(dataObjects.values());
        return set;
    }

    @Override
    public DataObject getDataObject(String className) {
        return dataObjects.get(className);
    }

    @Override
    public DataObject removeDataObject(String className) {
        return dataObjects.remove(className);
    }

    @Override
    public DataObject addDataObject(String packageName, String name) {
        DataObject dataObject = ModelFactoryImpl.getElementFactoryInstance().newDataObject(packageName, name);
        dataObjects.put(dataObject.getClassName(), dataObject);
        return dataObject;
    }

    @Override
    public DataObject addDataObject(String className) {
        StringTokenizer tokenizer = new StringTokenizer(className, ".");
        StringBuffer packageName = new StringBuffer("");
        String token = className;
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens()) {
                if (packageName.length() > 0) packageName.append(".");
                packageName.append(token);
            }
        }
        return addDataObject(packageName.toString(), token);
    }
}
