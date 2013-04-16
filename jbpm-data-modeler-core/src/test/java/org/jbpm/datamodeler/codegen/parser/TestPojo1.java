package org.jbpm.datamodeler.codegen.parser;


import org.jbpm.datamodeler.codegen.parser.tokens.DataObjectPropertyToken;

public class TestPojo1 extends ParserBaseTest {

    public TestPojo1() {
        super("TestPojo1.java.test");
    }

    @Override
    public void loadTestModel() {

        addImport("org.jbpm.datamodeler.annotations.*");
        addImport("java.io.Serializable");
        addImport("java.util.Date");

        addClassModifier("public");

        setClassName("TestPojo1");
        setPackageName("org.jbpm.datamodeler.codegen.parser");
        setSuperClassName("org.jbpm.datamodeler.TestBase");

        addInterfaceImplementation("Serializable");
        addInterfaceImplementation("java.lang.Redhatizable");


        addClassAnnotation("TestMarkerAnnotation", null);
        addClassAnnotation("TestValueAnnotation", new String[][] {{"value", toAnnotatedParamFormat("value.content")}});
        addClassAnnotation("TestValuePairAnnotation", new String[][] {
                {"param1", toAnnotatedParamFormat("param1.content")},
                {"param2", "2"},
                {"param3", "true"},
                {"param4", "{\"one\", \"two\", \"three\"}"}}
        );


        //finally add the properties

        //@Equals int intA;
        DataObjectPropertyToken propertyToken = addProperty("intA", "int", null);
        addPropertyAnnotation(propertyToken, "Equals", null);

        //TODO if this should be a valid property
        //public static final String TEST_POJO
        propertyToken = addProperty("TEST_POJO", "String", new String[]{"public", "static", "final"});


        // @Required protected Integer intB;
        propertyToken = addProperty("intB", "Integer", new String[]{"protected"});
        addPropertyAnnotation(propertyToken, "Required", null);


        //@TestBasicAnnotation @Equals public static String strB;
        propertyToken = addProperty("strB", "String", new String[]{"public", "static"});
        addPropertyAnnotation(propertyToken, "TestBasicAnnotation", null);
        addPropertyAnnotation(propertyToken, "Equals", null);

        //private Date dateSimple;
        propertyToken = addProperty("dateSimple", "Date", new String[]{"private"});

        //@TestSizeAnnotation(size = 45) int count = 0;
        propertyToken = addProperty("count", "int", null);
        addPropertyAnnotation(propertyToken, "TestSizeAnnotation", new String[][] {{"size", "45"}});


        /*
        @Equals
        private String a, b, c;
        */

        propertyToken = addProperty("a", "String", new String[] {"private"});
        addPropertyAnnotation(propertyToken, "Equals", null);

        propertyToken = addProperty("b", "String", new String[] {"private"});
        addPropertyAnnotation(propertyToken, "Equals", null);

        propertyToken = addProperty("c", "String", new String[] {"private"});
        addPropertyAnnotation(propertyToken, "Equals", null);

        /*
        @Equals
        @BasicValueAnnotation("value.content")
        private String e, f, g = "jaime";
        */

        propertyToken = addProperty("e", "String", new String[] {"private"});
        addPropertyAnnotation(propertyToken, "Equals", null);
        addPropertyAnnotation(propertyToken, "BasicValueAnnotation",  new String[][] {{"value", toAnnotatedParamFormat("value.content")}});

        propertyToken = addProperty("f", "String", new String[] {"private"});
        addPropertyAnnotation(propertyToken, "Equals", null);
        addPropertyAnnotation(propertyToken, "BasicValueAnnotation",  new String[][] {{"value", toAnnotatedParamFormat("value.content")}});

        propertyToken = addProperty("g", "String", new String[] {"private"});
        addPropertyAnnotation(propertyToken, "Equals", null);
        addPropertyAnnotation(propertyToken, "BasicValueAnnotation",  new String[][] {{"value", toAnnotatedParamFormat("value.content")}});

        //static final String myClassName = "my name";
        propertyToken = addProperty("myClassName", "String", new String[] {"static", "final"});

    }
}
