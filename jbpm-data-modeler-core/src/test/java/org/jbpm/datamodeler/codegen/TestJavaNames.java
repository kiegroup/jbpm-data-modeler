package org.jbpm.datamodeler.codegen;


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
