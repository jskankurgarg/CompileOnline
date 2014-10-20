package foo;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class RDServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
/*		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		out.write("this is request dispatcher test.....<br>");
		Enumeration header=req.getHeaders("accept-encoding");
		while(header.hasMoreElements()){// sample getHeadesr testing ...
			out.println("accept-encoding--> "+header.nextElement()+"<br/>");
		}
		out.flush();
*/
resp.setContentType("application/jar");
ServletContext ctx = getServletContext();
System.out.println("context : "+ctx);
InputStream is = ctx.getResourceAsStream("/el-api.jar");
/**
must have "/" inside the method
for tomcat 5.5x
may or may not have "/" inside method
for tomcat 7.0x
*/
System.out.println("input stream : "+is);
int read = 0;
byte[] bytes = new byte[1024];
OutputStream os = resp.getOutputStream();
while ((read = is.read(bytes)) != -1) {
os.write(bytes, 0, read);
}
os.flush();
/**
forwarding statement doesnot get executed and no exception is thrown... against book's stmt!!
*/
		RequestDispatcher rd=req.getRequestDispatcher("index.html");//
		RequestDispatcher rdctx=getServletContext().getRequestDispatcher("/SendRedirect.jsp");
		rdctx.forward(req,resp);
//		out.println("asdasd");
//		out.flush();
os.close();
	}
}