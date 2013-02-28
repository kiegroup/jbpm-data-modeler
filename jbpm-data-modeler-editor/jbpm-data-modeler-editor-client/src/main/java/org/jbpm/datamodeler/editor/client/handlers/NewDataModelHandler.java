package org.jbpm.datamodeler.editor.client.handlers;

import com.google.gwt.user.client.ui.IsWidget;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.type.DataModelResourceType;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.kie.guvnor.commons.ui.client.handlers.DefaultNewResourceHandler;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.shared.mvp.PlaceRequest;
import org.uberfire.shared.mvp.impl.PathPlaceRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NewDataModelHandler extends DefaultNewResourceHandler {

    @Inject
    private Caller<DataModelerService> modelerService;

    @Inject
    private PlaceManager placeManager;

    @Inject
    private DataModelResourceType resourceType;

    @Override
    public String getDescription() {
        return "Data Model";
    }

    @Override
    public IsWidget getIcon() {
        return null;
    }

    @Override
    public void create(final Path context,
                        final String baseFileName) {

        modelerService.call( new RemoteCallback<Path>() {
            @Override
            public void callback( final Path path ) {
                notifySuccess();
                final PlaceRequest place = new PathPlaceRequest(path, "DataModelEditor");
                placeManager.goTo(place);
            }
        } ).createModel(context, buildFileName(resourceType, baseFileName));
    }

}
