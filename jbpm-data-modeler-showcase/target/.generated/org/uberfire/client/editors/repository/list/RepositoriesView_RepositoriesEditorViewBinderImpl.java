package org.uberfire.client.editors.repository.list;

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

public class RepositoriesView_RepositoriesEditorViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.editors.repository.list.RepositoriesView>, org.uberfire.client.editors.repository.list.RepositoriesView.RepositoriesEditorViewBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<p></p> <p></p>")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.editors.repository.list.RepositoriesView owner) {


    return new Widgets(owner).get_f_VerticalPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.editors.repository.list.RepositoriesView owner;


    public Widgets(final org.uberfire.client.editors.repository.list.RepositoriesView owner) {
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
    private org.uberfire.client.editors.repository.list.RepositoriesView_RepositoriesEditorViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.editors.repository.list.RepositoriesView_RepositoriesEditorViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.editors.repository.list.RepositoriesView_RepositoriesEditorViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.editors.repository.list.RepositoriesView_RepositoriesEditorViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.editors.repository.list.RepositoriesView_RepositoriesEditorViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_VerticalPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_f_VerticalPanel1() {
      return build_f_VerticalPanel1();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_f_VerticalPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      f_VerticalPanel1.add(get_f_HTMLPanel2());
      f_VerticalPanel1.add(get_panel());


      return f_VerticalPanel1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.


      return f_HTMLPanel2;
    }

    /**
     * Getter for panel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panel() {
      return build_panel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panel = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.


      owner.panel = panel;

      return panel;
    }
  }
}
