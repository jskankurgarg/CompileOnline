package com.web;
import java.io.*;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
 
public class TryItFilter implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		try{
	System.out.println("inside servlet try it filter..");
	File currentDir=new File(".");
	String rootPath=currentDir.getCanonicalPath();
	System.out.println("root path : "+rootPath);
	char sc=File.separatorChar;
	String target=rootPath+sc+"webapps"+sc+"test"+sc+"compiler";
	System.out.println("target path : "+target);
	FileOutputStream fos=new FileOutputStream(target+sc+"result.html");
	PrintWriter writer = new PrintWriter(fos);
	writer.print("");
	writer.close();
	fos.close();
	  }
	  catch(Exception e){
		  e.printStackTrace();
	}
	finally{
		System.out.println("result.html flushed......");
		chain.doFilter(request,response);
	}
    }
    public void init(FilterConfig config) throws ServletException {
         
        //Get init parameter
        String testParam = config.getInitParameter("test-param");
         
        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }
    public void destroy() {
        //add code to release any resource
    }
}