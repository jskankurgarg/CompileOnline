package com.web;

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import com.compiler.*;

public class ControllerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ControllerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside doPost() of ControllerServlet ....");

/*		File dir1 = new File(".");
        File dir2 = new File("..");
        try {
            System.out.println("Current dir : " + dir1.getCanonicalPath());
            System.out.println("Parent  dir : " + dir2.getCanonicalPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
*/		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String code=request.getParameter("code");
		System.out.println("code received : "+code);

		String input=request.getParameter("input");
		System.out.println("input received : "+input);

		ServletContext context=getServletContext();
		FileSystem fs=new FileSystem();
		fs.generateFile(input,"input.txt");

		Properties time=new Properties();
		String pptDir=FileSystem.appRoot+FileSystem.sp+"WEB-INF"+FileSystem.sp+"compiler.properties";
		time.load(new FileInputStream(pptDir));
		System.out.println("time_slot_1 : "+time.getProperty("time_slot_1")+"\t"+time.getProperty("time_slot_1").getClass());
		System.out.println("time_slot_2 : "+time.getProperty("time_slot_2"));
		System.out.println("user_limit : "+time.getProperty("user_limit"));

		long timeLimit=Long.parseLong(time.getProperty("time_slot_1"));//initialize with basic value.
		int userCount=com.web.RequestCounter.getActiveRequests();
		int userLimit=Integer.parseInt(time.getProperty("user_limit"));
		if(userCount > userLimit){
			timeLimit = Long.parseLong(time.getProperty("time_slot_2"));
		}
		System.out.println(">>>>>>-----------doPost---------------@>"+timeLimit);

		context.setAttribute("timeLimit",timeLimit);
		System.out.println(">>>>>>------------doPost--------------@>"+timeLimit);
		Controller ctrl=new Controller();
		ctrl.setTimeLimit(timeLimit);

		System.out.println(">>>>>----------------doPost with ctrl.getTimeLimit------------>"+ctrl.getTimeLimit());
		Result result=ctrl.compile(code);

		String resultOutput = "<pre>"+result.getOutput()+"</pre>";
		//out.println(resultOutput);
		String resultStatus = "<pre>"+result.getResultStatus()+"</pre>";

		request.setAttribute("code",code);
		request.setAttribute("input",input);
		request.setAttribute("resultOutput",resultOutput);
		fs.generateFile(resultOutput,"result.html");

		request.setAttribute("resultStatus",resultStatus);
		RequestDispatcher rd=request.getRequestDispatcher("/TryIt.jsp");

		rd.forward(request,response);
//		out.println("<pre>"+result.getResultStatus()+result.getOutput()+"</pre>");
//		out.flush();
//		out.close();
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}