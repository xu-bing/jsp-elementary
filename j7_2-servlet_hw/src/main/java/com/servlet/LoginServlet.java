package com.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


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

		doPost(request, response);
	
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
		
		// ������ͼ
		// ������ת��ҳ����ת
		
		response.setContentType("text/html;charset=UTF-8");		// ע�͵�charset�۲�����// ��������ҳ����д�������ݵı��롣���Ǵ��ε����ݣ�
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();	// this: ָ����ǰ���󣬵�ǰ������LoginServlet
		
		boolean res = true;
		
		System.out.println("do post......");
		
		
		// ��ȡ�ʺš�����
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		// ��֤
		if (username.equals("tom") && pwd.equals("123")){										// �ʺš�������ȷ
			// =========================================
			System.out.println("rght username and pwd");
			// ���û��usernameList������˺�û�е�¼��
			
			if(application.getAttribute("usernameList") == null){										// userlist������
				List<String> usernameList = new ArrayList<String>();																
				application.setAttribute("usernameList", usernameList);
				usernameList.add(username);		
		//		System.out.println("userlist does not exist");
			} else {																					// userlist ����
				System.out.println("userlist exists");
				List<String> usernameList = (List<String>)application.getAttribute("usernameList");
				
				if(usernameList.contains(username)){																		// ����б����д��˺�,���ʾ�ѵ�½
					System.out.println("����");
					// ��������ݸ�jsp
					// why?Ҫ����result, ���Է�ֹ���ص�ҳ��ʱ�Ŀ�ָ�������really????
					// ���û�е�½����result��ֵû�д棬��login����ʱ��resultΪ�ա�
					res = false;  
					request.setAttribute("result", res);
					
					request.getRequestDispatcher("/login.jsp").forward(request,response);
					
					// return: 2�����ã�1��ʾ���ؽ����2��ʾ����������
					return;	// �������������ؽ���ģ���ΪdoPost��void���͵ġ���ֻ��ʾ�������е��˾ͽ����ˡ�
				} else {																								    // δ��½																				
					usernameList.add(username);
			
			// 1. ʹ��session ʵ�֡�
			//		HttpSession session = request.getSession();
			//		session.setAttribute("username", username);	
					
			//		request.getRequestDispatcher("/welcome.jsp").forward(request,response);		
					
			//      .............................("/login.jsp")
				} 																											// end: user
				
			}																							// end: userlist
					
			
			
			System.out.println("after userlist...");
			// ========================================
			//application.setAttribute("username", username);

			HttpSession session = request.getSession();
			session.setAttribute("username", username);	
			// ·�����⣺��д��ʾ���·����/ ��ʾ����·������·����
			// �����£������д/ ��ʲô�����
			request.getRequestDispatcher("/welcome.jsp").forward(request,response);		
		} else {																				// �ʺš��������
			System.out.println("error....");
			out.println("errrrrrrrrrrrrrrrrrrrrrr");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			
			//response.sendRedirect("/login.jsp");	
			out.println("errrrrrrrrrrrrrrrrrrrrrr");
		}	 																					// end: �ʺš�����
		
		
	
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
