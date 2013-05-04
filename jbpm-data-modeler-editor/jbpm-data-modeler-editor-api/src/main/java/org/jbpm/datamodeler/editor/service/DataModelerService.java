package org.jbpm.datamodeler.editor.service;

import org.jboss.errai.bus.server.annotations.Remote;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.uberfire.backend.vfs.Path;

import java.util.List;

@Remote
public interface DataModelerService {

    Path createModel(Path context, String fileName);

    Path resolveProject(Path path);

    DataModelTO loadModel(final Path path);
    
    void saveModel(DataModelTO dataModel, final Path path);
    
    //void generateModel(DataModelTO dataModel, final Path path);

    /**
     * Indicates if given path related to a project is inside project resources path. (src/main/resources or src/test/resources)
     *
     * e.g. MyProject/src/main/resources/myfiles is inside the project main resources path.
     * e.g. MyProject/src/test/java/org/jboss is not.
     *
     * @param resource The path to check.
     *
     * @return resource if the path is inside the resources path, null in any other case.
     *
     */
    Path resolveResourcePackage(final Path resource);

    List<PropertyTypeTO> getBasePropertyTypes();

}
