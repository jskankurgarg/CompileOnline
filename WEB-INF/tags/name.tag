<%@ attribute name="username" required="true" rtexprvalue="true" %>
<%@ tag body-content="scriptless" %>
hi this is tag file<br>
user  name : ${username}
<hr/>
this is body content : <jsp:doBody/>