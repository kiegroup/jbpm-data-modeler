package org.uberfire.client.workbench.widgets.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Panel;

public class WorkbenchMenuBarView_WorkbenchMenuBarViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Panel, org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView>, org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView.WorkbenchMenuBarViewBinder {


  public com.google.gwt.user.client.ui.Panel createAndBindUi(final org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView owner) {


    return new Widgets(owner).get_f_ResponsiveNavbar1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView owner;


    public Widgets(final org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView_WorkbenchMenuBarViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView_WorkbenchMenuBarViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView_WorkbenchMenuBarViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView_WorkbenchMenuBarViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView_WorkbenchMenuBarViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_ResponsiveNavbar1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.github.gwtbootstrap.client.ui.ResponsiveNavbar get_f_ResponsiveNavbar1() {
      return build_f_ResponsiveNavbar1();
    }
    private com.github.gwtbootstrap.client.ui.ResponsiveNavbar build_f_ResponsiveNavbar1() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ResponsiveNavbar f_ResponsiveNavbar1 = (com.github.gwtbootstrap.client.ui.ResponsiveNavbar) GWT.create(com.github.gwtbootstrap.client.ui.ResponsiveNavbar.class);
      // Setup section.
      f_ResponsiveNavbar1.add(get_brand());
      f_ResponsiveNavbar1.add(get_f_NavCollapse2());
      f_ResponsiveNavbar1.setPosition(com.github.gwtbootstrap.client.ui.constants.NavbarPosition.TOP);
      f_ResponsiveNavbar1.setInverse(true);


      return f_ResponsiveNavbar1;
    }

    /**
     * Getter for brand called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.Brand get_brand() {
      return build_brand();
    }
    private com.github.gwtbootstrap.client.ui.Brand build_brand() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Brand brand = (com.github.gwtbootstrap.client.ui.Brand) GWT.create(com.github.gwtbootstrap.client.ui.Brand.class);
      // Setup section.


      owner.brand = brand;

      return brand;
    }

    /**
     * Getter for f_NavCollapse2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.NavCollapse get_f_NavCollapse2() {
      return build_f_NavCollapse2();
    }
    private com.github.gwtbootstrap.client.ui.NavCollapse build_f_NavCollapse2() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.NavCollapse f_NavCollapse2 = (com.github.gwtbootstrap.client.ui.NavCollapse) GWT.create(com.github.gwtbootstrap.client.ui.NavCollapse.class);
      // Setup section.
      f_NavCollapse2.add(get_menuBarLeft());
      f_NavCollapse2.add(get_menuBarCenter());
      f_NavCollapse2.add(get_menuBarRight());


      return f_NavCollapse2;
    }

    /**
     * Getter for menuBarLeft called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.github.gwtbootstrap.client.ui.Nav get_menuBarLeft() {
      return build_menuBarLeft();
    }
    private com.github.gwtbootstrap.client.ui.Nav build_menuBarLeft() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Nav menuBarLeft = (com.github.gwtbootstrap.client.ui.Nav) GWT.create(com.github.gwtbootstrap.client.ui.Nav.class);
      // Setup section.
      menuBarLeft.setAlignment(com.github.gwtbootstrap.client.ui.constants.Alignment.LEFT);


      owner.menuBarLeft = menuBarLeft;

      return menuBarLeft;
    }

    /**
     * Getter for menuBarCenter called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.github.gwtbootstrap.client.ui.Nav get_menuBarCenter() {
      return build_menuBarCenter();
    }
    private com.github.gwtbootstrap.client.ui.Nav build_menuBarCenter() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Nav menuBarCenter = (com.github.gwtbootstrap.client.ui.Nav) GWT.create(com.github.gwtbootstrap.client.ui.Nav.class);
      // Setup section.


      owner.menuBarCenter = menuBarCenter;

      return menuBarCenter;
    }

    /**
     * Getter for menuBarRight called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.github.gwtbootstrap.client.ui.Nav get_menuBarRight() {
      return build_menuBarRight();
    }
    private com.github.gwtbootstrap.client.ui.Nav build_menuBarRight() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Nav menuBarRight = (com.github.gwtbootstrap.client.ui.Nav) GWT.create(com.github.gwtbootstrap.client.ui.Nav.class);
      // Setup section.
      menuBarRight.setAlignment(com.github.gwtbootstrap.client.ui.constants.Alignment.RIGHT);


      owner.menuBarRight = menuBarRight;

      return menuBarRight;
    }
  }
}
