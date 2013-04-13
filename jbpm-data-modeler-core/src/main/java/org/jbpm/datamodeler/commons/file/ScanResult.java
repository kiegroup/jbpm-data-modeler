package org.jbpm.datamodeler.commons.file;

import org.kie.commons.java.nio.file.Path;

public class ScanResult {

    private Path file;

    public ScanResult(Path file) {
        this.file = file;
    }

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }
}
