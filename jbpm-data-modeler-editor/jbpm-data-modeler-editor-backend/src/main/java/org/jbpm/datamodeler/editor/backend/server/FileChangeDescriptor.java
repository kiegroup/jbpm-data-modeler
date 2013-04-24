package org.jbpm.datamodeler.editor.backend.server;


import org.uberfire.backend.vfs.Path;

public class FileChangeDescriptor {

    public static final int ADD = 0;
    public static final int DELETE = 1;
    public static final int UPDATE = 2;

    Path path;
    int action;

    public FileChangeDescriptor(Path path, int action) {
        this.path = path;
        this.action = action;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
