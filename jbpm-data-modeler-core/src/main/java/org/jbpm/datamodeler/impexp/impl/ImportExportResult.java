package org.jbpm.datamodeler.impexp.impl;

import org.jbpm.datamodeler.impexp.ImportExportMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class ImportExportResult {

    private List<ImportExportMessage> errors = new ArrayList<ImportExportMessage>();

    private List<ImportExportMessage> warnings = new ArrayList<ImportExportMessage>();

    private Exception exception;

    public ImportExportResult() {
    }

    public List<ImportExportMessage> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<ImportExportMessage> warnings) {
        this.warnings = warnings;
    }

    public List<ImportExportMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ImportExportMessage> errors) {
        this.errors = errors;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public void addError(ImportExportMessage error) {
        getErrors().add(error);
    }

    public boolean hasErrors() {
        return exception != null || !errors.isEmpty();
    }
}
