package org.jbpm.datamodeler.impexp;

import java.util.List;

public interface ExportResult {

    List<ImportExportMessage> getWarnings();

    List<ImportExportMessage> getErrors();
    
    Exception getException();

    boolean hasErrors();

    String getContent();
}
