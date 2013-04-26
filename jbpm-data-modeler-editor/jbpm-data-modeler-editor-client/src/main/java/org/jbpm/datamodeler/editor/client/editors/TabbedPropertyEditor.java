package org.jbpm.datamodeler.editor.client.editors;


import com.github.gwtbootstrap.client.ui.Tab;
import com.github.gwtbootstrap.client.ui.TabPanel;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor.PropertyEditor;
import org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor.PropertyEditorValue;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Dependent
@Templated(value = "TabbedPropertyEditor.html")
public class TabbedPropertyEditor extends Composite {

    @DataField
    private DivWidget container = new DivWidget();

    public TabPanel tabPanel = new TabPanel(Bootstrap.Tabs.ABOVE);
    
    private Tab modelTab = new Tab();

    private Tab objectTab = new Tab();
    
    private Tab fieldTab = new Tab();
    
    @Inject
    public PropertyEditor modelProperties;

    @Inject
    public PropertyEditor objectProperties;

    @Inject
    public PropertyEditor fieldProperties;

    private DataModelTO dataModel;

    public TabbedPropertyEditor() {
    }

    @PostConstruct
    private void init() {

        //modelTab.setHeading("Model");
        //modelTab.add(modelProperties);

        objectTab.setHeading("Entity");
        objectTab.add(objectProperties);

        fieldTab.setHeading("Field");
        fieldTab.add(fieldProperties);

        //tabPanel.add(modelTab);
        tabPanel.add(objectTab);
        tabPanel.add(fieldTab);

        container.add(tabPanel);
        tabPanel.selectTab(0);
    }
    
    public void setDataObject(DataObjectTO dataObject) {
        //build the list data object attributes that will be edited
        loadDataObjectAttributes(dataObject);
    }

    public void setDataObjectProperty(ObjectPropertyTO selectedProperty) {
        loadObjectPropertyAttributes(selectedProperty);
    }

    public void setDataModel(DataModelTO dataModel) {
        //loadDataModelAttributes(dataModel);
        this.dataModel = dataModel;
    }

    public void notifyDataModelChanged() {
        fieldProperties.refresh();
    }

    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        fieldProperties.setBaseTypes(baseTypes);
    }

    private void loadDataObjectAttributes(DataObjectTO dataObject) {

        //TODO complete this implementation in a more generic way supporting attributes automatically.

        PropertyEditorValue propertyEditorValue;
        List<PropertyEditorValue> properties = new ArrayList<PropertyEditorValue>();

        //Init the standard set of data object manipulable attributes.
        propertyEditorValue = new PropertyEditorValue("name", dataObject.getName() != null ? dataObject.getName() : "");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("shortName", "logical name");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("description", "data object documentation");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("packageName", dataObject.getPackageName() != null ? dataObject.getPackageName() : "");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("superClass", dataObject.getSuperClassName() != null ? dataObject.getSuperClassName() : "");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("@Role", "event/fact/null?");
        properties.add(propertyEditorValue);



        /*
        propertyEditorValue = new PropertyEditorValue("documentation", "");
        properties.add(propertyEditorValue);
        */

        objectProperties.setProperties(properties);
    }

    private void loadObjectPropertyAttributes(ObjectPropertyTO selectedProperty) {

        //TODO complete this implementation in a more generic way supporting attributes automatically.

        PropertyEditorValue propertyEditorValue;
        List<PropertyEditorValue> properties = new ArrayList<PropertyEditorValue>();

        //Init the standard set of data object property manipulable attributes.
        propertyEditorValue = new PropertyEditorValue("name", selectedProperty.getName() != null ? selectedProperty.getName() : "");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("shortName", "logical name");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("description", "field documentation");
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("type", selectedProperty.getClassName());
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("equals", Boolean.FALSE);
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("required", Boolean.FALSE);
        properties.add(propertyEditorValue);

        propertyEditorValue = new PropertyEditorValue("@Position", "");
        properties.add(propertyEditorValue);

        fieldProperties.setEntityTypes(dataModel.getDataObjects());
        fieldProperties.setProperties(properties);
    }

    private void loadDataModelAttributes(DataModelTO dataModel) {
        PropertyEditorValue propertyEditorValue;
        List<PropertyEditorValue> properties = new ArrayList<PropertyEditorValue>();

        //Init the standard set of data object property manipulable attributes.
        propertyEditorValue = new PropertyEditorValue("name", dataModel.getName() != null ? dataModel.getName() : "");
        properties.add(propertyEditorValue);
        /*
        propertyEditorValue = new PropertyEditorValue("documentation", "");
        properties.add(propertyEditorValue);
        */
        modelProperties.setProperties(properties);
    }
}