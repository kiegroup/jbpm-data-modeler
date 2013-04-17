package org.jbpm.datamodeler.codegen.parser;


import org.jbpm.datamodeler.codegen.parser.tokens.DataObjectPropertyToken;
import org.jbpm.datamodeler.codegen.parser.tokens.DataObjectToken;

public class TestGenerics extends ParserBaseTest {

    public TestGenerics() {
        super("TestGenerics.java.test");
    }

    @Override
    public void loadTestModel() {

        addImport("org.jbpm.datamodeler.annotations.*");
        addImport("java.io.Serializable");
        addImport("java.util.Date");

        addImport("org.jbpm.datamodeler.core.DataObject");
        addImport("java.util.HashMap");
        addImport("java.util.List");
        addImport("java.util.Map");

        setPackageName("org.jbpm.datamodeler.codegen.parser.test");

        addClassModifier("public");

        setClassName("TestGenerics");
        setSuperClassName("org.jbpm.datamodeler.TestBase");

        addClassAnnotation("TestMarkerAnnotation", null);
        addClassAnnotation("TestValueAnnotation", new String[][] {{"value", toAnnotatedParamFormat("nothing")}});

        //finally add the properties

        // public List<Element> elements;
        DataObjectPropertyToken propertyToken = addProperty("elements", "List<Element>", new String[]{"public"});


        // private List<String> names = new ArrayList<String>();
        propertyToken = addProperty("names", "List<String>", new String[]{"private"});

        // protected Map<String, List<Integer>> listMap = new HashMap<String, List<Integer>>();
        //TODO whe  the token is parsed blank spaces are removed. check this later, but it's not a problem
        propertyToken = addProperty("listMap", "Map<String,List<Integer>>", new String[]{"protected"});

        // Map<Collection<DataObject>, List<Integer>> listMap1 = new HashMap<Collection<DataObject>, List<Integer>>();
        propertyToken = addProperty("listMap1", "Map<Collection<DataObject>,List<Integer>>", null);

        /*
        @Equals
        Map<Collection<DataObject>, List<Integer>> listMap2 = new HashMap<Collection<DataObject>, List<Integer>>();
        */
        propertyToken = addProperty("listMap2", "Map<Collection<DataObject>,List<Integer>>", null);
        addPropertyAnnotation(propertyToken, "Equals", null);


        propertyToken = addProperty("listMap3", "Map<java.util.Collection<invented.DataObject>,List<Integer>>", null);

    }

    @Override
    public void postTest() {
        DataObjectToken token = this.getDataObjectToken();
        token.toString();
    }
}
