package org.jbpm.datamodeler.codegen.parser;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModifierToken {

    private String name;

    public ModifierToken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
