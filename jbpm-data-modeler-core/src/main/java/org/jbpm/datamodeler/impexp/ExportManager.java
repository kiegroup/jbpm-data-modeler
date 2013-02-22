package org.jbpm.datamodeler.impexp;

import org.jbpm.datamodeler.core.DataModel;
import org.uberfire.backend.vfs.Path;

public interface ExportManager {

    ExportResult exportToXML(DataModel dataModel);
    
    ExportResult exportToJava(DataModel dataModel, Path path);

}
