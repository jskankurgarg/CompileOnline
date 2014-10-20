package com.web;
import javax.servlet.*;
import javax.servlet.http.*;
public class SessionCounter implements HttpSessionListener {

	private static int activeSessions = 0;

	public void sessionCreated(HttpSessionEvent se) {
		activeSessions++;
		System.out.println("\n[[[[[[[new session created]]]]]]]]---------->total active session : "+activeSessions+"   @   "+se.getSession()+"\n");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		if(activeSessions > 0)
			activeSessions--;
		System.out.println("\n[[[[[[[session destroyed]]]]]]]]]]---------->total active session : "+activeSessions+"   @    "+se.getSession()+"\n");
	}

	public static int getActiveSessions() {
		return activeSessions;
	}
}