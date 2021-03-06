package org.jbpm.datamodeler.commons.file;

import org.kie.commons.io.IOService;
import org.kie.commons.java.nio.file.DirectoryStream;
import org.kie.commons.java.nio.file.Files;
import org.kie.commons.java.nio.file.Path;

import org.kie.commons.java.nio.IOException;
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

    public boolean cleanEmptyDirectories(final IOService ioService, Path rootPath) throws IOException {
        if (rootPath != null && Files.isDirectory(rootPath)) {
            if (isEmpty(ioService, rootPath)) {
                Files.delete(rootPath);
                return true;
            } else {
                final DirectoryStream<Path> children = ioService.newDirectoryStream(rootPath);
                for (Path child : children) {
                    cleanEmptyDirectories(ioService, child);
                }
                if (isEmpty(ioService, rootPath)) {
                    Files.delete(rootPath);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty(final IOService ioService, Path dirPath) throws IOException {
        if (dirPath == null) return true;

        final DirectoryStream<Path> children = ioService.newDirectoryStream(dirPath);
        if (children == null) return true;        
        Iterator<Path> iterator = children.iterator();
        return iterator == null || !iterator.hasNext();
    }
}