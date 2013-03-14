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

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.jbpm.datamodeler.xml.SerializerException;
import org.jbpm.datamodeler.xml.XMLNode;
import org.jbpm.datamodeler.xml.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class XMLSerializerImpl implements XMLSerializer {

    private static String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

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
            throw new SerializerException(e.getMessage(), e);
        }
    }

    public String serialize2(DataModel dataModel) {
        StringWriter writer = new StringWriter();
        serialize2(dataModel, writer);
        
        return writer.toString();
    }

    public void serialize2(DataModel dataModel, Writer writer) {

        //TODO provide final implementation
        try {

            DataModelMock modelMock = new DataModelMock();
            modelMock.setName(dataModel.getName());
            modelMock.setPackageName("");
    
            for (DataObject dataObject : dataModel.getDataObjects()) {
                modelMock.getDataObjects().add(dataObject.getName());
                modelMock.setPackageName(dataObject.getPackageName());
            }
    
            JAXBContext jaxbContext = JAXBContext.newInstance(DataModelMock.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    
            jaxbMarshaller.marshal(modelMock, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public DataModel unserializeOLD(String xml) throws SerializerException {
        //TODO provide final implementation

        StringReader reader = new StringReader(xml);
        return unserialize(reader);
    }

    public DataModel unserializeOLD(Reader reader) throws SerializerException {
        //TODO provide final implementation

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataModelMock.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DataModelMock mock = (DataModelMock) jaxbUnmarshaller.unmarshal(reader);

            DataModel dataModel = ModelFactoryImpl.getInstance().newModel(mock.getName());


            for (String dataObjectName : mock.getDataObjects()) {
                dataModel.addDataObject(mock.getPackageName(), dataObjectName);
            }
            return dataModel;

        } catch (Exception e) {
            e.printStackTrace();
            throw new SerializerException(e.getMessage(), e);
        }

    }

    @Override
    public DataModel unserialize(Reader xml) throws SerializerException {
        //TODO provide final implementation
        return null;
    }
    
    @Override
    public DataModel unserialize(String xml) throws SerializerException {
        //TODO provide final implementation

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());
        try {
            Document doc = load(byteArrayInputStream);
            XMLNode root = initTree(doc);
            return fromXMLNode(root);
        } catch (Exception e) {

        }
        StringReader reader = new StringReader(xml);
        return null;
    }

    protected Document load(InputStream is) throws IOException, ParserConfigurationException, SAXException, SAXNotRecognizedException {
        URL schemaUrl = getClass().getResource("../DataModel.xsd");

        if (schemaUrl == null) {
            //log.fatal("Could not find [repositoryExport.xsd]. Used [" + getClass().getClassLoader() + "] class loader in the search.");
            return null;
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
            public void error(SAXParseException exception) throws SAXParseException {
                throw exception;
            }

            public void fatalError(SAXParseException exception) throws SAXParseException {
                throw exception;
            }

            public void warning(SAXParseException exception) {
                /*getWarnings().add(exception.getMessage());
                getWarningArguments().add(new Object[]{exception});*/
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

        Document doc = parser.getDocument();
        return doc;
    }

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

    private DataModel fromXMLNode(XMLNode xmlNode) {
        DataModel dataModel = ModelFactoryImpl.getInstance().newModel(xmlNode.getAttributes().getProperty(DataModelVisitor.ATTR_MODEL_NAME));
        dataModel.setVersion(xmlNode.getAttributes().getProperty(DataModelVisitor.ATTR_MODEL_VERSION));

        List<XMLNode> children = xmlNode.getChildren();
        for (XMLNode node : children) {
            if (DataModelVisitor.NODE_ATTRIBUTE.equals(node.getObjectName())) {
                //procesar un atributo
            } else if (DataModelVisitor.NODE_DATA_OBJECT.equals(node.getObjectName())) {
                addDataObjectFromNode(dataModel, node);
            }
        }

        return dataModel;
                
    }

    private void addDataObjectFromNode(DataModel dataModel, XMLNode node) {
        String className = node.getAttributes().getProperty(DataModelVisitor.ATTR_CLASS_NAME);
        DataObject dataObject = dataModel.addDataObject(className);
                
    }
}
