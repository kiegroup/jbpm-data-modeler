package org.jbpm.datamodeler.impexp.impl;

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.impexp.ImportResult;


public class ImportResultImpl extends ImportExportResult implements ImportResult {
 
    private DataModel dataModel;

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}
