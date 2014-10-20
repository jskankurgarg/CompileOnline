<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Editor</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="trycss.css">

  </head>
  
  <body>
    <div class="container">
  <div class="header"><a href="www:zensar.com"><img src="images/zensar_logo.jpg" alt="Insert Logo Here" name="Insert_logo" width="200" height="100" id="Insert_logo" style="background-color: #C6D580; display:block;" /></a> 
    <!-- end .header --></div>
  <div class="content">
  <form style="margin:0px" action="./servlet/ControllerServlet" method="post" id="tryitform" name="tryitform" >
<table border="1 " class="maintable" cellpadding="3px" cellspacing="3px" width="100%">
	<tr>
        <td width="50%" valign="top">
        <input style="margin-bottom:5px;font-family:verdana;" name="submit" type="submit" value="Edit and Click Me &raquo;" onClick="displayed()">
		<br>
<!--        <a href="http://www.zensar.com/" target="view">click to ZenSar</a>-->
        <textarea class="code_input" id="pre_code" wrap="logical" name="code">${requestScope.code}</textarea>
        <input type="hidden" name="code" id="code" />
        <input type="hidden" id="bt" name="bt" />

        </td>
        <td valign="top">
        <p class="result_header">Your Result:</p>
        <iframe class="result_output" frameborder="0" name="view" src="compiler/result.html"></iframe>
        </td>
        </tr>
        <tr>
        <td align="left" class="bottomtext" rowspan="2">
        enter your input (stdin) :<br />
        <textarea name="input" rows="6" cols="56" style="width:inherit" autofocus="autofocus"><c:out value="${requestScope.input}" default=""/></textarea>
        </td>
        <td>
        	result : <div id="result">${requestScope.resultStatus}</div>
        </td>
       </tr>
       <tr>
		<td>
        	time : <c:out value="${applicationScope.timeLimit}" default="5"/>  secs
        </td>
	</tr>
</table>
</form>
  <!-- end .content --></div>
  <div class="footer">
    <p style="text-align:center">some copyright information and privacy policies</p>
  <!-- end .footer --></div>
  <!-- end .container --></div>
  </body>
</html>