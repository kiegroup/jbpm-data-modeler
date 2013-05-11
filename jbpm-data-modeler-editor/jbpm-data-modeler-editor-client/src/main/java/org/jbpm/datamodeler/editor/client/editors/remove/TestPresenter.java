package org.jbpm.datamodeler.editor.client.editors.remove;

import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

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


