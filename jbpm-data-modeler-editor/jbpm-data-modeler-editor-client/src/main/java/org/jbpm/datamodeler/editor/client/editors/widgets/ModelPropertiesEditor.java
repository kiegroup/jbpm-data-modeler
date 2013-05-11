package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.Tab;
import com.github.gwtbootstrap.client.ui.TabPanel;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.editors.DataModelerContext;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;


public class ModelPropertiesEditor extends Composite {

    interface ModelPropertiesEditorUIBinder
        extends UiBinder<Widget, ModelPropertiesEditor> {

    }

    private static ModelPropertiesEditorUIBinder uiBinder = GWT.create(ModelPropertiesEditorUIBinder.class);

    @UiField (provided = true)
    public TabPanel tabPanel = new TabPanel(Bootstrap.Tabs.ABOVE);

    private Tab objectTab = new Tab();

    private Tab fieldTab = new Tab();

    @Inject
    private DataObjectEditor objectProperties;

    @Inject
    private DataObjectFieldEditor fieldProperties;

    private DataModelerContext context;

    public ModelPropertiesEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @PostConstruct
    private void init() {

        objectTab.setHeading("Entity");
        objectTab.add(objectProperties);

        fieldTab.setHeading("Field");
        fieldTab.add(fieldProperties);

        tabPanel.add(objectTab);
        tabPanel.add(fieldTab);


        tabPanel.selectTab(0);
    }

    public DataModelerContext getContext() {
        return context;
    }

    public void setContext(DataModelerContext context) {
        this.context = context;
        objectProperties.setContext(context);
        fieldProperties.setContext(context);
    }

    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        fieldProperties.setBaseTypes(baseTypes);
    }
}