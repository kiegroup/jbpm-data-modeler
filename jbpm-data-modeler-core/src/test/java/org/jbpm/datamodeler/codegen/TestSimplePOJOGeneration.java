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

package org.jbpm.datamodeler.codegen;

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;
import org.jbpm.datamodeler.core.impl.ModelFactoryImpl;
import org.junit.Before;

public class TestSimplePOJOGeneration {
    private DataModel dataModel;

    @Before
    public void setUp() throws Exception {
        GenerationEngine.getInstance().init();
    }

    public DataModel getInvoiceModel() {
        if (dataModel == null) {
            String packageName = "org.jboss.test.invoice";
            dataModel = ModelFactoryImpl.getInstance().newModel("Invoice model");

            DataObject invoiceModel = dataModel.addDataObject(packageName, "Invoice");

            invoiceModel.addProperty("ref", Long.class.getName());
            invoiceModel.addProperty("date", java.util.Date.class.getName());
            invoiceModel.addProperty("issuer", String.class.getName());

            DataObject invoiceLineModel = dataModel.addDataObject(packageName, "InvoiceLine");

           invoiceLineModel.addProperty("client", String.class.getName());
            
            DataObject carModel = dataModel.addDataObject("org.jboss.test.cars", "Car");
            carModel.addProperty("matricula", "java.lang.String");
            carModel.addProperty("asientos", "java.lang.Integer");

        }

        return dataModel;
    }

    @org.junit.Test
    public void testName() throws Exception {
        GenerationContext generationContext = new GenerationContext(getInvoiceModel());
        generationContext.addTemplateSet("POJOS");
        generationContext.setOutputPath("/tmp");
        generationContext.setPackageName("org.jboss.test");

        GenerationEngine.getInstance().generateAllTemplates(generationContext);
    }
}
