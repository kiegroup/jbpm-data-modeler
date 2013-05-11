package org.jbpm.datamodeler.editor.client.editors;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.client.editors.widgets.PackageSelector;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@Templated(value = "TestPresenter.html")
public class TestPresenterViewImpl extends Composite
        implements TestPresenter.TestPresenterView {


    private TestPresenter presenter;

    /*
    @Inject
    private TabbedPropertyEditor tabbedPropertyEditor;
    */

    @DataField
    private SimplePanel propertiesPanel = new SimplePanel();

    @Inject
    @DataField
    private DataObjectEditor detailPanel;


    @DataField
    private PackageSelector packageSelector = new PackageSelector();
    

    /*
    @Inject
    private PropertyEditor propertyEditor;
    */


    public TestPresenterViewImpl() {
    }

    @Override
    public void init(final TestPresenter presenter) {
        this.presenter = presenter;
        //propertiesPanel.add(propertyEditor);
    }
}