package org.jbpm.datamodeler.codegen;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/22/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestJavaNames {
    
    //private String clientName;
    
    private String ClientName;



    public static void main(String[] args) {
        GenerationTools gt = new GenerationTools();
        System.out.println(gt.toJavaVar("nombreCliente"));

        System.out.println(gt.toJavaClass("TheClassName"));

        System.out.println(gt.toJavaGetter("nombreCliente"));

        System.out.println(gt.toJavaSetter("nombreCliente"));

    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }
}
