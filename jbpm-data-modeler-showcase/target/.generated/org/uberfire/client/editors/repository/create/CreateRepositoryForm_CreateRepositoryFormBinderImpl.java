package org.uberfire.client.editors.repository.create;

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

public class CreateRepositoryForm_CreateRepositoryFormBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.editors.repository.create.CreateRepositoryForm>, org.uberfire.client.editors.repository.create.CreateRepositoryForm.CreateRepositoryFormBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Repository Infomation <small>* is required</small>")
    SafeHtml html1();
     
    @Template("<font color='red'>*</font> Repository Name")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("User Name")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("Password")
    SafeHtml html8();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html9(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.editors.repository.create.CreateRepositoryForm owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.editors.repository.create.CreateRepositoryForm owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCreateClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancelClick(event);
      }
    };

    public Widgets(final org.uberfire.client.editors.repository.create.CreateRepositoryForm owner) {
      this.owner = owner;
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId3(), get_domId4());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId1(), get_domId2());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId7());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId5(), get_domId6());
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9(get_domId10());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId8(), get_domId9());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.editors.repository.create.CreateRepositoryForm_CreateRepositoryFormBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.editors.repository.create.CreateRepositoryForm_CreateRepositoryFormBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.editors.repository.create.CreateRepositoryForm_CreateRepositoryFormBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.editors.repository.create.CreateRepositoryForm_CreateRepositoryFormBinderImpl_GenBundle) GWT.create(org.uberfire.client.editors.repository.create.CreateRepositoryForm_CreateRepositoryFormBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord0.detach();
      f_HTMLPanel1.addAndReplaceElement(get_popup(), get_domId0Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for popup called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.Modal get_popup() {
      return build_popup();
    }
    private com.github.gwtbootstrap.client.ui.Modal build_popup() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Modal popup = (com.github.gwtbootstrap.client.ui.Modal) GWT.create(com.github.gwtbootstrap.client.ui.Modal.class);
      // Setup section.
      popup.add(get_f_WellForm2());
      popup.add(get_f_ModalFooter13());
      popup.setKeyboard(true);
      popup.setTitle("Create Repository");
      popup.setAnimation(true);
      popup.setBackdrop(com.github.gwtbootstrap.client.ui.constants.BackdropType.STATIC);


      owner.popup = popup;

      return popup;
    }

    /**
     * Getter for f_WellForm2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.github.gwtbootstrap.client.ui.WellForm get_f_WellForm2() {
      return build_f_WellForm2();
    }
    private com.github.gwtbootstrap.client.ui.WellForm build_f_WellForm2() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.WellForm f_WellForm2 = (com.github.gwtbootstrap.client.ui.WellForm) GWT.create(com.github.gwtbootstrap.client.ui.WellForm.class);
      // Setup section.
      f_WellForm2.add(get_f_Fieldset3());
      f_WellForm2.setType(com.github.gwtbootstrap.client.ui.constants.FormType.HORIZONTAL);


      return f_WellForm2;
    }

    /**
     * Getter for f_Fieldset3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.github.gwtbootstrap.client.ui.Fieldset get_f_Fieldset3() {
      return build_f_Fieldset3();
    }
    private com.github.gwtbootstrap.client.ui.Fieldset build_f_Fieldset3() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Fieldset f_Fieldset3 = (com.github.gwtbootstrap.client.ui.Fieldset) GWT.create(com.github.gwtbootstrap.client.ui.Fieldset.class);
      // Setup section.
      f_Fieldset3.add(get_f_Legend4());
      f_Fieldset3.add(get_nameGroup());
      f_Fieldset3.add(get_f_ControlGroup7());
      f_Fieldset3.add(get_f_ControlGroup10());


      return f_Fieldset3;
    }

    /**
     * Getter for f_Legend4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.Legend get_f_Legend4() {
      return build_f_Legend4();
    }
    private com.github.gwtbootstrap.client.ui.Legend build_f_Legend4() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Legend f_Legend4 = new com.github.gwtbootstrap.client.ui.Legend(template_html1().asString());
      // Setup section.


      return f_Legend4;
    }

    /**
     * Getter for nameGroup called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.ControlGroup get_nameGroup() {
      return build_nameGroup();
    }
    private com.github.gwtbootstrap.client.ui.ControlGroup build_nameGroup() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ControlGroup nameGroup = new com.github.gwtbootstrap.client.ui.ControlGroup(template_html4().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(nameGroup.getElement());
      get_domId1Element().get();
      get_domId2Element().get();

      // Detach section.
      attachRecord1.detach();
      nameGroup.addAndReplaceElement(get_f_ControlLabel5(), get_domId1Element().get());
      nameGroup.addAndReplaceElement(get_f_Controls6(), get_domId2Element().get());

      owner.nameGroup = nameGroup;

      return nameGroup;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for f_ControlLabel5 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.ControlLabel get_f_ControlLabel5() {
      return build_f_ControlLabel5();
    }
    private com.github.gwtbootstrap.client.ui.ControlLabel build_f_ControlLabel5() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ControlLabel f_ControlLabel5 = new com.github.gwtbootstrap.client.ui.ControlLabel(template_html2().asString());
      // Setup section.
      f_ControlLabel5.setFor("name");


      return f_ControlLabel5;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for f_Controls6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.Controls get_f_Controls6() {
      return build_f_Controls6();
    }
    private com.github.gwtbootstrap.client.ui.Controls build_f_Controls6() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Controls f_Controls6 = new com.github.gwtbootstrap.client.ui.Controls(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_Controls6.getElement());
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord2.detach();
      f_Controls6.addAndReplaceElement(get_nameTextBox(), get_domId3Element().get());
      f_Controls6.addAndReplaceElement(get_nameHelpInline(), get_domId4Element().get());

      return f_Controls6;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for nameTextBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.github.gwtbootstrap.client.ui.TextBox get_nameTextBox() {
      return build_nameTextBox();
    }
    private com.github.gwtbootstrap.client.ui.TextBox build_nameTextBox() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.TextBox nameTextBox = (com.github.gwtbootstrap.client.ui.TextBox) GWT.create(com.github.gwtbootstrap.client.ui.TextBox.class);
      // Setup section.
      nameTextBox.setId("name");
      nameTextBox.setPlaceholder("repository name...");


      owner.nameTextBox = nameTextBox;

      return nameTextBox;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for nameHelpInline called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.github.gwtbootstrap.client.ui.HelpInline get_nameHelpInline() {
      return build_nameHelpInline();
    }
    private com.github.gwtbootstrap.client.ui.HelpInline build_nameHelpInline() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.HelpInline nameHelpInline = (com.github.gwtbootstrap.client.ui.HelpInline) GWT.create(com.github.gwtbootstrap.client.ui.HelpInline.class);
      // Setup section.


      owner.nameHelpInline = nameHelpInline;

      return nameHelpInline;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for f_ControlGroup7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.ControlGroup get_f_ControlGroup7() {
      return build_f_ControlGroup7();
    }
    private com.github.gwtbootstrap.client.ui.ControlGroup build_f_ControlGroup7() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ControlGroup f_ControlGroup7 = new com.github.gwtbootstrap.client.ui.ControlGroup(template_html7().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(f_ControlGroup7.getElement());
      get_domId5Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord3.detach();
      f_ControlGroup7.addAndReplaceElement(get_f_ControlLabel8(), get_domId5Element().get());
      f_ControlGroup7.addAndReplaceElement(get_f_Controls9(), get_domId6Element().get());

      return f_ControlGroup7;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId5;
    }

    /**
     * Getter for f_ControlLabel8 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.ControlLabel get_f_ControlLabel8() {
      return build_f_ControlLabel8();
    }
    private com.github.gwtbootstrap.client.ui.ControlLabel build_f_ControlLabel8() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ControlLabel f_ControlLabel8 = new com.github.gwtbootstrap.client.ui.ControlLabel(template_html5().asString());
      // Setup section.


      return f_ControlLabel8;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.


      return domId5Element;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId6;
    }

    /**
     * Getter for f_Controls9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.Controls get_f_Controls9() {
      return build_f_Controls9();
    }
    private com.github.gwtbootstrap.client.ui.Controls build_f_Controls9() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Controls f_Controls9 = new com.github.gwtbootstrap.client.ui.Controls(template_html6().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4 = UiBinderUtil.attachToDom(f_Controls9.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord4.detach();
      f_Controls9.addAndReplaceElement(get_usernameTextBox(), get_domId7Element().get());

      return f_Controls9;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId7;
    private java.lang.String get_domId7() {
      return domId7;
    }
    private java.lang.String build_domId7() {
      // Creation section.
      domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId7;
    }

    /**
     * Getter for usernameTextBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.github.gwtbootstrap.client.ui.TextBox get_usernameTextBox() {
      return build_usernameTextBox();
    }
    private com.github.gwtbootstrap.client.ui.TextBox build_usernameTextBox() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.TextBox usernameTextBox = (com.github.gwtbootstrap.client.ui.TextBox) GWT.create(com.github.gwtbootstrap.client.ui.TextBox.class);
      // Setup section.
      usernameTextBox.setPlaceholder("user name...");


      owner.usernameTextBox = usernameTextBox;

      return usernameTextBox;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId7Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId7Element() {
      return domId7Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId7Element() {
      // Creation section.
      domId7Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId7());
      // Setup section.


      return domId7Element;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.


      return domId6Element;
    }

    /**
     * Getter for f_ControlGroup10 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.ControlGroup get_f_ControlGroup10() {
      return build_f_ControlGroup10();
    }
    private com.github.gwtbootstrap.client.ui.ControlGroup build_f_ControlGroup10() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ControlGroup f_ControlGroup10 = new com.github.gwtbootstrap.client.ui.ControlGroup(template_html10().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord5 = UiBinderUtil.attachToDom(f_ControlGroup10.getElement());
      get_domId8Element().get();
      get_domId9Element().get();

      // Detach section.
      attachRecord5.detach();
      f_ControlGroup10.addAndReplaceElement(get_f_ControlLabel11(), get_domId8Element().get());
      f_ControlGroup10.addAndReplaceElement(get_f_Controls12(), get_domId9Element().get());

      return f_ControlGroup10;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId8;
    private java.lang.String get_domId8() {
      return domId8;
    }
    private java.lang.String build_domId8() {
      // Creation section.
      domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId8;
    }

    /**
     * Getter for f_ControlLabel11 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.ControlLabel get_f_ControlLabel11() {
      return build_f_ControlLabel11();
    }
    private com.github.gwtbootstrap.client.ui.ControlLabel build_f_ControlLabel11() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ControlLabel f_ControlLabel11 = new com.github.gwtbootstrap.client.ui.ControlLabel(template_html8().asString());
      // Setup section.


      return f_ControlLabel11;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId8Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId8Element() {
      return domId8Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId8Element() {
      // Creation section.
      domId8Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId8());
      // Setup section.


      return domId8Element;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId9;
    private java.lang.String get_domId9() {
      return domId9;
    }
    private java.lang.String build_domId9() {
      // Creation section.
      domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId9;
    }

    /**
     * Getter for f_Controls12 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.Controls get_f_Controls12() {
      return build_f_Controls12();
    }
    private com.github.gwtbootstrap.client.ui.Controls build_f_Controls12() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Controls f_Controls12 = new com.github.gwtbootstrap.client.ui.Controls(template_html9().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord6 = UiBinderUtil.attachToDom(f_Controls12.getElement());
      get_domId10Element().get();

      // Detach section.
      attachRecord6.detach();
      f_Controls12.addAndReplaceElement(get_passwordTextBox(), get_domId10Element().get());

      return f_Controls12;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId10;
    private java.lang.String get_domId10() {
      return domId10;
    }
    private java.lang.String build_domId10() {
      // Creation section.
      domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId10;
    }

    /**
     * Getter for passwordTextBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.github.gwtbootstrap.client.ui.PasswordTextBox get_passwordTextBox() {
      return build_passwordTextBox();
    }
    private com.github.gwtbootstrap.client.ui.PasswordTextBox build_passwordTextBox() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.PasswordTextBox passwordTextBox = (com.github.gwtbootstrap.client.ui.PasswordTextBox) GWT.create(com.github.gwtbootstrap.client.ui.PasswordTextBox.class);
      // Setup section.
      passwordTextBox.setPlaceholder("password...");


      owner.passwordTextBox = passwordTextBox;

      return passwordTextBox;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId10Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId10Element() {
      return domId10Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId10Element() {
      // Creation section.
      domId10Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId10());
      // Setup section.


      return domId10Element;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId9Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId9Element() {
      return domId9Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId9Element() {
      // Creation section.
      domId9Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId9());
      // Setup section.


      return domId9Element;
    }

    /**
     * Getter for f_ModalFooter13 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.github.gwtbootstrap.client.ui.ModalFooter get_f_ModalFooter13() {
      return build_f_ModalFooter13();
    }
    private com.github.gwtbootstrap.client.ui.ModalFooter build_f_ModalFooter13() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ModalFooter f_ModalFooter13 = (com.github.gwtbootstrap.client.ui.ModalFooter) GWT.create(com.github.gwtbootstrap.client.ui.ModalFooter.class);
      // Setup section.
      f_ModalFooter13.add(get_cancel());
      f_ModalFooter13.add(get_create());


      return f_ModalFooter13;
    }

    /**
     * Getter for cancel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.github.gwtbootstrap.client.ui.Button get_cancel() {
      return build_cancel();
    }
    private com.github.gwtbootstrap.client.ui.Button build_cancel() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button cancel = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      cancel.setText("Cancel");
      cancel.setType(com.github.gwtbootstrap.client.ui.constants.ButtonType.DEFAULT);
      cancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      return cancel;
    }

    /**
     * Getter for create called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.github.gwtbootstrap.client.ui.Button get_create() {
      return build_create();
    }
    private com.github.gwtbootstrap.client.ui.Button build_create() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button create = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      create.setText("Create");
      create.setIcon(com.github.gwtbootstrap.client.ui.constants.IconType.FOLDER_CLOSE_ALT);
      create.setType(com.github.gwtbootstrap.client.ui.constants.ButtonType.PRIMARY);
      create.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      return create;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }
  }
}
