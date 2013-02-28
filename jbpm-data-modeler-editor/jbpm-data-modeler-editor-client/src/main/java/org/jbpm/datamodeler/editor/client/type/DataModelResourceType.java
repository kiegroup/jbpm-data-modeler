package org.jbpm.datamodeler.editor.client.type;

import com.google.gwt.user.client.ui.IsWidget;
import org.jbpm.datamodeler.editor.type.DataModelResourceTypeDefinition;
import org.uberfire.client.workbench.type.ClientResourceType;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataModelResourceType extends DataModelResourceTypeDefinition
    implements ClientResourceType {

    @Override
    public IsWidget getIcon() {
        return null;
    }

}
