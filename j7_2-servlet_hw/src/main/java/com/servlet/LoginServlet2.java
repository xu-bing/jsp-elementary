package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet2 extends HttpServlet {



	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 事件处理标识位
		String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag").trim();
		
		if(flag.equals("login")){
			
			// 获取输入
			String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
			String pwd = request.getParameter("pwd") == null ? "" : request.getParameter("pwd").trim();
			// ---------------------------------------------------------
			
			System.out.println(username);
			if (username.equals("张三") && pwd.equals("123")){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				
				// 反斜杠：表示服务器上项目的根路径
				// 无：表示相对于所在文件的相对路径。hr: servlet/welcome.jsp
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);	
			} else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}	// if...else...
			
			
		} else if (flag.equals("logout")){
			
		}
	
	}	// doPost()
	
	/**
	 * 写完要重启服务器
	 * 先不重启，测试： 404
	 * 如果不重启， 测试： 404.
	 * 
	 * 验证前：
	 * 不设编码：乱码。
	 * 设置下页面编码。
	 */
}
