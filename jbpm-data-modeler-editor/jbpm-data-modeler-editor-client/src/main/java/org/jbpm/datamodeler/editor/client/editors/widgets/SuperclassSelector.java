package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.events.DataModelerEvent;
import org.jbpm.datamodeler.editor.events.DataObjectSelectedEvent;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

import javax.enterprise.event.Observes;
import javax.xml.crypto.Data;


public class SuperclassSelector extends Composite {

    interface SuperclassSelectorUIBinder
            extends UiBinder<Widget, SuperclassSelector> {

    }

    @UiField
    ListBox superclassList;

    DataModelTO dataModel;
    DataObjectTO dataObject;

    private static SuperclassSelectorUIBinder uiBinder = GWT.create(SuperclassSelectorUIBinder.class);

    public SuperclassSelector() {
        initWidget(uiBinder.createAndBindUi(this));
        initList();
    }

    public ListBox getSuperclassList() {
        return superclassList;
    }

    public void setSuperclassList(ListBox superclassList) {
        this.superclassList = superclassList;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }

    public void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
        initList();
    }

    private void onDataObjectSelected(@Observes DataObjectSelectedEvent event) {
        if (event.isFrom(getDataModel())) {
            System.out.println("YUJUUUUUUUUUUUUUUUUUUU!!!!!!!");
        }
    }

    private void initList() {
        superclassList.clear();
        if (dataModel != null) {
            for (String className : dataModel.getHelper().getClassList()) {
                if (dataObject != null && className.equalsIgnoreCase(dataObject.getClassName())) continue;
                superclassList.addItem(className, className);
            }
        }
    }
}