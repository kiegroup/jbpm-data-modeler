package org.jbpm.datamodeler.driver.impl;

import org.jbpm.datamodeler.driver.ModelDriverException;

public class DefaultAnnotationDriver extends AbstractAnnotationDriver {


    public DefaultAnnotationDriver() {
    }

    @Override
    protected Object convertValue(String tokenValue) throws ModelDriverException {
        return tokenValue;
    }
}
