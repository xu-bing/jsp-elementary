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
		
		// �¼������ʶλ
		String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag").trim();
		
		if(flag.equals("login")){
			
			// ��ȡ����
			String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
			String pwd = request.getParameter("pwd") == null ? "" : request.getParameter("pwd").trim();
			// ---------------------------------------------------------
			
			System.out.println(username);
			if (username.equals("����") && pwd.equals("123")){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				
				// ��б�ܣ���ʾ����������Ŀ�ĸ�·��
				// �ޣ���ʾ����������ļ������·����hr: servlet/welcome.jsp
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);	
			} else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}	// if...else...
			
			
		} else if (flag.equals("logout")){
			
		}
	
	}	// doPost()
	
	/**
	 * д��Ҫ����������
	 * �Ȳ����������ԣ� 404
	 * ����������� ���ԣ� 404.
	 * 
	 * ��֤ǰ��
	 * ������룺���롣
	 * ������ҳ����롣
	 */
}
