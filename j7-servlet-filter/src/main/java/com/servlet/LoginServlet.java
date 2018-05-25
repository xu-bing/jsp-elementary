package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;
import javax.servlet.*;

public class LoginServlet extends HttpServlet {
	
	
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		// 删除干净原始内容
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

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("output to page");
		
		// System.out.println("console output");
		
		//HttpSession session = request.getSession();
		
		//ServletContext application = this.getServletContext();
		
		//ServletConfig config = this.getServletConfig();
		
		// 获得事件处理标识位
		String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag").trim();
		
		// 事件处理
		if (flag.equals("login")){
			// 获取用户输入
			String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
			String pwd = request.getParameter("pwd") == null ? "" : request.getParameter("pwd").trim();
			
			System.out.println(username);
			
			// 验证
			if(username.equals("tom") && pwd.equals("123")){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}	//  验证
				
		} else if (flag.equals("logout")){
			
			
		} // if...else
		
		
	}	// doPost();

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
