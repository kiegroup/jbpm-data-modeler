<%
  final String queryString = request.getQueryString();
  final String redirectURL = "org.jbpm.datamodeler.DatamodelerShowcase/Datamodeler.html" + (queryString == null ? "" : "?" + queryString);
  response.sendRedirect(redirectURL);
%>
