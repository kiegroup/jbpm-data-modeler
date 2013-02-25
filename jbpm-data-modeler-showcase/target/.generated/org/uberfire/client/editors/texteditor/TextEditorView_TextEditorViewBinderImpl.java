package org.uberfire.client.editors.texteditor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;

public class TextEditorView_TextEditorViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.ResizeLayoutPanel, org.uberfire.client.editors.texteditor.TextEditorView>, org.uberfire.client.editors.texteditor.TextEditorView.TextEditorViewBinder {


  public com.google.gwt.user.client.ui.ResizeLayoutPanel createAndBindUi(final org.uberfire.client.editors.texteditor.TextEditorView owner) {


    return new Widgets(owner).get_f_ResizeLayoutPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.editors.texteditor.TextEditorView owner;


    public Widgets(final org.uberfire.client.editors.texteditor.TextEditorView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 1 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenCss_style build_style() {
      // Creation section.
      final org.uberfire.client.editors.texteditor.TextEditorView_TextEditorViewBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
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
      f_ResizeLayoutPanel1.add(get_fileContent());


      return f_ResizeLayoutPanel1;
    }

    /**
     * Getter for fileContent called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.uberfire.client.common.ResizableTextArea get_fileContent() {
      return build_fileContent();
    }
    private org.uberfire.client.common.ResizableTextArea build_fileContent() {
      // Creation section.
      final org.uberfire.client.common.ResizableTextArea fileContent = (org.uberfire.client.common.ResizableTextArea) GWT.create(org.uberfire.client.common.ResizableTextArea.class);
      // Setup section.
      fileContent.setStyleName("" + get_style().betterSetup() + "");


      owner.fileContent = fileContent;

      return fileContent;
    }
  }
}
