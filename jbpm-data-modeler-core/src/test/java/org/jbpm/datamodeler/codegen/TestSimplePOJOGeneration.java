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

import java.math.BigDecimal;
import java.util.Date;

public class TestSimplePOJOGeneration {
    private DataModel dataModel;

    public DataModel getInvoiceModel() {
        if (dataModel == null) {
            String packageName = "org.jbpm.datamodeler.test.invoice";
            dataModel = ModelFactoryImpl.getInstance().newModel("Invoice model");

            DataObject invoiceModel = dataModel.addDataObject(packageName, "Invoice");

            invoiceModel.addProperty("invoiceNumber", Long.class.getName());
            invoiceModel.addProperty("date", Date.class.getName());
            invoiceModel.addProperty("client", String.class.getName());
            invoiceModel.addProperty("totalAmount", BigDecimal.class.getName());

            DataObject invoiceLineModel = dataModel.addDataObject(packageName, "InvoiceLine");

            invoiceModel.addProperty("lines", invoiceLineModel.getClassName(), true);

            invoiceLineModel.addProperty("lineNumber", Integer.class.getName());
            invoiceLineModel.addProperty("article", String.class.getName());
            invoiceLineModel.addProperty("unitPrice", BigDecimal.class.getName());
            invoiceLineModel.addProperty("units", Integer.class.getName());
            invoiceLineModel.addProperty("lineTotal", BigDecimal.class.getName());

        }

        return dataModel;
    }

    @org.junit.Test
    public void testName() throws Exception {
        GenerationContext generationContext = new GenerationContext(getInvoiceModel());
        generationContext.setOutputPath("/tmp");
        GenerationEngine.getInstance().generate(generationContext);
    }
}
