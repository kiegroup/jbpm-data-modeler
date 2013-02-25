package org.uberfire.client.common;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class HeaderHTML_HeaderHTMLBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.common.HeaderHTML>, org.uberfire.client.common.HeaderHTML.HeaderHTMLBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.common.HeaderHTML owner) {


    return new Widgets(owner).get_f_HorizontalPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.common.HeaderHTML owner;


    public Widgets(final org.uberfire.client.common.HeaderHTML owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.common.HeaderHTML_HeaderHTMLBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.common.HeaderHTML_HeaderHTMLBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.common.HeaderHTML_HeaderHTMLBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.common.HeaderHTML_HeaderHTMLBinderImpl_GenBundle) GWT.create(org.uberfire.client.common.HeaderHTML_HeaderHTMLBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_HorizontalPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel1() {
      return build_f_HorizontalPanel1();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel1.add(get_image());
      f_HorizontalPanel1.add(get_textLabel());


      return f_HorizontalPanel1;
    }

    /**
     * Getter for image called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Image get_image() {
      return build_image();
    }
    private com.google.gwt.user.client.ui.Image build_image() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image image = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.


      owner.image = image;

      return image;
    }

    /**
     * Getter for textLabel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_textLabel() {
      return build_textLabel();
    }
    private com.google.gwt.user.client.ui.Label build_textLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label textLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.textLabel = textLabel;

      return textLabel;
    }
  }
}
