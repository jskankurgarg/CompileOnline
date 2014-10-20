package com.web;
import javax.servlet.*;
import javax.servlet.http.*;
public class RequestCounter implements ServletRequestListener {

	private static int activeRequests = 0;

	public void requestInitialized(ServletRequestEvent se) {
		activeRequests++;
		System.out.println("\n[[[[[[[new request initialized]]]]]]]]---------->total active active requests : "+activeRequests);
	}

	public void requestDestroyed(ServletRequestEvent se) {
		if(activeRequests > 0)
			activeRequests--;
		System.out.println("\n[[[[[[[request destroyed]]]]]]]]]]---------->total active requests : "+activeRequests);
	}

	public static int getActiveRequests() {
		return activeRequests;
	}
}