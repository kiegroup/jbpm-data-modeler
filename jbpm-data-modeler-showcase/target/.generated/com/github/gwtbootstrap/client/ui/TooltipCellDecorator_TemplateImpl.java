package com.github.gwtbootstrap.client.ui;

public class TooltipCellDecorator_TemplateImpl implements com.github.gwtbootstrap.client.ui.TooltipCellDecorator.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml span(java.lang.String arg0,com.google.gwt.safehtml.shared.SafeHtml arg1) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<span class='gb-tooltip-cell' id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'>");
    sb.append(arg1.asString());
    sb.append("</span>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
