package org.jbpm.datamodeler.editor.client.editors;

import com.github.gwtbootstrap.client.ui.Breadcrumbs;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

import java.util.ArrayList;
import java.util.List;

public class DataObjectBreadcrums extends Breadcrumbs {

    int size = 5;
    
    private List<BufferElement> buffer = new ArrayList<BufferElement>();

    public DataObjectBreadcrums(int size) {
        super();
        this.size = size;
    }

    public DataObjectBreadcrums() {
        super();
    }

    @Override
    public void clear() {
        super.clear();
        buffer.clear();
    }

    public void add(DataObjectTO dataObject, final Command command) {

        boolean exists = false;
        if (buffer.size() > 0) {
            BufferElement lastItem = buffer.get(buffer.size() - 1);
            exists = lastItem.getDataObject().equals(dataObject);
        }

        if (!exists) {
            if (buffer.size() >= size) {
                //remove first element
                buffer.remove(0);
            }

            //create the new widget
            NavLink navLink = new NavLink(dataObject.getName());
            navLink.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    command.execute();
                }
            });
            buffer.add(new BufferElement(dataObject, navLink));

            rebuild();
        }
    }

    private void rebuild() {
        super.clear();
        for (BufferElement element : buffer) {
             add(element.getWidget());
        }
    }

    class BufferElement {

        DataObjectTO dataObject;
        Widget widget;

        BufferElement(DataObjectTO dataObject, Widget widget) {
            this.dataObject = dataObject;
            this.widget = widget;
        }

        public DataObjectTO getDataObject() {
            return dataObject;
        }

        public void setDataObject(DataObjectTO dataObject) {
            this.dataObject = dataObject;
        }

        public Widget getWidget() {
            return widget;
        }

        public void setWidget(Widget widget) {
            this.widget = widget;
        }
    }
}