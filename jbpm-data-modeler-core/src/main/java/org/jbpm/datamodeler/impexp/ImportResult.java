package org.jbpm.datamodeler.impexp;

import org.jbpm.datamodeler.core.DataModel;

import java.util.List;


public interface ImportResult {

    List<ImportExportMessage> getWarnings();

    List<ImportExportMessage> getErrors();

    Exception getException();

    boolean hasErrors();
    
    DataModel getDataModel();
}
