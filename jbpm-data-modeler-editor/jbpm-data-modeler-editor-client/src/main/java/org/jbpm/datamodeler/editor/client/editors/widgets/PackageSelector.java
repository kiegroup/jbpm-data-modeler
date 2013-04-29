package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.uberfire.client.common.Popup;

public class PackageSelector extends Composite {

    interface PackageSelectorUIBinder
            extends UiBinder<Widget, PackageSelector> {

    }

    @UiField
    ListBox packageList;

    @UiField
    Button newPackage;

    private static PackageSelectorUIBinder uiBinder = GWT.create(PackageSelectorUIBinder.class);
    
    private DataModelTO dataModelTO;

    public PackageSelector() {
        initWidget(uiBinder.createAndBindUi(this));
        
        packageList.addItem("com.redhat.datamodeler", "com.redhat.datamodeler");
        packageList.addItem("com.microsoft.business", "com.microsoft.business");
    }


    @UiHandler("newPackage")
    void createNewPackage(ClickEvent event) {
        final Popup pop = new AddPopup();
        pop.setTitle("Create new package");
        pop.show();
    }

    public class AddPopup extends Popup {
        @Override
        public Widget getContent() {

            HorizontalPanel dataPanel = new HorizontalPanel();

            //final Label newPackageLabel = new Label("new")
            final TextBox newPackageName = new TextBox();
            final Button newPackageButton = new Button("Add");
            dataPanel.add(newPackageName);
            dataPanel.add(newPackageButton);

            newPackageButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    packageList.addItem(newPackageName.getText(), newPackageName.getText());
                    packageList.setSelectedValue(newPackageName.getText());
                }
            });

            return dataPanel;
        }
    }

}
