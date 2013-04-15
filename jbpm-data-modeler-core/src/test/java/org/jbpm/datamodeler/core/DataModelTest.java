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

import org.jbpm.datamodeler.core.impl.AnnotationImpl;
import org.jbpm.datamodeler.driver.impl.MockAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.jbpm.datamodeler.xml.impl.XMLSerializerImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

import static org.junit.Assert.assertNotNull;

public class DataModelTest {
    
    private static final Logger logger = LoggerFactory.getLogger(DataModelTest.class);
    
    @Test
    public void modelTest() throws Exception {


        DataModel dataModel = ModelFactoryImpl.getInstance().newModel("Model1");
        DataObject dataObject;
        ObjectProperty property;

        assertNotNull("Data model was not created", dataModel);

        dataModel.setVersion("1.2.1");
        
        for (int i = 0; i < 6; i++) {
            //dataModel.addAnnotation("attribute"+i, i+"");
        }

        logger.debug("Creating data model");
        for (int i = 0; i < 10; i++) {
            dataObject = dataModel.addDataObject("org.jbpm.datamodeler.test"+i, "DataObject"+i);
            for (int j = 0; j < 5; j++) {
                property = dataObject.addProperty("property"+j, Integer.class.getName());
                if (j % 2 == 0) {
                    property.setMultiple(true);

                    AnnotationImpl attr = new AnnotationImpl(new MockAnnotationDefinition("@attribute"+j, "kaka", "attribute"+j, "attribute"+j));

                    property.addAnnotation(attr);
                }
            }
        }

        Iterator<DataObject> it = dataModel.getDataObjects().iterator();
        while (it.hasNext()) {
            dataObject = it.next();
            logger.debug("created data object: " + dataObject);
        }


        logger.debug("Serializing data model");
        XMLSerializerImpl serializer = new XMLSerializerImpl();
        String xml = serializer.serialize(dataModel);
        logger.debug("Resulting serialization: \n" + xml);

        DataModel unserial =  serializer.deserialize(xml);

    }
}
