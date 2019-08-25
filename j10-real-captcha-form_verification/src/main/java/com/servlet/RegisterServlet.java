package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here


	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 获取前台输入参数 (不需要预处理：null, 空值，类型转换)
		String username = request.getParameter("username");
		String age = request.getParameter("age");


		// 验证
//		boolean result = true;
//		boolean result1 = true;
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		
		if(username == null || username.equals("")){
			errorMsg.put("username", "姓名不能为空");
//			result = false;
		} else if (username.length() > 10){
			errorMsg.put("username", "长度不能超过10!");
//			result = false;
		}
		
		if(age == null || age.equals("")){
			errorMsg.put("age", "年龄不能为空");
//			result1 = false;
		} else if(Integer.parseInt(age) > 100 || Integer.parseInt(age) < 1){
			errorMsg.put("age", "年龄必须在1-100之间");
		}

		//  传递结果
	//	if(result){
		if(errorMsg.isEmpty()){	// 如果errorMsg中没有错误提示信息，则结果为空。  
			// 做保存
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("errMsg", errorMsg);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

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
