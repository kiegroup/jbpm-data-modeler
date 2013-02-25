package org.jboss.errai.ioc.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BootstrapperImpl_org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource_default_InlineClientBundleGenerator implements org.jboss.errai.ioc.client.BootstrapperImpl.org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource {
  private static BootstrapperImpl_org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource_default_InlineClientBundleGenerator _instance0 = new BootstrapperImpl_org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource_default_InlineClientBundleGenerator();
  private void getContentsInitializer() {
    getContents = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/wmedvede/.m2/repository/org/jbpm/jbpm-data-modeler-editor-client/6.0.0-SNAPSHOT/jbpm-data-modeler-editor-client-6.0.0-SNAPSHOT.jar!/org/jbpm/datamodeler/editor/client/editors/PropertyEditor.html
      public String getText() {
        return "<div data-field=\"template\">\n\n    <label data-field=\"dataObjectPropertiesLabel\"></label>\n\n\n    <table>\n        <tr><td>Name:</td></tr>\n        <tr><td><input type=\"text\" data-field=\"name\"></td></tr>\n        <tr><td>Documentation:</td></tr>\n        <tr><td><input type=\"text\" data-field=\"documentation\"></td></tr>\n    </table>\n\n    <p></p>\n    <div data-field=\"button\">DivButton</div>\n\n</div>\n";
      }
      public String getName() {
        return "getContents";
      }
    }
    ;
  }
  private static class getContentsInitializer {
    static {
      _instance0.getContentsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return getContents;
    }
  }
  public com.google.gwt.resources.client.TextResource getContents() {
    return getContentsInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource getContents;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      getContents(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("getContents", getContents());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'getContents': return this.@org.jboss.errai.ioc.client.BootstrapperImpl.org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource::getContents()();
    }
    return null;
  }-*/;
}
