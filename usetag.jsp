<%@ taglib prefix="mine" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<c:set var="username" scope="application" value="Radhe"/>
username inside jsp : ${username}<br/>
<mine:name username="${username}">
asjldhajkdh
${username}
</mine:name>
<hr>
in the end<br>
<!--<%= application.getAttribute("username")%>-->
<%
	session.setAttribute("dog",new foo.Dog("indian"));
//	session.setAttribute("dog",new foo.Dog("german"));
	session.setAttribute("dog",new foo.Dog("espanol"));
	session.removeAttribute("dog");
//	session.setAttribute("a",123);
//	session.setAttribute("a",123);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cart" value="asd"/>
${cart}
<c:remove var="cart" scope="session" />
<br>
<%-- out.println("inside JPS comment"); --%>