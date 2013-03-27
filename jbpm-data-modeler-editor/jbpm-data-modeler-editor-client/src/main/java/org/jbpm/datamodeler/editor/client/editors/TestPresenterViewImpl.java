package org.jbpm.datamodeler.editor.client.editors;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.model.DataModelTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 3/27/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Dependent
@Templated(value = "TestPresenter.html")
public class TestPresenterViewImpl extends Composite
        implements TestPresenter.TestPresenterView {


    private TestPresenter presenter;

    @Inject
    private TabbedPropertyEditor tabbedPropertyEditor;

    @DataField
    private SimplePanel propertiesPanel = new SimplePanel();

    public TestPresenterViewImpl() {
    }

    @Override
    public void init(final TestPresenter presenter) {
        this.presenter = presenter;
        propertiesPanel.add(tabbedPropertyEditor);
    }
}