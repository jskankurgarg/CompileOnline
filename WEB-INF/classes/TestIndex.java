package com.foo;
import foo.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
public class TestIndex extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws java.io.IOException{
		PrintWriter out=resp.getWriter();
		out.println("<h2>Hi this is "+getClass()+"  a servlet.</h2>");
		int len=req.getIntHeader("Content-Length");
		out.println("<h2>Content Length is : "+len+".</h2>");
		foo.Dog dog=(foo.Dog)getServletConfig().getServletContext().getAttribute("dog");
		System.out.println("I just got a dog : "+dog);
	}
}