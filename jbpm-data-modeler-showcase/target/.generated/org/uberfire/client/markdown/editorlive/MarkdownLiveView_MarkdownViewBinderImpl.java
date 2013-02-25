package org.uberfire.client.markdown.editorlive;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;

public class MarkdownLiveView_MarkdownViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.ResizeLayoutPanel, org.uberfire.client.markdown.editorlive.MarkdownLiveView>, org.uberfire.client.markdown.editorlive.MarkdownLiveView.MarkdownViewBinder {


  public com.google.gwt.user.client.ui.ResizeLayoutPanel createAndBindUi(final org.uberfire.client.markdown.editorlive.MarkdownLiveView owner) {


    return new Widgets(owner).get_f_ResizeLayoutPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.markdown.editorlive.MarkdownLiveView owner;


    public Widgets(final org.uberfire.client.markdown.editorlive.MarkdownLiveView owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.markdown.editorlive.MarkdownLiveView_MarkdownViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.markdown.editorlive.MarkdownLiveView_MarkdownViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.markdown.editorlive.MarkdownLiveView_MarkdownViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.markdown.editorlive.MarkdownLiveView_MarkdownViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.markdown.editorlive.MarkdownLiveView_MarkdownViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_ResizeLayoutPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.ResizeLayoutPanel get_f_ResizeLayoutPanel1() {
      return build_f_ResizeLayoutPanel1();
    }
    private com.google.gwt.user.client.ui.ResizeLayoutPanel build_f_ResizeLayoutPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.ResizeLayoutPanel f_ResizeLayoutPanel1 = (com.google.gwt.user.client.ui.ResizeLayoutPanel) GWT.create(com.google.gwt.user.client.ui.ResizeLayoutPanel.class);
      // Setup section.
      f_ResizeLayoutPanel1.add(get_markdown());


      return f_ResizeLayoutPanel1;
    }

    /**
     * Getter for markdown called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.uberfire.client.markdown.Markdown get_markdown() {
      return build_markdown();
    }
    private org.uberfire.client.markdown.Markdown build_markdown() {
      // Creation section.
      final org.uberfire.client.markdown.Markdown markdown = (org.uberfire.client.markdown.Markdown) GWT.create(org.uberfire.client.markdown.Markdown.class);
      // Setup section.


      owner.markdown = markdown;

      return markdown;
    }
  }
}
