package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
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
	@Override
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
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 获得输入参数
		String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
		String pwd = request.getParameter("pwd") == null ? "" : request.getParameter("pwd").trim();
		String captcha = request.getParameter("captcha") == null ? "" : request.getParameter("captcha").trim();
		
		HttpSession session = request.getSession();
		String captchaFrmServ = (String)session.getAttribute("captcha");
		
		// 先验证验证码
		if(captcha.equals(captchaFrmServ)){
			// 再验证账号密码
			if("tom".equals(username) && "123".equals(pwd)){
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		} else {
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}	// doPost

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}

/**
 * 异常：
 * 将类的public修饰符去掉怎样？
 * 前台404，后台 error: .... public
 *
 */
