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

import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertNotNull;


public class DataModelTest {
    
    
    @Test
    public void modelTest() throws Exception {
        DataModel dataModel = ModelFactoryImpl.getInstance().newModel("Model1");
        DataObject dataObject;
        ObjectProperty property;

        assertNotNull("Data model was not created", dataModel);

        
        for (int i = 0; i < 10; i++) {
            dataObject = dataModel.addDataObject("org.jbpm.datamodeler.test"+i, "DataObject"+i);
            for (int j = 0; j < 5; j++) {
                property = dataObject.addProperty("property"+j, Integer.class.getName());
            }
        }

        Iterator<DataObject> it = dataModel.getDataObjects().iterator();
        while (it.hasNext()) {
            dataObject = it.next();
            System.out.println(dataObject.getClassName());
        }





    }
}
