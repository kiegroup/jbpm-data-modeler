package org.uberfire.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CoreResources_default_InlineClientBundleGenerator implements org.uberfire.client.resources.CoreResources {
  private static CoreResources_default_InlineClientBundleGenerator _instance0 = new CoreResources_default_InlineClientBundleGenerator();
  private void CSSInitializer() {
    CSS = new org.uberfire.client.resources.CoreCss() {
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
        return ("");
      }
    }
    ;
  }
  private static class CSSInitializer {
    static {
      _instance0.CSSInitializer();
    }
    static org.uberfire.client.resources.CoreCss get() {
      return CSS;
    }
  }
  public org.uberfire.client.resources.CoreCss CSS() {
    return CSSInitializer.get();
  }
  private void imagesInitializer() {
    images = com.google.gwt.core.client.GWT.create(org.uberfire.client.resources.CoreImages.class);
  }
  private static class imagesInitializer {
    static {
      _instance0.imagesInitializer();
    }
    static org.uberfire.client.resources.CoreImages get() {
      return images;
    }
  }
  public org.uberfire.client.resources.CoreImages images() {
    return imagesInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.resources.CoreCss CSS;
  private static org.uberfire.client.resources.CoreImages images;
  
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
      case 'CSS': return this.@org.uberfire.client.resources.CoreResources::CSS()();
    }
    return null;
  }-*/;
}
