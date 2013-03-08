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
import org.jbpm.datamodeler.xml.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLSerializerImpl implements XMLSerializer {

    @Override
    public String serialize(DataModel dataModel) {
        StringWriter writer = new StringWriter();
        serialize(dataModel, writer);
        
        return writer.toString();
    }

    @Override
    public void serialize(DataModel dataModel, Writer writer) {

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

    @Override
    public DataModel unserialize(String xml) throws SerializerException {
        //TODO provide final implementation

        StringReader reader = new StringReader(xml);
        return unserialize(reader);
    }

    @Override
    public DataModel unserialize(Reader reader) throws SerializerException {
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

}
