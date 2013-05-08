package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.editors.resources.i18n.Constants;
import org.jbpm.datamodeler.editor.client.validation.ValidatorCallback;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.uberfire.client.common.Popup;

import javax.inject.Inject;


public class NewPackagePopup extends Popup {

    TextBox newPackageName;

    public Button newPackageButton;

    String packageName;

    HelpInline errorMessages;

    ControlGroup newPackageControlGroup;

    ControlGroup errorMessagesGroup;

    @Inject
    ValidatorService validatorService;

    public NewPackagePopup() {
        setModal(true);
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String getTitle() {
        return "New package";
    }

    @Override
    public Widget getContent() {

        VerticalPanel mainPanel = new VerticalPanel();
        HorizontalPanel dataPanel = new HorizontalPanel();

        newPackageName = new TextBox();
        newPackageButton = new Button("Add");
        errorMessages = new HelpInline();
        newPackageControlGroup = new ControlGroup();
        errorMessagesGroup = new ControlGroup();

        newPackageControlGroup.add(newPackageName);

        errorMessagesGroup.add(errorMessages);

        dataPanel.add(newPackageControlGroup);
        dataPanel.add(newPackageButton);
        mainPanel.add(dataPanel);
        mainPanel.add(errorMessagesGroup);
        
        newPackageButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                setPackageName(null);
                final String packgeName = newPackageName.getText() != null ? newPackageName.getText().trim() : "";
                validatorService.isValidPackageIdentifier(packgeName, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        setErrorMessage(Constants.INSTANCE.validation_error_invalid_package_identifier(packgeName));
                    }

                    @Override
                    public void onSuccess() {
                        setPackageName(packgeName);
                        clean();
                        hide();
                    }
                });
            }
        });

        return mainPanel;
    }

    public void clean() {
        newPackageName.setText("");
        cleanErrors();
    }

    public void cleanErrors() {
        errorMessages.setText("");
        newPackageControlGroup.setType(ControlGroupType.NONE);
        errorMessagesGroup.setType(ControlGroupType.NONE);
    }

    public void setErrorMessage(String errorMessage) {
        newPackageControlGroup.setType(ControlGroupType.ERROR);
        errorMessages.setText(errorMessage);
        errorMessagesGroup.setType(ControlGroupType.ERROR);
    }
}