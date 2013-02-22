package org.jbpm.datamodeler.impexp;


public interface ImportExportFactory {

    ImportManager newImportManager();

    ExportManager newExportManager();
}
