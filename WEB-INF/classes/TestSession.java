package com;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestSession implements HttpSessionBindingListener{//,HttpSessionListener,HttpSessionActivationListener,HttpSessionAttributeListener{
	public void valueBound(HttpSessionBindingEvent evt){
		System.out.println("inside valueBound  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public void valueUnbound(HttpSessionBindingEvent evt){
		System.out.println("inside valueUnbound  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
}