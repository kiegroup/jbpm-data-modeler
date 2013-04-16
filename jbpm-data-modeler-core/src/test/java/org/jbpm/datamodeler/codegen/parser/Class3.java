package org.jbpm.datamodeler.codegen.parser;

import org.jbpm.datamodeler.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/15/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */

@BasicAnnotation("Conejo")
@TestAnnotation (name = "TestPojo", children = {"juan", "pedro"})
@DataObject   (name="EntityClass3", model = "TestModel.txt")
public class Class3 extends java.util.Date implements Serializable{

    protected Integer intA;

    @IsMethod(owner = "juancito", methodName = "anotado")
    private static final void anotado() {

    }

    @BasicAnnotation
    public Class3(Integer intA) {
        this.intA = intA;
    }

    @BasicAnnotation
    @Equals
    public static String strB;

    @BasicAnnotation("rokoko")
    private Date dateSimple;

    @TestAnnotation
    void metodo() {

    }
    
    @TestAnnotation(size = 45)
    int count = 0;

    @Equals
    private String a, b, c;

    @Equals
    @BasicAnnotation("jijiji")
    private String e, f, g = "jaime";
}
