package org.jbpm.datamodeler.editor.service;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
