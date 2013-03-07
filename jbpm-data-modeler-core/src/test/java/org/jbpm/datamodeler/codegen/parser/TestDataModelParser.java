package org.jbpm.datamodeler.codegen.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Before;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestDataModelParser {

    DataModelParser parser;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = TestDataModelParser.class.getResourceAsStream("Class1.java.test");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);
        parser = new DataModelParser(antlrInputStream);
    }

    @org.junit.Test
    public void testParser() throws Exception {
        DataObjectToken token = parser.parse();
        
        assertEquals("Class1", token.getClassName());
        assertEquals("org.jbpm.datamodeler.codegen.parser", token.getPackageName());
        assertEquals("org.jbpm.Class1Parent", token.getSuperClassName());

        //TODO complete the test
        //check the imports
        assertEquals(3, token.getImports().size());

        assertEquals(5, token.getProperties().size());
        for (DataObjectPropertyToken property : token.getProperties()) {
            if (property.getName().equals("cantidad")) {
                assertEquals("Integer", property.getType());
            } else if (property.getName().equals("nombre")) {
                assertEquals("String", property.getType());
            } else if (property.getName().equals("edad")) {
                assertEquals("int", property.getType());
            } else if (property.getName().equals("enabled")) {
                assertEquals("java.lang.Boolean", property.getType());
            } else if (property.getName().equals("list")) {
                assertEquals("List<Integer>", property.getType());
            } else {
                fail("Property " + property.getName() + " was not parsed");
            }
        }
    }
}
