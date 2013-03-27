package org.jbpm.datamodeler.editor.client.editors;

import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.type.DataModelResourceType;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.annotations.WorkbenchEditor;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;
import org.uberfire.client.workbench.widgets.menu.Menus;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.List;

@Dependent
@WorkbenchScreen(identifier = "TestPresenter")
public class TestPresenter {

    public interface TestPresenterView
            extends
            UberView<TestPresenter> {

    }

    @Inject
    TestPresenterView view;

    @Inject
    private Event<NotificationEvent> notification;


    @WorkbenchPartTitle
    public String getTitle() {
        return "Test editor";
    }

    @WorkbenchPartView
    public UberView<TestPresenter> getView() {
        return view;
    }

}


