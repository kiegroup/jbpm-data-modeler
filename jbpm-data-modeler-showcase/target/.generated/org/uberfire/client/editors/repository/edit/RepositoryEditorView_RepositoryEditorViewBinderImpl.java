package org.uberfire.client.editors.repository.edit;

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

public class RepositoryEditorView_RepositoryEditorViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.editors.repository.edit.RepositoryEditorView>, org.uberfire.client.editors.repository.edit.RepositoryEditorView.RepositoryEditorViewBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.editors.repository.edit.RepositoryEditorView owner) {


    return new Widgets(owner).get_panel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.editors.repository.edit.RepositoryEditorView owner;


    public Widgets(final org.uberfire.client.editors.repository.edit.RepositoryEditorView owner) {
      this.owner = owner;
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.editors.repository.edit.RepositoryEditorView_RepositoryEditorViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.editors.repository.edit.RepositoryEditorView_RepositoryEditorViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.editors.repository.edit.RepositoryEditorView_RepositoryEditorViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.editors.repository.edit.RepositoryEditorView_RepositoryEditorViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.editors.repository.edit.RepositoryEditorView_RepositoryEditorViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for panel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panel() {
      return build_panel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.


      owner.panel = panel;

      return panel;
    }
  }
}
