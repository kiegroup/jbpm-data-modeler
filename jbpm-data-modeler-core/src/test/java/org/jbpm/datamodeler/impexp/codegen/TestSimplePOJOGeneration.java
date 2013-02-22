package org.jbpm.datamodeler.impexp.codegen;

import org.jbpm.datamodeler.codegen.GenerationContext;
import org.jbpm.datamodeler.codegen.GenerationEngine;
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
