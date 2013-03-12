package org.jbpm.datamodeler.editor.client.handlers;

import com.google.gwt.core.client.Callback;
import com.google.gwt.user.client.ui.IsWidget;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.type.DataModelResourceType;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.kie.guvnor.commons.ui.client.handlers.DefaultNewResourceHandler;
import org.kie.guvnor.commons.ui.client.handlers.NewResourcePresenter;
import org.kie.guvnor.commons.ui.client.popups.file.CommandWithCommitMessage;
import org.kie.guvnor.commons.ui.client.popups.file.SaveOperationService;
import org.kie.guvnor.commons.ui.client.resources.i18n.CommonConstants;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.common.BusyPopup;
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
        return Constants.INSTANCE.modelEditor_newModel();
    }

    @Override
    public IsWidget getIcon() {
        return null;
    }

    @Override
    public void acceptPath(final Path path, final Callback<Boolean, Void> callback) {
        modelerService.call( new RemoteCallback<Path>() {
            @Override
            public void callback( final Path path ) {
                callback.onSuccess( path != null );
            }
        } ).resolveResourcePackage(path);
    }

    @Override
    public void create(final Path context,
                        final String baseFileName,
                        final NewResourcePresenter presenter) {

        BusyPopup.showMessage("Creating datamodel");
        modelerService.call( new RemoteCallback<Path>() {
            @Override
            public void callback( final Path path ) {                
                BusyPopup.close();
                presenter.complete();
                notifySuccess();
                final PlaceRequest place = new PathPlaceRequest(path, "DataModelEditor");
                placeManager.goTo(place);
            }
        } ).createModel(context, buildFileName(resourceType, baseFileName));
    }

}
