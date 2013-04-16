package org.jbpm.datamodeler.codegen.parser;

import org.jbpm.datamodeler.annotations.DataObject;
import org.jbpm.datamodeler.codegen.GenerationListener;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */


public @DataObject class  Class2 {

    class Pepito {
        int a;

    }

    static {

        int caka = 0;
    }


    void metodo() {

        class Pepito2 {
            int a;

        }

        GenerationListener listener = new GenerationListener() {
            @Override
            public void assetGenerated(String fileName, String content) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };


    }

}
