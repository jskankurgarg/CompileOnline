package com.web;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
public class RequestListener implements ServletRequestListener {
  private static long reqCount;
  public void requestInitialized(ServletRequestEvent sre) {
	  try{
	System.out.println("inside servlet request listener..");
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
  }
  public void requestDestroyed(ServletRequestEvent sre) {
  }
}