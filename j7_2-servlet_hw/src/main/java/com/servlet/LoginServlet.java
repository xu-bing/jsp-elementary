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
		
		// 画流程图
		// 数据流转与页面跳转
		
		response.setContentType("text/html;charset=UTF-8");		// 注释掉charset观察结果。// 用来决定页面上写死的内容的编码。（非传参的内容）
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();	// this: 指代当前对象，当前对象是LoginServlet
		
		boolean res = true;
		
		System.out.println("do post......");
		
		
		// 获取帐号、密码
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		// 验证
		if (username.equals("tom") && pwd.equals("123")){										// 帐号、密码正确
			// =========================================
			System.out.println("rght username and pwd");
			// 如果没有usernameList则这个账号没有登录过
			
			if(application.getAttribute("usernameList") == null){										// userlist不存在
				List<String> usernameList = new ArrayList<String>();																
				application.setAttribute("usernameList", usernameList);
				usernameList.add(username);		
		//		System.out.println("userlist does not exist");
			} else {																					// userlist 存在
				System.out.println("userlist exists");
				List<String> usernameList = (List<String>)application.getAttribute("usernameList");
				
				if(usernameList.contains(username)){																		// 如果列表中有此账号,则表示已登陆
					System.out.println("存在");
					// 将结果传递给jsp
					// why?要定义result, 可以防止返回到页面时的空指针情况。really????
					// 如果没有登陆，则result的值没有存，到login界面时，result为空。
					res = false;  
					request.setAttribute("result", res);
					
					request.getRequestDispatcher("/login.jsp").forward(request,response);
					
					// return: 2个作用，1表示返回结果，2表示方法结束。
					return;	// 它不是用来返回结果的，因为doPost是void类型的。它只表示代码运行到此就结束了。
				} else {																								    // 未登陆																				
					usernameList.add(username);
			
			// 1. 使用session 实现。
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
			// 路径问题：不写表示相对路径，/ 表示绝对路径（根路径）
			// 测试下：如果不写/ 有什么结果。
			request.getRequestDispatcher("/welcome.jsp").forward(request,response);		
		} else {																				// 帐号、密码错误
			System.out.println("error....");
			out.println("errrrrrrrrrrrrrrrrrrrrrr");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			
			//response.sendRedirect("/login.jsp");	
			out.println("errrrrrrrrrrrrrrrrrrrrrr");
		}	 																					// end: 帐号、密码
		
		
	
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
