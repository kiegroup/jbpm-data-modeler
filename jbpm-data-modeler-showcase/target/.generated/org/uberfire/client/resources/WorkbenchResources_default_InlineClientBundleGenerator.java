package org.uberfire.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class WorkbenchResources_default_InlineClientBundleGenerator implements org.uberfire.client.resources.WorkbenchResources {
  private static WorkbenchResources_default_InlineClientBundleGenerator _instance0 = new WorkbenchResources_default_InlineClientBundleGenerator();
  private void CSSInitializer() {
    CSS = new org.uberfire.client.resources.WorkbenchCss() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "CSS";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GHMFQ3OHQ{border:" + ("0")  + ";margin:" + ("0")  + ";padding:" + ("0")  + ";}.GHMFQ3OKQ{min-height:" + ("30px")  + ";margin-top:" + ("0")  + ";margin-bottom:" + ("5px")  + ";padding:" + ("5px"+ " " +"19px")  + ";background-color:" + ("#f5f5f5")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#e3e3e3")  + ";-webkit-border-radius:" + ("4px")  + ";-moz-border-radius:") + (("4px")  + ";border-radius:" + ("4px")  + ";-webkit-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";-moz-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";}.GHMFQ3OGQ{z-index:" + ("100000")  + ";background-color:" + ("#a0a0e0")  + ";opacity:" + ("0.5")  + ";}.GHMFQ3OFQ{z-index:" + ("200000")  + ";border-style:" + ("none")  + ";line-height:" + ("0") ) + (";}.GHMFQ3OIQ{cursor:" + ("default")  + ";height:" + ("36px")  + ";width:" + ("100%")  + ";border-spacing:" + ("0")  + ";background:" + ("#c0c0c0")  + ";padding-top:" + ("0")  + ";padding-bottom:" + ("0")  + ";padding-right:" + ("2px")  + ";padding-left:" + ("2px")  + ";}.GHMFQ3OEQ{border-color:" + ("rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.8" + ")")  + ";box-shadow:") + (("0"+ " " +"0"+ " " +"8px"+ " " +"rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.6" + ")")  + ";}.GHMFQ3OJQ{float:" + ("none")  + ";margin:" + ("-2px"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";}")) : ((".GHMFQ3OHQ{border:" + ("0")  + ";margin:" + ("0")  + ";padding:" + ("0")  + ";}.GHMFQ3OKQ{min-height:" + ("30px")  + ";margin-top:" + ("0")  + ";margin-bottom:" + ("5px")  + ";padding:" + ("5px"+ " " +"19px")  + ";background-color:" + ("#f5f5f5")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#e3e3e3")  + ";-webkit-border-radius:" + ("4px")  + ";-moz-border-radius:") + (("4px")  + ";border-radius:" + ("4px")  + ";-webkit-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";-moz-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";}.GHMFQ3OGQ{z-index:" + ("100000")  + ";background-color:" + ("#a0a0e0")  + ";opacity:" + ("0.5")  + ";}.GHMFQ3OFQ{z-index:" + ("200000")  + ";border-style:" + ("none")  + ";line-height:" + ("0") ) + (";}.GHMFQ3OIQ{cursor:" + ("default")  + ";height:" + ("36px")  + ";width:" + ("100%")  + ";border-spacing:" + ("0")  + ";background:" + ("#c0c0c0")  + ";padding-top:" + ("0")  + ";padding-bottom:" + ("0")  + ";padding-left:" + ("2px")  + ";padding-right:" + ("2px")  + ";}.GHMFQ3OEQ{border-color:" + ("rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.8" + ")")  + ";box-shadow:") + (("0"+ " " +"0"+ " " +"8px"+ " " +"rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.6" + ")")  + ";}.GHMFQ3OJQ{float:" + ("none")  + ";margin:" + ("-2px"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";}"));
      }
      public java.lang.String activeNavTabs(){
        return "GHMFQ3OEQ";
      }
      public java.lang.String dropTargetCompass(){
        return "GHMFQ3OFQ";
      }
      public java.lang.String dropTargetHighlight(){
        return "GHMFQ3OGQ";
      }
      public java.lang.String notification(){
        return "GHMFQ3OHQ";
      }
      public java.lang.String statusBar(){
        return "GHMFQ3OIQ";
      }
      public java.lang.String tabCloseButton(){
        return "GHMFQ3OJQ";
      }
      public java.lang.String toolbar(){
        return "GHMFQ3OKQ";
      }
    }
    ;
  }
  private static class CSSInitializer {
    static {
      _instance0.CSSInitializer();
    }
    static org.uberfire.client.resources.WorkbenchCss get() {
      return CSS;
    }
  }
  public org.uberfire.client.resources.WorkbenchCss CSS() {
    return CSSInitializer.get();
  }
  private void imagesInitializer() {
    images = com.google.gwt.core.client.GWT.create(org.uberfire.client.resources.WorkbenchImages.class);
  }
  private static class imagesInitializer {
    static {
      _instance0.imagesInitializer();
    }
    static org.uberfire.client.resources.WorkbenchImages get() {
      return images;
    }
  }
  public org.uberfire.client.resources.WorkbenchImages images() {
    return imagesInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.resources.WorkbenchCss CSS;
  private static org.uberfire.client.resources.WorkbenchImages images;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      CSS(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("CSS", CSS());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'CSS': return this.@org.uberfire.client.resources.WorkbenchResources::CSS()();
    }
    return null;
  }-*/;
}
