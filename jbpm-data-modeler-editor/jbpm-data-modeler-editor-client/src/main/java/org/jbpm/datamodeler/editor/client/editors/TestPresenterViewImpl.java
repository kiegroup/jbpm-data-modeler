package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.client.editors.widgets.PropertyEditorCell;
import org.jbpm.datamodeler.editor.client.editors.widgets.PropertyEditorValue;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 3/27/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Dependent
@Templated(value = "TestPresenter.html")
public class TestPresenterViewImpl extends Composite
        implements TestPresenter.TestPresenterView {


    private TestPresenter presenter;

    @Inject
    private TabbedPropertyEditor tabbedPropertyEditor;

    @DataField
    private SimplePanel propertiesPanel = new SimplePanel();

    CellTable<PropertyEditorValue> cellTable = new CellTable<PropertyEditorValue>();

    ListDataProvider<PropertyEditorValue> cellTableValues = new ListDataProvider<PropertyEditorValue>();

    @DataField
    Button showProperties = new Button("Show properties");

    public TestPresenterViewImpl() {
    }

    @Override
    public void init(final TestPresenter presenter) {
        this.presenter = presenter;


        final List<PropertyEditorValue> values = new ArrayList<PropertyEditorValue>();
        values.add(new PropertyEditorValue("campoString1", "valor1"));
        values.add(new PropertyEditorValue("campoBoolean1", Boolean.TRUE));
        values.add(new PropertyEditorValue("campoDate1", new Date()));
        values.add(new PropertyEditorValue("campoString2", "valor2"));
        values.add(new PropertyEditorValue("campoBoolean2", Boolean.FALSE));
        values.add(new PropertyEditorValue("campoDate2", new Date()));

        cellTableValues.setList(values);

        Column <PropertyEditorValue, String> nameColumn = new Column<PropertyEditorValue, String>(new TextCell()) {
            @Override
            public String getValue(PropertyEditorValue object) {
                return object.getName();
            }
        };

        Column<PropertyEditorValue, PropertyEditorValue> valueColumn = new Column<PropertyEditorValue, PropertyEditorValue>(new PropertyEditorCell()) {
            @Override
            public PropertyEditorValue getValue(PropertyEditorValue object) {
                return object;
            }
        };
        
        valueColumn.setFieldUpdater(new FieldUpdater<PropertyEditorValue, PropertyEditorValue>() {
            @Override
            public void update(int index, PropertyEditorValue object, PropertyEditorValue value) {
                object.setValue(value.getValue());
            }
        });

        cellTable.addColumn(nameColumn, "name");
        cellTable.addColumn(valueColumn, "value");
        cellTableValues.addDataDisplay(cellTable);

        propertiesPanel.add(cellTable);
        
        showProperties.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PopupPanel popup = new PopupPanel(true, true);
                VerticalPanel vp = new VerticalPanel();
                for (PropertyEditorValue value : values) {
                    vp.add(new Label(value.getName() + " : " + value.getValue()));
                }
                popup.add(vp);
                popup.center();
            }
        });
    }


    /**

     Cosas deseables:


           Configuracion de editores por nombre de propiedad:

           Map customEditors = new HashMap();
           Cell<C> myCell = new Cell<C> algo....
           customEditors.put("nombre", myCell);  y magicamente la celda que edita esa property "nombre" es otra.

           //por defecto tenemos un conjunto de editores predefinidos para tipos basicos como String, Date, Boolean, Numericos

           Eventualmente tambien por tipo, por si queremos cambiar el editor para un tipo.

           Luego eventos que deberia producir

           editor.addPropertyEditorListener(new PropertyEditorListener() {

               Retorna true si ese nuevo valor es aceptable para esa property.

               public boolean doBeforePropertyChange(PropertyEditor source, String propertyName, Object value, Object oldValue) {
                   return true;
               }

              public void onPropertyChange(PropertyGridPanel source, String propertyName, Object value, Object oldValue) {
                Es invocado cuando la propiedad propertyName ha cambiado de valor desde
              }
           });


     */
}