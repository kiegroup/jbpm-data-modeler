package org.jbpm.datamodeler.editor.service;

import org.jboss.errai.bus.server.annotations.Remote;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.uberfire.backend.vfs.Path;

@Remote
public interface DataModelerService {

    DataModelTO loadModel(final Path path);
    
    void saveModel(DataModelTO dataModel, final Path path);
    
    Path createModel(Path context, String fileName);

    Path resolveResourcePackage(final Path path);
}
