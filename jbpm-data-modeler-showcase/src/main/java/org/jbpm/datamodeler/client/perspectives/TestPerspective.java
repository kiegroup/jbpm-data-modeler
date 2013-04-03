package org.jbpm.datamodeler.client.perspectives;

import org.kie.guvnor.commons.ui.client.handlers.NewResourcePresenter;
import org.kie.guvnor.commons.ui.client.handlers.NewResourcesMenu;
import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.annotations.WorkbenchPerspective;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.workbench.Position;
import org.uberfire.client.workbench.model.PanelDefinition;
import org.uberfire.client.workbench.model.PerspectiveDefinition;
import org.uberfire.client.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl;
import org.uberfire.client.workbench.widgets.menu.Menus;
import org.uberfire.shared.mvp.impl.DefaultPlaceRequest;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
@WorkbenchPerspective(identifier = "testPerspective", isDefault = false)
public class TestPerspective {

    @Inject
    private PlaceManager placeManager;

    @PostConstruct
    public void init() {
        buildPerspective();
    }

    @Perspective
    public PerspectiveDefinition buildPerspective() {
        final PerspectiveDefinition p = new PerspectiveDefinitionImpl();
        p.setName( "Test perspective" );

        final PanelDefinition west = new PanelDefinitionImpl();
        west.setWidth( 200 );
        west.setMinWidth( 150 );
        west.addPart( new PartDefinitionImpl(new DefaultPlaceRequest( "TestPresenter"  ) ));

        p.getRoot().insertChild( Position.WEST, west );

        return p;
    }

}
