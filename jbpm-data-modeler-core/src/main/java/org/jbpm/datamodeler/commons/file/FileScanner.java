package org.jbpm.datamodeler.commons.file;

import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.IOException;
import org.kie.commons.java.nio.file.DirectoryStream;
import org.kie.commons.java.nio.file.Files;
import org.kie.commons.java.nio.file.Path;

import java.util.*;

public class FileScanner {

    public Collection<ScanResult> scan(IOService ioService, Collection<Path> rootPaths, String fileType, boolean recursiveScan) throws IOException {
        ArrayList<String> fileTypes = new ArrayList<String>();
        fileTypes.add(fileType);
        return scan(ioService, rootPaths, fileTypes, recursiveScan);
    }

    public Collection<ScanResult> scan(IOService ioService, Collection<Path> rootPaths, Collection<String> fileTypes, boolean recursiveScan) throws IOException {
        List<ScanResult> results = new ArrayList<ScanResult>();
        final Map<Path, Path> scannedCache = new HashMap<Path, Path>();

        if (rootPaths != null) {
            for (Path root : rootPaths) {
                if (Files.isDirectory(root) && !scannedCache.containsKey(root)) {
                    results.addAll(scan(ioService, root, fileTypes, recursiveScan, scannedCache));
                }
            }
        }
        return results;
    }

    public Collection<ScanResult> scan(IOService ioService, Path root, Collection<String> fileTypes, boolean recursiveScan) throws IOException {
        Collection<Path> roots = new ArrayList<Path>();
        roots.add(root);
        return scan(ioService, roots, fileTypes, recursiveScan);
    }

    private Collection<ScanResult> scan(IOService ioService, Path rootPath, final Collection<String> fileTypes, final boolean recursiveScan, final Map<Path, Path> scannedCache) throws IOException {
        final Collection<ScanResult> results = new ArrayList<ScanResult>();
        final List<Path> childDirectories = new ArrayList<Path>();

        if (rootPath != null) {
            if (Files.isDirectory(rootPath) && !scannedCache.containsKey(rootPath)) {
                scannedCache.put(rootPath, rootPath);

                final DirectoryStream<Path> foundFiles = ioService.newDirectoryStream( rootPath ,
                        new DirectoryStream.Filter<Path>() {

                            @Override
                            public boolean accept( final Path entry ) throws IOException {

                                boolean include = false;

                                if ( Files.isDirectory( entry ) && recursiveScan) {
                                    //use this check iteration to additionally remember child directories
                                    childDirectories.add(entry);
                                } else {
                                    if (fileTypes == null) {
                                        include = true;
                                    } else {
                                        for (String type : fileTypes) {
                                            if (entry.getFileName().toString().endsWith( type )) {
                                                include = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                                return include;
                        }
                } );

                if (foundFiles != null) {
                    for (Path acceptedFile : foundFiles) {
                        results.add(new ScanResult(acceptedFile));
                    }
                }
                
                //finally
                if (recursiveScan) {
                    for (Path child : childDirectories) {
                        results.addAll( scan(ioService, child, fileTypes, recursiveScan, scannedCache) );
                    }
                }
            }
        }
        return results;
    }

    public Collection<ScanResult> scanDirectories(IOService ioService, Path rootPath, final boolean includeRoot, final boolean recursiveScan/*, final Map<Path, Path> scannedCache*/) throws IOException {
        final Collection<ScanResult> results = new ArrayList<ScanResult>();
        final List<Path> childDirectories = new ArrayList<Path>();

        if (rootPath != null) {
            if (Files.isDirectory(rootPath) /* && !scannedCache.containsKey(rootPath)*/) {
                //scannedCache.put(rootPath, rootPath);
                if (includeRoot) results.add(new ScanResult(rootPath));



                final DirectoryStream<Path> children = ioService.newDirectoryStream(rootPath);
                //finally
                if (recursiveScan) {
                    for (Path child : children) {
                        results.addAll( scanDirectories(ioService, child, true, recursiveScan/*, scannedCache*/) );
                    }
                }
            }
        }
        return results;
    }

    public boolean cleanEmptyDirectories(final IOService ioService, Path rootPath, boolean deleteRoot, List<String> deleteableFiles) throws IOException {
        DirDescriptor dirDescriptor;
        if (rootPath != null && Files.isDirectory(rootPath)) {

            final DirectoryStream<Path> children = ioService.newDirectoryStream(rootPath);
            if (children != null) {
                for (Path child : children) {
                    if (Files.isDirectory(child)) {
                        cleanEmptyDirectories(ioService, child, true, deleteableFiles);
                    }
                }
            }
            dirDescriptor = isDeleteableDir(ioService, rootPath, deleteableFiles);
            if (dirDescriptor.isDeleteable()) {
                for (Path child : dirDescriptor.getChildren()) {
                    ioService.delete(child);
                }
                if (deleteRoot) {
                    //Invoke deleteIfExists because when the the last child is removede and JGit filesystem
                    //is installed the directory is removed automatically
                    ioService.deleteIfExists(rootPath);
                    return true;
                }
            }
        }
        return false;
    }

    public DirDescriptor isDeleteableDir(final IOService ioService, Path dirPath, List<String> deleteableFiles) throws IOException {
        DirDescriptor dirDescriptor = new DirDescriptor(dirPath);
        boolean deleteable = false;

        final DirectoryStream<Path> children = ioService.newDirectoryStream(dirPath);
        if (children == null) {
            deleteable = true;
        } else {
            Iterator<Path> iterator = children.iterator();
            if (iterator == null) {
                deleteable = true;
            } else {
                deleteable = true;
                for (Path child : children) {
                    if (Files.isDirectory(child)) {
                        dirDescriptor.setDeleteable(false);
                        return dirDescriptor;
                    }
                    for (String deleteableFile : deleteableFiles) {
                        if (!child.getFileName().endsWith(deleteableFile)) {
                            dirDescriptor.setDeleteable(false);
                            return dirDescriptor;
                        } else {
                            dirDescriptor.addChild(child);
                        }
                    }
                }
            }
        }

        dirDescriptor.setDeleteable(deleteable);
        return dirDescriptor;
    }
    
    class DirDescriptor {

        private boolean deleteable = false;
        
        private List<Path> children = new ArrayList<Path>();

        private Path path;

        DirDescriptor(Path path) {
            this.path = path;
        }

        public boolean isDeleteable() {
            return deleteable;
        }

        public void setDeleteable(boolean deleteable) {
            this.deleteable = deleteable;
        }

        public List<Path> getChildren() {
            return children;
        }

        public void addChild(Path child) {
            children.add(child);
        }

    }

    public boolean isEmpty(final IOService ioService, Path dirPath) throws IOException {
        if (dirPath == null) return true;

        final DirectoryStream<Path> children = ioService.newDirectoryStream(dirPath);
        if (children == null) return true;
        Iterator<Path> iterator = children.iterator();
        return iterator == null || !iterator.hasNext();
    }
}