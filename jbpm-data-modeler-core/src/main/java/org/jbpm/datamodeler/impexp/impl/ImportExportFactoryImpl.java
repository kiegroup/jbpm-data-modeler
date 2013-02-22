package org.jbpm.datamodeler.impexp.impl;

import org.jbpm.datamodeler.impexp.ExportManager;
import org.jbpm.datamodeler.impexp.ImportExportFactory;
import org.jbpm.datamodeler.impexp.ImportManager;

public class ImportExportFactoryImpl implements ImportExportFactory {

    public static ImportExportFactory getInstance() {
        return new ImportExportFactoryImpl();
    }

    @Override
    public ImportManager newImportManager() {
        return new ImportManagerImpl();
    }

    @Override
    public ExportManager newExportManager() {
        return new ExportManagerImpl();
    }
}
