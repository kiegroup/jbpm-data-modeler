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

import org.apache.xerces.parsers.DOMParser;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.ModelElement;
import org.jbpm.datamodeler.core.ObjectProperty;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.jbpm.datamodeler.xml.SerializerException;
import org.jbpm.datamodeler.xml.util.XMLNode;
import org.jbpm.datamodeler.xml.XMLSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.util.List;

public class XMLSerializerImpl implements XMLSerializer {

    private static final Logger logger = LoggerFactory.getLogger(XMLSerializerImpl.class);

    private static String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    public static XMLSerializer getInstance() {
        return new XMLSerializerImpl();
    }

    @Override
    public String serialize(DataModel dataModel) throws SerializerException {
        StringWriter stringWriter = new StringWriter(1024);
        serialize(dataModel, stringWriter);
        return stringWriter.toString();
    }

    @Override
    public void serialize(DataModel dataModel, Writer writer) throws SerializerException {
        DataModelVisitor visitor = new DataModelVisitor();
        try {
            writer.write(XML_VERSION);
            visitor.visitDataModel(dataModel);
            visitor.getRootNode().writeXML(writer, true, true);
        } catch (Exception e) {
            logger.error("An error was produced during a data model serialization.", e);
            throw new SerializerException(e.getMessage(), e);
        }
    }

    @Override
    public DataModel deserialize(InputStream inputStream) throws SerializerException {
        try {
            Document doc = loadXML(inputStream);
            XMLNode root = initTree(doc);
            return fromXMLNode(root);
        } catch (Exception e) {
            logger.error("An error was produced during a data model deserialization.", e);
            throw new SerializerException(e.getMessage(), e);
        }
    }
    
    @Override
    public DataModel deserialize(String xml) throws SerializerException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());
        return deserialize(byteArrayInputStream);
    }

    protected Document loadXML(InputStream is) throws IOException, ParserConfigurationException, SAXException {
        URL schemaUrl = getClass().getResource("/org/jbpm/datamodeler/xml/DataModel.xsd");

        if (schemaUrl == null) {
            //the .xsd file was not found.
            logger.error("Xsd file DataModel.xsd was not found, the data model can't be parsed from the input source.");
            throw new IOException("Xsd file DataModel.xsd was not found, the data model can't be parsed from the input source.");
        }

        String schema = schemaUrl.toString();

        //Create a DOMParser
        DOMParser parser = new DOMParser();

        //Set the validation feature
        parser.setFeature("http://xml.org/sax/features/validation", true);

        //Set the schema validation feature
        parser.setFeature("http://apache.org/xml/features/validation/schema", true);

        //Set schema full grammar checking
        parser.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);

        //Disable whitespaces
        parser.setFeature("http://apache.org/xml/features/dom/include-ignorable-whitespace", false);

        //Set schema location
        parser.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", schema);

        //Set the error handler
        parser.setErrorHandler(new ErrorHandler() {
            public void error(SAXParseException e) throws SAXParseException {
                logger.error("Parser error was produced.", e);
                throw e;
            }

            public void fatalError(SAXParseException e) throws SAXParseException {
                logger.error("Parser fatal error was produced.", e);
                throw e;
            }

            public void warning(SAXParseException e) {
                //by the moment we simply log warnings
                logger.warn("Parser warning was produced.", e);
            }
        });

        // Put it in a byte array before because the parser closes the stream.
        ByteArrayOutputStream bos = new ByteArrayOutputStream(is.available());
        int byteRead;
        while ((byteRead = is.read()) != -1) {
            bos.write(byteRead);
        }

        //Parse the XML document
        parser.parse(new InputSource(new ByteArrayInputStream(bos.toByteArray())));

        return parser.getDocument();
    }

    /**
     * Calculate the XMLNodes tree.
     */
    protected XMLNode initTree(Document doc) {
        NodeList nlist = doc.getChildNodes();
        Node rootNode = null;
        for (int i = 0; i < nlist.getLength(); i++) {
            Node item = nlist.item(i);
            if (DataModelVisitor.NODE_DATA_MODEL.equals(item.getNodeName()))
                rootNode = item;
        }

        XMLNode node;
        node = new XMLNode("?", null);
        node.loadFromXMLNode(rootNode);

        return node;
    }

    /**
     *
     * @param xmlNode Root of the XMLNodes that defines the data model.
     *
     * @return The data model corresponding to the XMLNodes tree.
     */
    protected DataModel fromXMLNode(XMLNode xmlNode) {
        
        String format = xmlNode.getAttributes().getProperty(DataModelVisitor.ATTR_MODEL_FORMAT);
        String version = xmlNode.getAttributes().getProperty(DataModelVisitor.ATTR_MODEL_VERSION);
        String name = xmlNode.getAttributes().getProperty(DataModelVisitor.ATTR_MODEL_NAME);

        DataModel dataModel = ModelFactoryImpl.getInstance().newModel(name, format);
        dataModel.setVersion(version);

        List<XMLNode> children = xmlNode.getChildren();
        for (XMLNode child : children) {
            if (DataModelVisitor.NODE_ATTRIBUTE.equals(child.getObjectName())) {
                addAttributeFromNode(dataModel, child);
            } else if (DataModelVisitor.NODE_DATA_OBJECT.equals(child.getObjectName())) {
                addDataObjectFromNode(dataModel, child);
            }
        }
        return dataModel;
    }

    protected void addDataObjectFromNode(DataModel dataModel, XMLNode node) {
        String className = node.getAttributes().getProperty(DataModelVisitor.ATTR_CLASS_NAME);
        DataObject dataObject = dataModel.addDataObject(className);

        List<XMLNode> children = node.getChildren();
        for (XMLNode child : children) {
            if (DataModelVisitor.NODE_ATTRIBUTE.equals(child.getObjectName())) {
                addAttributeFromNode(dataObject, child);
            } else if (DataModelVisitor.NODE_PROPERTY.equals(child.getObjectName())) {
                addObjectPropertyFromNode(dataObject, child);
            }
        }
    }

    protected void addObjectPropertyFromNode(DataObject dataObject, XMLNode node) {
        String name = node.getAttributes().getProperty(DataModelVisitor.ATTR_NAME);
        String className = node.getAttributes().getProperty(DataModelVisitor.ATTR_CLASS_NAME);
        String bag = node.getAttributes().getProperty(DataModelVisitor.ATTR_BAG);
        String multiple = node.getAttributes().getProperty(DataModelVisitor.ATTR_MULTIPLE);
        ObjectProperty property = dataObject.addProperty(name, className);

        boolean isMultiple = multiple != null ? Boolean.parseBoolean(multiple) : false;
        property.setMultiple(isMultiple);
        if (property.isMultiple()) {
            property.setBag(bag);
        }
    }

    protected void addAttributeFromNode(ModelElement element, XMLNode node) {
        String name = node.getAttributes().getProperty(DataModelVisitor.ATTR_NAME);
        String value = node.getAttributes().getProperty(DataModelVisitor.ATTR_VALUE);
        element.addAttribute(name, value);
    }

}