package foo;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SendRedirect extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		out.write("this is send redirect servlet ..<br>");
		out.flush();
		out.write("asjkkadsa");
/**
if the above stmt is uncommented then no exception is thrown @ runtime
and output is displayed upto sendRedirect() stmt
*/
		resp.sendRedirect("index.html");
		out.println("asdAS");out.flush();
	}
}