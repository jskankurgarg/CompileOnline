<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="foo.*" %>
<%
	String list[]={"asd","qwe","rty","ghjK"};
	request.setAttribute("list",list);
	String list2[]={"asd","qwe","rty","ghjK","asd"};
	pageContext.setAttribute("list",list2);
	request.setAttribute("a","apple");
	request.setAttribute("dog",new foo.Dog("German Sheperd"));
%>

${a}
<br/>
${list}
<c:out value='${a}' />
<c:out value='${list[0]}' />
<c:out value='${a12}' />
<hr/>
<c:out value='<%=request.getAttribute(\"a\")%>' />
<hr/>
<c:out value='<b>asd</b>' />
<br/>
<c:forEach var="l" items="${list}" ><!--begin="1" step="2"-->
${l}<br>
</c:forEach>
<hr>
${paramValues.asd[0]}

<br/>
${dog.breed}