package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.editors.DataModelerContext;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SuperclassSelector extends Composite {

    interface SuperclassSelectorUIBinder
            extends UiBinder<Widget, SuperclassSelector> {

    }

    @UiField
    ListBox superclassList;

    private DataModelerContext context;

    private DataObjectTO dataObject;

    private static SuperclassSelectorUIBinder uiBinder = GWT.create(SuperclassSelectorUIBinder.class);

    public static final String NOT_SELECTED = "NOT_SELECTED";

    public SuperclassSelector() {
        initWidget(uiBinder.createAndBindUi(this));
        initList();
    }

    public ListBox getSuperclassList() {
        return superclassList;
    }

    public DataModelerContext getContext() {
        return context;
    }

    public void setContext(DataModelerContext context) {
        this.context = context;
        initList();
    }

    public void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
        initList();
        if (dataObject != null && dataObject.getSuperClassName() != null) {
            superclassList.setSelectedValue(dataObject.getSuperClassName());
        } else {
            superclassList.setSelectedValue(NOT_SELECTED);
        }
    }

    private DataModelTO getDataModel() {
        return getContext() != null ? getContext().getDataModel() : null;
    }

    private void initList() {
        superclassList.clear();

        List<String> classNames = new ArrayList<String>();
        if (getDataModel() != null) {
            for (String className : getContext().getHelper().getClassList()) {
                if (dataObject != null && className.equalsIgnoreCase(dataObject.getClassName())) continue;
                classNames.add(className);
            }
        }

        Collections.sort(classNames);
        superclassList.addItem("", NOT_SELECTED);
        for (String className : classNames) {
            superclassList.addItem(className, className);
        }
    }
}