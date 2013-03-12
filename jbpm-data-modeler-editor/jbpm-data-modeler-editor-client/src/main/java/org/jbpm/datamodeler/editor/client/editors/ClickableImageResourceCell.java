package org.jbpm.datamodeler.editor.client.editors;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

import java.util.HashSet;
import java.util.Set;

import static com.google.gwt.dom.client.BrowserEvents.CLICK;
import static com.google.gwt.dom.client.BrowserEvents.KEYDOWN;

public class ClickableImageResourceCell extends ImageResourceCell {

    private boolean asAnchor = false;

    public ClickableImageResourceCell() {
    }

    public ClickableImageResourceCell(boolean asAnchor) {
        this.asAnchor = asAnchor;
    }

    @Override
    public Set<String> getConsumedEvents() {
        Set<String> consumedEvents = new HashSet<String>();
        consumedEvents.add(CLICK);
        consumedEvents.add(KEYDOWN);
        return consumedEvents;
    }

    @Override
    public void onBrowserEvent(Cell.Context context, Element parent, ImageResource value,
                               NativeEvent event, ValueUpdater<ImageResource> valueUpdater) {
        switch (DOM.eventGetType((Event) event)) {
            case Event.ONCLICK:
                valueUpdater.update(value);
                break;

        }
    }

    @Override
    public void render(Context context, ImageResource value, SafeHtmlBuilder sb) {

        if (value != null) {
            SafeHtml startAnchor = null;
            SafeHtml endAnchor = null;
            if (asAnchor) {
                startAnchor = new SafeHtml() {
                    @Override
                    public String asString() {
                        return "<a href=\"#\">";
                    }
                };

                endAnchor = new SafeHtml() {
                    @Override
                    public String asString() {
                        return "</a>";
                    }
                };

                sb.append(startAnchor);
            }
            super.render(context, value, sb);
            if (asAnchor) {
                sb.append(endAnchor);
            }
        }
    }
}