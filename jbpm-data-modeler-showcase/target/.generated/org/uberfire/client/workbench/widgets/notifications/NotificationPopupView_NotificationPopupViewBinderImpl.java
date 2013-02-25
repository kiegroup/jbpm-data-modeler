package org.uberfire.client.workbench.widgets.notifications;

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
import com.google.gwt.user.client.ui.Panel;

public class NotificationPopupView_NotificationPopupViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Panel, org.uberfire.client.workbench.widgets.notifications.NotificationPopupView>, org.uberfire.client.workbench.widgets.notifications.NotificationPopupView.NotificationPopupViewBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Panel createAndBindUi(final org.uberfire.client.workbench.widgets.notifications.NotificationPopupView owner) {


    return new Widgets(owner).get_notification();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.workbench.widgets.notifications.NotificationPopupView owner;


    public Widgets(final org.uberfire.client.workbench.widgets.notifications.NotificationPopupView owner) {
      this.owner = owner;
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.notifications.NotificationPopupView_NotificationPopupViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.workbench.widgets.notifications.NotificationPopupView_NotificationPopupViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.workbench.widgets.notifications.NotificationPopupView_NotificationPopupViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.workbench.widgets.notifications.NotificationPopupView_NotificationPopupViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.workbench.widgets.notifications.NotificationPopupView_NotificationPopupViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for notification called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.github.gwtbootstrap.client.ui.Alert get_notification() {
      return build_notification();
    }
    private com.github.gwtbootstrap.client.ui.Alert build_notification() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Alert notification = new com.github.gwtbootstrap.client.ui.Alert(template_html1().asString());
      // Setup section.


      owner.notification = notification;

      return notification;
    }
  }
}
