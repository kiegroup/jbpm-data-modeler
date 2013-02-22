package org.jbpm.datamodeler.impexp;

import java.io.InputStream;
import org.uberfire.backend.vfs.*;

public interface ImportManager {

    ImportResult importFromXML(InputStream inputStream);

    ImportResult importFromXML(String content);

    ImportResult importFromXML(Path path);

}
