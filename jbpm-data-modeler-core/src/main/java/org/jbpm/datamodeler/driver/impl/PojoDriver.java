package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.core.Attribute;
import org.jbpm.datamodeler.core.AttributeDefinition;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.impl.AttributeImpl;
import org.jbpm.datamodeler.driver.ModelDriver;
import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.Path;

import java.util.*;


public class PojoDriver implements ModelDriver {

    @Override
    public DataModel loadModel(IOService ioService, Collection<Path> rootPaths, boolean recursiveScan) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void generateModel(IOService ioService, Path root) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<AttributeDefinition> getConfiguredAttributes() {
        List<AttributeDefinition> list = new ArrayList<AttributeDefinition> ();
        list.add(new EqualsAttributeDefinition());
        list.add(new RequiredAttributeDefinition());

        return list;
    }

    @Override
    public Attribute newAttribute(AttributeDefinition attributeDefinition) {
        //check if the definition is valid for this driver
        return new AttributeImpl(attributeDefinition);
    }
}
