package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.Tab;
import com.github.gwtbootstrap.client.ui.TabPanel;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.model.DataModelTO;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


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
    private DataObjectDetailEditor objectProperties;

    @Inject
    private DataObjectFieldEditor fieldProperties;

    private DataModelTO dataModel;

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

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
        objectProperties.setDataModel(dataModel);
        fieldProperties.setDataModel(dataModel);
    }
}