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

package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.util.ArrayList;
import java.util.List;

@Portable
public class ObjectPropertyTO {

    private String className;

    private String name;

    private boolean multiple = false;

    private boolean baseType = true;
    
    private String bag;

    private List<AnnotationTO> annotations = new ArrayList<AnnotationTO>();
    
    private static final String DEFAULT_PROPERTY_BAG = "java.util.List";

    public ObjectPropertyTO() {
    }

    public ObjectPropertyTO(String name, String className, boolean multiple, boolean baseType) {
        this.name = name;
        this.className = className;
        this.multiple = multiple;
        this.baseType = baseType;
        if (multiple) {
            this.bag = DEFAULT_PROPERTY_BAG;
        }
    }

    public ObjectPropertyTO(String name, String className, boolean multiple, boolean baseType, String bag) {
        this.name = name;
        this.className = className;
        this.multiple = multiple;
        this.baseType = baseType;
        this.bag = bag;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public boolean isBaseType() {
        return baseType;
    }

    public void setBaseType(boolean baseType) {
        this.baseType = baseType;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public List<AnnotationTO> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationTO> annotations) {
        this.annotations = annotations;
    }

    public AnnotationTO getAnnotation(String annotationName) {
        if (annotationName == null) return null;

        for (AnnotationTO annotation : annotations) {
            if (annotationName.equals(annotation.getName())) return annotation;
        }
        return null;
    }

    public void addAnnotation(AnnotationTO annotation) {
        annotations.add(annotation);
    }
}