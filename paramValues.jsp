<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
${paramValues.a}
<br>
${paramValues.a[1]}
<br>
${param.a}
<br>
<%
	Cookie c=new Cookie("name","apple");
	c.setMaxAge(3600);
	response.addCookie(c);
%>
${cookie.NID.value}
<br>
${cookie.name.name}---->${cookie.name.value}
<br>
${cookie.name}

<br>
<%
out.println("<html><body>qqqqqqqqqqqq</body></html>");
out.flush();
%>
<br>
<jsp:useBean id="dog" class="foo.Dog" scope="request">
	<jsp:setProperty name="dog" property="breed" param="breed"/>
</jsp:useBean>
${param.breed}
<jsp:getProperty name="dog" property="breed"/>

<%
out.flush();
out.println(dog.getBreed());%>
<br>
<hr>
asd
<c:if test='${3 == 3}'>
abbbbbbbbbbbbbbbbbb
</c:if>
xxxxxxxxxxxxxxxxxxxxxx
<%out.flush();%>
<jsp:forward page="index.html"/>
<hr>
after forward
