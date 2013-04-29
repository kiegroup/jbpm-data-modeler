package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.PropertyTypeTO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Dependent
@Templated(value = "PropertyEditor.html")
public class PropertyEditor extends Composite {

    @DataField
    private VerticalPanel propertiesPanel = new VerticalPanel();

    CellTable<PropertyEditorValue> cellTable = new CellTable<PropertyEditorValue>();
    
    Column<PropertyEditorValue, String> nameColumn;
    
    Column<PropertyEditorValue, PropertyEditorValue> valueColumn;

    Column<PropertyEditorValue, String> errorColumn;

    PropertyEditorCell editorCell;

    ListDataProvider<PropertyEditorValue> cellTableValues = new ListDataProvider<PropertyEditorValue>();

    private List<PropertyTypeTO> baseTypes;
    private List<DataObjectTO> entityTypes;

    PropertyEditorConfig config = new PropertyEditorConfig();
    DynamicSelectionCell attributeTypesCombo = new DynamicSelectionCell();

    public PropertyEditor() {
    }

    @PostConstruct
    public void init() {
        config.setCell("type", attributeTypesCombo);

        nameColumn = new Column<PropertyEditorValue, String>(new TextCell()) {
            @Override
            public String getValue(PropertyEditorValue object) {
                return object.getName();
            }
        };

        editorCell = new PropertyEditorCell(cellTable, config);
        valueColumn = new Column<PropertyEditorValue, PropertyEditorValue>(editorCell) {
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

        errorColumn = new Column<PropertyEditorValue, String>(new TextCell()) {
            @Override
            public String getValue(PropertyEditorValue object) {
                StringBuffer errorBuffer = new StringBuffer();
                if (object.isHasError()) {
                    for (PropertyChangeError error : object.getErrors()) {
                        errorBuffer.append(error.getMsg()).append("\n");
                    }
                }
                return errorBuffer.toString();
            }
        };

        cellTable.addColumn(nameColumn, "Name");
        cellTable.addColumn(valueColumn, "Value");
        //TODO complete the layout and presentation of this column
        cellTable.addColumn(errorColumn);

        cellTableValues.addDataDisplay(cellTable);
        propertiesPanel.add(cellTable);

        initTestStuff();
    }

    public void addPropertyEditorListener(PropertyEditorListener listener) {
        //TODO evalutate the posibility to use a list of listeners
        if (config != null) {
            config.setPropertyEditorListener(listener);
        }
    }

    public void setBaseTypes(List<PropertyTypeTO> baseTypes) {
        this.baseTypes = baseTypes;
        populateAttributeTypesDynCombo();
    }

    public void setEntityTypes(List<DataObjectTO> entityTypes) {
        this.entityTypes = entityTypes;
        populateAttributeTypesDynCombo();
    }

    public void setProperties(List<PropertyEditorValue> properties) {
        //Init a new property set to edit.
        cellTableValues.getList().clear();
        cellTableValues.getList().addAll(properties);
        cellTableValues.flush();
        cellTableValues.refresh();
    }

    public void refresh() {
        populateAttributeTypesDynCombo();
        cellTable.redraw();
    }

    private void populateAttributeTypesDynCombo() {
        List<String> options = new ArrayList<String>(baseTypes.size());
        if (baseTypes != null && baseTypes.size() > 0) {
            for (PropertyTypeTO baseType : baseTypes) {
                options.add(baseType.getName());
            }
        }
        if (entityTypes != null && entityTypes.size() > 0) {
            for (DataObjectTO entityType : entityTypes) {
                String className = entityType.getClassName();
                options.add(className);
                options.add(className + "[1..N]");
            }
        }
        attributeTypesCombo.setOptions(options);
    }

    void initTestStuff() {
        //TODO remove this method

        boolean dale = false;

        if (dale) {
            final List<PropertyEditorValue> values = new ArrayList<PropertyEditorValue>();
            values.add(new PropertyEditorValue("campoString1", "valor1"));
            values.add(new PropertyEditorValue("campoBoolean1", Boolean.TRUE));
            values.add(new PropertyEditorValue("campoDate1", new Date()));
            values.add(new PropertyEditorValue("campoString2", "valor2"));
            values.add(new PropertyEditorValue("campoBoolean2", Boolean.FALSE));
            values.add(new PropertyEditorValue("campoDate2", new Date()));
            values.add(new PropertyEditorValue("color", "amarillo"));

            List<String> colors = new ArrayList<String>();
            colors.add("blanco");
            colors.add("rojo");
            colors.add("amarillo");
            colors.add("negro");

            SelectionCell colorSelectorCell = new SelectionCell(colors);

            config.setCell("color", colorSelectorCell);


            cellTableValues.setList(values);
            cellTableValues.refresh();

            config.setPropertyEditorListener(new PropertyEditorListener() {
                @Override
                public boolean doBeforePropertyChange(PropertyEditor source, String propertyName, Object pendingValue, Object currentValue, List<PropertyChangeError> errors) {
                    //Window.alert("doBeforePropertyChange: " + propertyName + " pendingValue: " + pendingValue + ", currentValue: " + currentValue);

                    if ("kaka".equals(pendingValue) || "hola".equals(pendingValue) || "negro".equals(pendingValue)) {
                        errors.add(new PropertyChangeError("Wrong value: " + pendingValue));
                        return false;
                    }

                    if (pendingValue instanceof Date) {
                        if (((Date) pendingValue).getTime() < (new Date()).getTime()) {
                            errors.add(new PropertyChangeError("La fecha elegida no puede ser menor"));
                            errors.add(new PropertyChangeError(" que la fecha actual."));
                            return false;
                        }
                    }

                    if ("edad".equals(propertyName)) {
                        if ( ((BigInteger)pendingValue).intValue() > 100) {
                            errors.add(new PropertyChangeError("La edad no puede ser mayor que 100!"));
                            return false;
                        }
                    }
                    return true;
                }

                @Override
                public void onPropertyChange(PropertyEditor source, String propertyName, Object newValue, Object currentValue) {
                    //Window.alert("value change event: property: " + propertyName + ", newValue: " + newValue + ", oldValue: " + currentValue);
                }
            });
        }

        Button showProperties = new Button("Show properties");        
        showProperties.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PopupPanel popup = new PopupPanel(true, true);
                VerticalPanel vp = new VerticalPanel();
                for (PropertyEditorValue value : cellTableValues.getList()) {
                    vp.add(new Label(value.getName() + "-> value: " + value.getValue() + ", oldValue: " + value.getOldValue() + ", pendingValue: " + value.getPendingValue() + ", hasErrors: " + value.isHasError()));
                }
                popup.add(vp);
                popup.center();
            }
        });
        propertiesPanel.add(showProperties);
    }

}