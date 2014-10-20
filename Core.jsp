<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setAttribute("str","name");
	request.setAttribute("arr",(Object)(new String[]{"a","b","c"}));
%>
<c:forEach var="str" items="${arr}" begin="${true}">
hello-->${str} <br>
</c:forEach>