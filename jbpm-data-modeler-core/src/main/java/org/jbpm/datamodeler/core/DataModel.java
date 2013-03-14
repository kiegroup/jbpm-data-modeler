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

package org.jbpm.datamodeler.core;

import java.util.Set;

public interface DataModel extends ModelElement {

    /**
     * This is an internal value that specifies the format used for the model. In the future this
     * format attribute can enable model migration from an old format N to a newer format N+1.
     *
     * @return The model format.
     *
     */
    String getFormat();

    /**
     * Specifies model version.
     *
     * @param version
     */
    void setVersion(String version);
    
    String getVersion();

    Set<DataObject> getDataObjects();

    /**
     * The created data object will have the class name "packageName.name"
     *
     * @param packageName The package to locate the DataObject.
     *
     * @param name
     *
     * @return
     */
    DataObject addDataObject(String packageName, String name);
    
    DataObject addDataObject(String className);

    DataObject getDataObject(String className);
    
    DataObject removeDataObject(String className);

}