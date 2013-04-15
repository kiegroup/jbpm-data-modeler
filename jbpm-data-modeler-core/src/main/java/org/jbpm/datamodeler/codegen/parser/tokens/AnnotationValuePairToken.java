package org.jbpm.datamodeler.codegen.parser.tokens;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnnotationValuePairToken {
    
    private String name;
    
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
