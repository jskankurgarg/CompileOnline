<%@ taglib uri="simpletag" prefix="mine" %>
before simple tag
<mine:simpletag>
<% out.println("this is scriptlet inside simple tag");%>
inside body
</mine:simpletag>
after simple tag