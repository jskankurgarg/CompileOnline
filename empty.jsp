<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="any" prefix="mine" %>
<%
java.util.List al=new java.util.ArrayList();
//al.add(null);
//al.add("");
//al.add(123);
al=null;
//al.clear();
request.setAttribute("list",al);
int[] all=new int[10];
request.setAttribute("arr",all);
java.util.Map map=new java.util.HashMap();
map.put("a","apple");
map.put("b","ball");
request.setAttribute("map",map);
%>

<c:choose>
	<c:when test="${not empty list}">
		list is not empty
	</c:when>
	<c:otherwise>
		list is empty
	</c:otherwise>
</c:choose>
<br>
${3 div 3}
<br>
empty list : ${not empty list}
<br>
empty arr : ${empty arr}
<br>
empty map : ${empty map}
<hr>
${list}
<hr>
checking EL expression<br>
<c:if test="${map['a']=='apple'}">
map has apple
</c:if><br>
<c:if test='${map["b"]=="ball"}'>
map has ball
</c:if>
<br>
<a href="${map["a"]}"></a><br>
<a href='${map['b']}'></a>
<a href="${map['b']}"></a>
${empty false}
<c:forEach var="map" items="${map}" varStatus="count">
	${map}@${count.count}<br>
</c:forEach>