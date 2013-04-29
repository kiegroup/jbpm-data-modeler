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
    
    private DataModelTO dataModel;

    public PackageSelector() {
        initWidget(uiBinder.createAndBindUi(this));
        
        packageList.addItem("com.redhat.datamodeler", "com.redhat.datamodeler");
        packageList.addItem("com.microsoft.business", "com.microsoft.business");
    }


    @UiHandler("newPackage")
    void createNewPackage(ClickEvent event) {
        final Popup pop = new AddPopup();
        pop.show();
    }

    public class AddPopup extends Popup {

        @Override
        public String getTitle() {
            return "New package";
        }

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

                    //TODO aqui hay que agregar la valicacion de
                    //1) Que el nombre de paquete sea valido.
                    //2) Que no se ponga un paquete repetido.
                    //Tener en cuenta que la lista de paquetes a mostrar
                    //deberia salir del modelo

                    boolean validationOk = true;

                    String packageName = newPackageName.getText();

                    validationOk = !"com".equals(packageName);

                    if (validationOk) {
                        //algo similar a esto
                        packageList.addItem(newPackageName.getText(), newPackageName.getText());
                        packageList.setSelectedValue(newPackageName.getText());

                        //OBS por favor fijate si una vez hecho esto del lado del widget editor del DataObject
                        //efectivamente nos enteremos del cambio y de esta forma poder
                        //setear el paquete que toca al DataObject que se esta editando.

                        //al final de todo el popup debe cerrarse a si mismo pues la seleccion ya está hecha
                        setVisible(false);


                    } else {

                        //Mostrar algo que diga que el nombre elegido no es valido

                        //si el valor no es valido el popup NO se cierra automaticamente
                        //dejaremos que lo cierre el usuario explicitamente con la crucesita de arriba a la derecha
                        //que va en el poup.

                        //En este caso como el valor seleccioando NO ha cambiado, no deberia hacerse ningun cambio en el objeto

                    }
                }
            });

            return dataPanel;
        }
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }
}
