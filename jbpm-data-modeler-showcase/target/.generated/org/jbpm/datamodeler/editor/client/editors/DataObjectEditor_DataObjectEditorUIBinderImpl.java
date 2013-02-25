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

public class DataObjectEditor_DataObjectEditorUIBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.jbpm.datamodeler.editor.client.editors.DataObjectEditor>, org.jbpm.datamodeler.editor.client.editors.DataObjectEditor.DataObjectEditorUIBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Create new property")
    SafeHtml html1();
     
    @Template("Create")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.jbpm.datamodeler.editor.client.editors.DataObjectEditor owner) {


    return new Widgets(owner).get_mainPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.jbpm.datamodeler.editor.client.editors.DataObjectEditor owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.newPropertyClick(event);
      }
    };

    public Widgets(final org.jbpm.datamodeler.editor.client.editors.DataObjectEditor owner) {
      this.owner = owner;
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.jbpm.datamodeler.editor.client.editors.DataObjectEditor_DataObjectEditorUIBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.jbpm.datamodeler.editor.client.editors.DataObjectEditor_DataObjectEditorUIBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.jbpm.datamodeler.editor.client.editors.DataObjectEditor_DataObjectEditorUIBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.jbpm.datamodeler.editor.client.editors.DataObjectEditor_DataObjectEditorUIBinderImpl_GenBundle) GWT.create(org.jbpm.datamodeler.editor.client.editors.DataObjectEditor_DataObjectEditorUIBinderImpl_GenBundle.class);
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
      mainPanel.add(get_objectName());
      mainPanel.add(get_dataObjectPropertiesTable());
      mainPanel.add(get_f_HTML1());
      mainPanel.add(get_newPropertyName());
      mainPanel.add(get_newPropertyType());
      mainPanel.add(get_newPropertyButton());


      owner.mainPanel = mainPanel;

      return mainPanel;
    }

    /**
     * Getter for objectName called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_objectName() {
      return build_objectName();
    }
    private com.google.gwt.user.client.ui.Label build_objectName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label objectName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.objectName = objectName;

      return objectName;
    }

    /**
     * Getter for dataObjectPropertiesTable called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.CellTable get_dataObjectPropertiesTable() {
      return build_dataObjectPropertiesTable();
    }
    private com.github.gwtbootstrap.client.ui.CellTable build_dataObjectPropertiesTable() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.CellTable dataObjectPropertiesTable = (com.github.gwtbootstrap.client.ui.CellTable) GWT.create(com.github.gwtbootstrap.client.ui.CellTable.class);
      // Setup section.
      dataObjectPropertiesTable.setStyleName("table table-bordered table-striped table-hover");
      dataObjectPropertiesTable.setCondensed(true);
      dataObjectPropertiesTable.setBordered(true);
      dataObjectPropertiesTable.setWidth("100%");
      dataObjectPropertiesTable.setStriped(true);


      owner.dataObjectPropertiesTable = dataObjectPropertiesTable;

      return dataObjectPropertiesTable;
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
     * Getter for newPropertyName called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextBox get_newPropertyName() {
      return build_newPropertyName();
    }
    private com.google.gwt.user.client.ui.TextBox build_newPropertyName() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox newPropertyName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.


      owner.newPropertyName = newPropertyName;

      return newPropertyName;
    }

    /**
     * Getter for newPropertyType called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.ListBox get_newPropertyType() {
      return build_newPropertyType();
    }
    private com.github.gwtbootstrap.client.ui.ListBox build_newPropertyType() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ListBox newPropertyType = (com.github.gwtbootstrap.client.ui.ListBox) GWT.create(com.github.gwtbootstrap.client.ui.ListBox.class);
      // Setup section.


      owner.newPropertyType = newPropertyType;

      return newPropertyType;
    }

    /**
     * Getter for newPropertyButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_newPropertyButton() {
      return build_newPropertyButton();
    }
    private com.google.gwt.user.client.ui.Button build_newPropertyButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button newPropertyButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      newPropertyButton.setHTML(template_html2().asString());
      newPropertyButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.newPropertyButton = newPropertyButton;

      return newPropertyButton;
    }
  }
}
