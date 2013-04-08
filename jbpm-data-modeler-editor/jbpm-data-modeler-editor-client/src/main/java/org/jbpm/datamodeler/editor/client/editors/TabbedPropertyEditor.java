package org.jbpm.datamodeler.editor.client.editors;


import com.github.gwtbootstrap.client.ui.Tab;
import com.github.gwtbootstrap.client.ui.TabPanel;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@Templated(value = "TabbedPropertyEditor.html")
public class TabbedPropertyEditor extends Composite {

    @DataField
    private DivWidget container = new DivWidget();

    private TabPanel tabPanel = new TabPanel(Bootstrap.Tabs.ABOVE);
    
    private Tab modelTab = new Tab();

    private Tab objectTab = new Tab();
    
    private Tab fieldTab = new Tab();
    
    @Inject
    public PropertyEditor2 modelProperties;

    @Inject
    public PropertyEditor2 objectProperties;

    @Inject
    public PropertyEditor2 fieldProperties;

    public TabbedPropertyEditor() {
    }

    @PostConstruct
    private void init() {

        modelTab.setHeading("Model");
        modelTab.add(modelProperties);

        objectTab.setHeading("Data object");
        objectTab.add(objectProperties);

        fieldTab.setHeading("Properties");
        fieldTab.add(fieldProperties);

        tabPanel.add(modelTab);
        tabPanel.add(objectTab);
        tabPanel.add(fieldTab);

        container.add(tabPanel);
        tabPanel.selectTab(0);
    }
}
