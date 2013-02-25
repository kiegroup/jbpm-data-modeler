package org.jbpm.datamodeler.editor.client.editors;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DataModelBrowser_DataModelBrowserUIBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.jbpm.datamodeler.editor.client.editors.DataModelBrowser>, org.jbpm.datamodeler.editor.client.editors.DataModelBrowser.DataModelBrowserUIBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Create new entity")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.jbpm.datamodeler.editor.client.editors.DataModelBrowser owner) {


    return new Widgets(owner).get_mainPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.jbpm.datamodeler.editor.client.editors.DataModelBrowser owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.newEntityClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.modelSelected(event);
      }
    };

    public Widgets(final org.jbpm.datamodeler.editor.client.editors.DataModelBrowser owner) {
      this.owner = owner;
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.jbpm.datamodeler.editor.client.editors.DataModelBrowser_DataModelBrowserUIBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.jbpm.datamodeler.editor.client.editors.DataModelBrowser_DataModelBrowserUIBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.jbpm.datamodeler.editor.client.editors.DataModelBrowser_DataModelBrowserUIBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.jbpm.datamodeler.editor.client.editors.DataModelBrowser_DataModelBrowserUIBinderImpl_GenBundle) GWT.create(org.jbpm.datamodeler.editor.client.editors.DataModelBrowser_DataModelBrowserUIBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for mainPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_mainPanel() {
      return build_mainPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_mainPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel mainPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      mainPanel.add(get_modelName());
      mainPanel.add(get_dataObjectsTable());
      mainPanel.add(get_f_HTML1());
      mainPanel.add(get_newEntityName());
      mainPanel.add(get_newEntityButton());


      owner.mainPanel = mainPanel;

      return mainPanel;
    }

    /**
     * Getter for modelName called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_modelName() {
      return build_modelName();
    }
    private com.google.gwt.user.client.ui.Label build_modelName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label modelName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      modelName.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.modelName = modelName;

      return modelName;
    }

    /**
     * Getter for dataObjectsTable called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.CellTable get_dataObjectsTable() {
      return build_dataObjectsTable();
    }
    private com.github.gwtbootstrap.client.ui.CellTable build_dataObjectsTable() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.CellTable dataObjectsTable = (com.github.gwtbootstrap.client.ui.CellTable) GWT.create(com.github.gwtbootstrap.client.ui.CellTable.class);
      // Setup section.
      dataObjectsTable.setStyleName("table table-bordered table-striped table-hover");
      dataObjectsTable.setCondensed(true);
      dataObjectsTable.setBordered(true);
      dataObjectsTable.setStriped(true);


      owner.dataObjectsTable = dataObjectsTable;

      return dataObjectsTable;
    }

    /**
     * Getter for f_HTML1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_f_HTML1() {
      return build_f_HTML1();
    }
    private com.google.gwt.user.client.ui.HTML build_f_HTML1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML f_HTML1 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      f_HTML1.setHTML(template_html1().asString());


      return f_HTML1;
    }

    /**
     * Getter for newEntityName called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextBox get_newEntityName() {
      return build_newEntityName();
    }
    private com.google.gwt.user.client.ui.TextBox build_newEntityName() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox newEntityName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.


      owner.newEntityName = newEntityName;

      return newEntityName;
    }

    /**
     * Getter for newEntityButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.Button get_newEntityButton() {
      return build_newEntityButton();
    }
    private com.github.gwtbootstrap.client.ui.Button build_newEntityButton() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button newEntityButton = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      newEntityButton.setText("Create");
      newEntityButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.newEntityButton = newEntityButton;

      return newEntityButton;
    }
  }
}
