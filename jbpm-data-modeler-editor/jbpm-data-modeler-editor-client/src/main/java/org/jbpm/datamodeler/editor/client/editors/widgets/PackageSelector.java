package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.client.util.DataModelerUtils;
import org.jbpm.datamodeler.editor.client.validation.ValidatorService;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackageSelector extends Composite {

    interface PackageSelectorUIBinder
            extends UiBinder<Widget, PackageSelector> {

    }

    @UiField
    ListBox packageList;

    @UiField
    Button newPackage;

    @Inject
    ValidatorService validatorService;

    @Inject
    NewPackagePopup newPackagePopup;

    private static PackageSelectorUIBinder uiBinder = GWT.create(PackageSelectorUIBinder.class);

    public static final String NOT_SELECTED = "NOT_SELECTED";
    public static final String DEFAULT_PACKAGE = "defaultpkg";
    
    private DataModelTO dataModel;

    private DataObjectTO dataObject;
    
    private String newPackageName;

    public PackageSelector() {
        initWidget(uiBinder.createAndBindUi(this));
        
        packageList.addItem("", NOT_SELECTED);
        packageList.addItem(DEFAULT_PACKAGE, DEFAULT_PACKAGE);

    }

    @UiHandler("newPackage")
    void createNewPackage(ClickEvent event) {
        //newPackagePopup.setAfterShow();
        newPackagePopup.show();

        /*
        final NewPackagePopup packagePopup = new NewPackagePopup();
        packagePopup.newPackageButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                setNewPackageName(null);
                final String packgeName = packagePopup.newPackageName.getText() != null ? packagePopup.newPackageName.getText().trim() : "";
                validatorService.isValidPackageIdentifier(packgeName, new ValidatorCallback() {
                    @Override
                    public void onFailure() {
                        packagePopup.setErrorMessage(Constants.INSTANCE.validation_error_invalid_package_identifier(packgeName));
                    }

                    @Override
                    public void onSuccess() {
                        setNewPackageName(packgeName);
                        packagePopup.clean();
                        packagePopup.setVisible(false);
                    }
                });
            }
        });
        
        packagePopup.
        packagePopup.show();
        Window.alert("procesar paquete: " + newPackageName);
        */

    }

    public void enableCreatePackage(boolean enable) {
        newPackage.setVisible(enable);
    }

    public ListBox getPackageList() {
        return packageList;
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
        initList();
    }

    public DataObjectTO getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObjectTO dataObject) {
        this.dataObject = dataObject;
        initList();

        if (dataObject != null && dataObject.getPackageName() != null && !"".equals(dataObject.getPackageName())) {
            packageList.setSelectedValue(dataObject.getPackageName());
        } else {
            packageList.setSelectedValue(NOT_SELECTED);
        }
    }
            
    private void setNewPackageName(String newPackageName) {
        this.newPackageName = newPackageName;
    }

    private void initList() {
        packageList.clear();
        List<String> packageNames = new ArrayList<String>();
        if (dataModel != null) {
            String packageName;
            for (String className : dataModel.getHelper().getClassList()) {
                packageName = DataModelerUtils.getInstance().extractPackageName(className);
                if (packageName != null && !DEFAULT_PACKAGE.equals(packageName) && !packageNames.contains(packageName)) {
                    packageNames.add(packageName);
                }
            }
        }
        Collections.sort(packageNames);
        packageList.addItem("", NOT_SELECTED);
        packageList.addItem(DEFAULT_PACKAGE, DEFAULT_PACKAGE);
        for (String packageName : packageNames) {
            packageList.addItem(packageName, packageName);
        }
    }

}
