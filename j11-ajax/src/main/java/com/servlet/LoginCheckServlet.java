package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckServlet extends HttpServlet {

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

		this.doPost(request, response);
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

	//	response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// ����ǰ��̨����ͨ��
		String username = request.getParameter("username");	// ����ʱ����Ҫ�жϿյ����
		String pwd = request.getParameter("pwd");
		
//		System.out.println(username);
//		System.out.println(pwd);
		
		// --------------------------------------------------------
//		// ���ԣ�responseText
//		response.setContentType("text/xml;charset=UTF-8");
//		// .....................("text/html............."); 	// working
//		PrintWriter out = response.getWriter();
//		String str = "����";
//		out.println(str);
	
// --------------------------------------------------------------------		

		// �������xml
//		// ��֤
    	String res = "false";
		
//		String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
//		
//		String pwd = request.getParameter("pwd") == null ? "" : request.getParameter("pwd").trim();
//		
//		System.out.println(username + ":" +pwd);
//		
		if("tom".equals(username) && "123".equals(pwd)){
			
			res = "true";
			
		}
//		
		
		//�������������Ӧ���
		
//		out.print(res);
		out.print("<root><result>"+res+"</result></root>");
		out.flush();
		out.close();
		
		
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
