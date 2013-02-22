/**
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.datamodeler.client.perspectives;

import javax.enterprise.context.ApplicationScoped;

import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.annotations.WorkbenchPerspective;
import org.uberfire.client.workbench.Position;
import org.uberfire.client.workbench.model.PanelDefinition;
import org.uberfire.client.workbench.model.PartDefinition;
import org.uberfire.client.workbench.model.PerspectiveDefinition;
import org.uberfire.client.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl;
import org.uberfire.shared.mvp.impl.DefaultPlaceRequest;

@ApplicationScoped
@WorkbenchPerspective(identifier = "homePerspective", isDefault = true)
public class HomePerspective {

    @Perspective
    public PerspectiveDefinition buildPerspective() {
        final PerspectiveDefinition p = new PerspectiveDefinitionImpl();
        p.setName( "Home" );



        /*
        final PanelDefinition north = new PanelDefinitionImpl();
        north.addPart(new PartDefinitionImpl( new DefaultPlaceRequest( "MessagePanel" )) );
        north.setWidth(250);
        north.setMinWidth(200);
        p.getRoot().insertChild(Position.NORTH, north);
        */

        /*
        final PanelDefinition editor = new PanelDefinitionImpl();
        editor.addPart(new PartDefinitionImpl( new DefaultPlaceRequest( "DataModelEditor" )) );
        editor.setWidth(250);
        editor.setMinWidth(200);
        */


        PartDefinition editor = new PartDefinitionImpl( new DefaultPlaceRequest( "DataModelEditor" ));
        p.getRoot().addPart(editor);
        //p.getRoot().insertChild(Position.NORTH, editor);


        /*
        final PanelDefinition south = new PanelDefinitionImpl();
        south.addPart(new PartDefinitionImpl(new DefaultPlaceRequest("HelloPanel")) );
        south.setWidth(250);
        south.setMinWidth(200);
        p.getRoot().insertChild(Position.SOUTH, south);
        */


/*
        final PanelDefinition west = new PanelDefinitionImpl();
        west.addPart(new PartDefinitionImpl(new DefaultPlaceRequest("MessagePanel")) );
        west.setWidth(250);
        west.setMinWidth(200);
        p.getRoot().insertChild(Position.WEST, west);



        final PanelDefinition east = new PanelDefinitionImpl();
        east.addPart(new PartDefinitionImpl(new DefaultPlaceRequest("MessagePanel")) );
        east.setWidth(250);
        east.setMinWidth(200);
        p.getRoot().insertChild(Position.EAST, east);

*/

        /**


        final PanelDefinition west = new PanelDefinitionImpl();
        west.addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "YouTubeVideos" ) ) );
        west.setWidth( 250 );
        west.setMinWidth( 200 );
        p.getRoot().insertChild( Position.WEST, west );

        final PanelDefinition east = new PanelDefinitionImpl();
        east.addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "TodoListScreen" ) ) );
        east.setWidth( 300 );
        east.setMinWidth( 200 );
        p.getRoot().insertChild( Position.EAST, east );

        p.getRoot().addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "welcome" ) ) );
        p.getRoot().setMinHeight( 100 );

        final PanelDefinition south = new PanelDefinitionImpl();
        south.addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "YouTubeScreen" ) ) );
        south.setHeight( 400 );
        p.getRoot().insertChild( Position.SOUTH, south );
         **/

        return p;
    }
}
