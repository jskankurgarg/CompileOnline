package com;
import foo.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyServletContextListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent evt){
		System.out.println("context listener called ....");
		ServletContext ctx=evt.getServletContext();
		String breed=ctx.getInitParameter("breed");
		foo.Dog dog=new foo.Dog(breed);
		ctx.setAttribute("dog",dog);
	}
	public void contextDestroyed(ServletContextEvent evt){
		System.out.println("context listener signing off ....");
	}
}