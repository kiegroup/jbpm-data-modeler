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
