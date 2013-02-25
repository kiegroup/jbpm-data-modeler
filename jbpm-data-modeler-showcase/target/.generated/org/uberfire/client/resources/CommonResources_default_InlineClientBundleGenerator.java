package org.uberfire.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CommonResources_default_InlineClientBundleGenerator implements org.uberfire.client.resources.CommonResources {
  private static CommonResources_default_InlineClientBundleGenerator _instance0 = new CommonResources_default_InlineClientBundleGenerator();
  private void CSSInitializer() {
    CSS = new org.uberfire.client.resources.CommonCss() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GHMFQ3OCQ{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3ODQ{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getTop() + "px  no-repeat")  + ";height:") + (("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OMP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3ONP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden") ) + (";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OLP{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:" + ("3px")  + ";width:" + ("100%")  + ";}.GHMFQ3OBQ{border-top:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:" + ("3px")  + ";width:" + ("100%")  + ";}.GHMFQ3OPP{border-right:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:") + (("100%")  + ";width:" + ("3px")  + ";}.GHMFQ3OAQ{border-left:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:" + ("100%")  + ";width:" + ("3px")  + ";}.GHMFQ3OJP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px") ) + (";}.GHMFQ3OKP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3ODP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getTop() + "px  no-repeat")  + ";height:") + (("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OEP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OCP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getTop() + "px  repeat-x") ) + (";height:" + ("4px")  + ";width:" + ("100%")  + ";}.GHMFQ3OIP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getTop() + "px  repeat-x")  + ";height:" + ("4px")  + ";width:" + ("100%")  + ";}.GHMFQ3OGP{width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getTop() + "px  repeat-y")  + ";height:") + (("100%")  + ";width:" + ("4px")  + ";}.GHMFQ3OHP{width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getTop() + "px  repeat-y")  + ";height:" + ("100%")  + ";width:" + ("4px")  + ";}.GHMFQ3OFP{background:" + ("#e3e3e3")  + ";}.GHMFQ3OBP{border:" + ("none")  + " !important;width:" + ("95%")  + ";}")) : ((".GHMFQ3OCQ{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopLeftCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3ODQ{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteTopRightCorner()).getTop() + "px  no-repeat")  + ";height:") + (("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OMP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomLeftCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3ONP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden") ) + (";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().whiteBottomRightCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OLP{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:" + ("3px")  + ";width:" + ("100%")  + ";}.GHMFQ3OBQ{border-top:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:" + ("3px")  + ";width:" + ("100%")  + ";}.GHMFQ3OPP{border-left:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:") + (("100%")  + ";width:" + ("3px")  + ";}.GHMFQ3OAQ{border-right:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";height:" + ("100%")  + ";width:" + ("3px")  + ";}.GHMFQ3OJP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopLeftCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px") ) + (";}.GHMFQ3OKP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTopRightCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3ODP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomLeftCorner()).getTop() + "px  no-repeat")  + ";height:") + (("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OEP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getHeight() + "px")  + ";width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottomRightCorner()).getTop() + "px  no-repeat")  + ";height:" + ("4px")  + ";width:" + ("4px")  + ";}.GHMFQ3OCP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyBottom()).getTop() + "px  repeat-x") ) + (";height:" + ("4px")  + ";width:" + ("100%")  + ";}.GHMFQ3OIP{height:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greyTop()).getTop() + "px  repeat-x")  + ";height:" + ("4px")  + ";width:" + ("100%")  + ";}.GHMFQ3OGP{width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideLeft()).getTop() + "px  repeat-y")  + ";height:") + (("100%")  + ";width:" + ("4px")  + ";}.GHMFQ3OHP{width:" + ((CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getSafeUri().asString() + "\") -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getLeft() + "px -" + (CommonResources_default_InlineClientBundleGenerator.this.images().greySideRight()).getTop() + "px  repeat-y")  + ";height:" + ("100%")  + ";width:" + ("4px")  + ";}.GHMFQ3OFP{background:" + ("#e3e3e3")  + ";}.GHMFQ3OBP{border:" + ("none")  + " !important;width:" + ("95%")  + ";}"));
      }
      public java.lang.String cleanTextArea(){
        return "GHMFQ3OBP";
      }
      public java.lang.String greyBottomClass(){
        return "GHMFQ3OCP";
      }
      public java.lang.String greyBottomLeftCornerClass(){
        return "GHMFQ3ODP";
      }
      public java.lang.String greyBottomRightCornerClass(){
        return "GHMFQ3OEP";
      }
      public java.lang.String greyCenterClass(){
        return "GHMFQ3OFP";
      }
      public java.lang.String greySideLeftClass(){
        return "GHMFQ3OGP";
      }
      public java.lang.String greySideRightClass(){
        return "GHMFQ3OHP";
      }
      public java.lang.String greyTopClass(){
        return "GHMFQ3OIP";
      }
      public java.lang.String greyTopLeftCornerClass(){
        return "GHMFQ3OJP";
      }
      public java.lang.String greyTopRightCornerClass(){
        return "GHMFQ3OKP";
      }
      public java.lang.String whiteBottomClass(){
        return "GHMFQ3OLP";
      }
      public java.lang.String whiteBottomLeftCornerClass(){
        return "GHMFQ3OMP";
      }
      public java.lang.String whiteBottomRightCornerClass(){
        return "GHMFQ3ONP";
      }
      public java.lang.String whiteCenterClass(){
        return "GHMFQ3OOP";
      }
      public java.lang.String whiteSideLeftClass(){
        return "GHMFQ3OPP";
      }
      public java.lang.String whiteSideRightClass(){
        return "GHMFQ3OAQ";
      }
      public java.lang.String whiteTopClass(){
        return "GHMFQ3OBQ";
      }
      public java.lang.String whiteTopLeftCornerClass(){
        return "GHMFQ3OCQ";
      }
      public java.lang.String whiteTopRightCornerClass(){
        return "GHMFQ3ODQ";
      }
    }
    ;
  }
  private static class CSSInitializer {
    static {
      _instance0.CSSInitializer();
    }
    static org.uberfire.client.resources.CommonCss get() {
      return CSS;
    }
  }
  public org.uberfire.client.resources.CommonCss CSS() {
    return CSSInitializer.get();
  }
  private void imagesInitializer() {
    images = com.google.gwt.core.client.GWT.create(org.uberfire.client.resources.CommonImages.class);
  }
  private static class imagesInitializer {
    static {
      _instance0.imagesInitializer();
    }
    static org.uberfire.client.resources.CommonImages get() {
      return images;
    }
  }
  public org.uberfire.client.resources.CommonImages images() {
    return imagesInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.resources.CommonCss CSS;
  private static org.uberfire.client.resources.CommonImages images;
  
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
      case 'CSS': return this.@org.uberfire.client.resources.CommonResources::CSS()();
    }
    return null;
  }-*/;
}
