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

import java.util.Map;

public interface DataObject extends HasName, HasPackageName, HasClassName, HasAnnotations {

    boolean hasSuperClass();

    String getSuperClassName();

    void setSuperClassName(String superClass);

    Map<String, ObjectProperty> getProperties();
    
    ObjectProperty addProperty(String name, String className);

    ObjectProperty addProperty(String name, String className, boolean multiple);

    ObjectProperty removeProperty(String name);

}
