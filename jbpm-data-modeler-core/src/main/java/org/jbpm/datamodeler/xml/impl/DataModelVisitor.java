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

package org.jbpm.datamodeler.xml.impl;

import org.jbpm.datamodeler.core.*;
import org.jbpm.datamodeler.xml.util.XMLNode;

import java.util.Map;
import java.util.Set;

public class DataModelVisitor {

    public static final String NODE_DATA_MODEL = "dataModel";
    public static final String NODE_DATA_OBJECT = "dataObject";
    public static final String NODE_PROPERTY = "property";
    public static final String NODE_ATTRIBUTE = "attribute";

    public static final String ATTR_MODEL_NAME = "name";
    public static final String ATTR_MODEL_VERSION = "version";
    public static final String ATTR_MODEL_FORMAT = "format";

    public static final String ATTR_NAME = "name";
    public static final String ATTR_VALUE = "value";
    public static final String ATTR_CLASS_NAME = "className";
    public static final String ATTR_SUPER_CLASS = "superClass";

    public static final String ATTR_MULTIPLE = "multiple";
    public static final String ATTR_BAG = "bag";

    private XMLNode rootNode;
    private XMLNode currentNode;

    public DataModelVisitor() {
    }

    public XMLNode getRootNode() {
        return rootNode;
    }

    public Object visitDataModel(DataModel dataModel) throws Exception {
        rootNode = new XMLNode(NODE_DATA_MODEL, null);
        currentNode = rootNode;

        currentNode.addAttribute(ATTR_MODEL_NAME, dataModel.getName());
        currentNode.addAttribute(ATTR_MODEL_FORMAT, dataModel.getFormat());
        currentNode.addAttribute(ATTR_MODEL_VERSION, dataModel.getVersion());

        visitAttributes(currentNode, dataModel);

        Set<DataObject> dataObjects = dataModel.getDataObjects();
        if (dataObjects != null) {
            for (DataObject dataObject : dataObjects) {
                visitDataObject(dataObject);
            }
        }
        return currentNode;
    }

    private Object visitDataObject(DataObject dataObject) throws Exception {
        XMLNode dataObjectNode = new XMLNode(NODE_DATA_OBJECT, currentNode);
        dataObjectNode.addAttribute(ATTR_CLASS_NAME, dataObject.getClassName());
        dataObjectNode.addAttribute(ATTR_SUPER_CLASS, dataObject.getSuperClassName());

        //add the attributes for this object
        visitAttributes(dataObjectNode, dataObject);
        currentNode.addChild(dataObjectNode);

        //add the object properties
        currentNode = dataObjectNode;
        Map<String, ObjectProperty> properties = dataObject.getProperties();
        if (properties != null) {
            for (ObjectProperty property : properties.values()) {
                visitDataObjectProperty(property);
            }
        }

        currentNode = dataObjectNode.getParent();

        return dataObjectNode;
    }

    private Object visitDataObjectProperty(ObjectProperty property) {

        XMLNode propertyNode = new XMLNode(NODE_PROPERTY, currentNode);
        propertyNode.addAttribute(ATTR_NAME, property.getName());
        propertyNode.addAttribute(ATTR_CLASS_NAME, property.getClassName());
        if (property.isMultiple()) {
           propertyNode.addAttribute(ATTR_MULTIPLE, Boolean.toString(property.isMultiple()));
           propertyNode.addAttribute(ATTR_BAG, property.getBag());
        }
        currentNode.addChild(propertyNode);

        visitAttributes(propertyNode, property);

        return propertyNode;
    }

    private void visitAttributes(XMLNode node, ModelElement element) {
        Map<String, Attribute> attributes = element.getAttributes();
        XMLNode attributeElement;
        String attrName;
        String attrValue;

        if (attributes != null) {
            for (Attribute attr : attributes.values()) {
                attrName = attr.getName() != null ? attr.getName().trim() : null;

                if (attrName != null && !"".equals(attrName)) {
                    attributeElement = new XMLNode(NODE_ATTRIBUTE, node);
                    attributeElement.addAttribute(ATTR_NAME, attr.getName());
                    attributeElement.addAttribute(ATTR_VALUE, attr.getValue());
                    node.addChild(attributeElement);
                }
            }
        }
    }
}
