<%@ page import="java.io.*" %>
<%
try{
	response.setContentType("application/jar");
	OutputStream os=response.getOutputStream();
	InputStream is=application.getResourceAsStream("/el-api.jar");
	byte[] buffer=new byte[1024];
	while(is.read(buffer)!=-1){
		os.write(buffer,0,1024);
	}
	os.flush();
}
catch(Exception e){
	e.printStackTrace();
}
%>