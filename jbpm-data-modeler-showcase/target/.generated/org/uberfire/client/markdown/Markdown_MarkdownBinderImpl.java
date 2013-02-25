package org.uberfire.client.markdown;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class Markdown_MarkdownBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.markdown.Markdown>, org.uberfire.client.markdown.Markdown.MarkdownBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.markdown.Markdown owner) {


    return new Widgets(owner).get_htmlContent();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.markdown.Markdown owner;


    public Widgets(final org.uberfire.client.markdown.Markdown owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.markdown.Markdown_MarkdownBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.markdown.Markdown_MarkdownBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.markdown.Markdown_MarkdownBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.markdown.Markdown_MarkdownBinderImpl_GenBundle) GWT.create(org.uberfire.client.markdown.Markdown_MarkdownBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for htmlContent called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlContent() {
      return build_htmlContent();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlContent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlContent = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.


      owner.htmlContent = htmlContent;

      return htmlContent;
    }
  }
}
