package org.jbpm.datamodeler.editor.type;


import org.uberfire.backend.vfs.Path;
import org.uberfire.shared.workbench.type.ResourceTypeDefinition;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataModelResourceTypeDefinition
            implements ResourceTypeDefinition {

    @Override
    public String getShortName() {
        return "data model";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public String getSuffix() {
        return "datamodel";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean accept( final Path path ) {
        return path.getFileName().endsWith( "." + getSuffix() );
    }

    @Override
    public String getSimpleWildcardPattern() {
        return "*.datamodel";
    }
}
