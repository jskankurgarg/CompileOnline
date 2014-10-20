This is encode url page
<%@ page session="false" %>
<%
	HttpSession session=request.getSession();
	out.println("<a href=\""+response.encodeURL("index.html")+"\"> click to see index.html </a>");
	out.println("<br>"+response.encodeRedirectURL("/index.html")+"<br/>"+response.encodeURL("index.html"));
%>