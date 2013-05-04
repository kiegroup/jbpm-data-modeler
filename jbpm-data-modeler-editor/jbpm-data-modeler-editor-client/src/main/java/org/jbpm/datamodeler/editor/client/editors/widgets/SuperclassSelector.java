package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.model.DataObjectTO;


public class SuperclassSelector extends Composite {

    //TODO terminar
    public void setDataObject(DataObjectTO dataObject) {
        //To change body of created methods use File | Settings | File Templates.
    }

    interface SuperclassSelectorUIBinder
            extends UiBinder<Widget, SuperclassSelector> {

    }

    @UiField
    ListBox superclassList;

    private static SuperclassSelectorUIBinder uiBinder = GWT.create(SuperclassSelectorUIBinder.class);

    public SuperclassSelector() {
        initWidget(uiBinder.createAndBindUi(this));

        superclassList.addItem("org.pack1.TypeTestParent", "org.pack1.TypeTestParent");
        //superclassList.addItem("com.redhat.datamodeler.Class1", "com.redhat.datamodeler.Class1");
        //superclassList.addItem("com.redhat.datamodeler.Class2", "com.redhat.datamodeler.Class2");
    }

    public ListBox getSuperclassList() {
        return superclassList;
    }

    public void setSuperclassList(ListBox superclassList) {
        this.superclassList = superclassList;
    }



}