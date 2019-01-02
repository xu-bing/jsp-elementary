package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

	/**
public class MyServlet extends HttpServlet {
	 * Constructor of the object.
	 */
	public MyServlet() {
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

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("张三");
		// test:
		// 直接访问
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// 输出 html 
		out.println("servlet输出html");
		out.println("<hr>");
		
//		1. 接收

		///////////////////////////////////////////////////////////////////////////////////////////
		// 接收的输入, 内容乱码=========================================================================
//		String name = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
		
		// 1. 接受
		// 1.1 jsp: forward的内容，
		// 发送前编码，接受的不需要重新编码，反而会乱码
		
		// 1.2 表单, JS脚本，超链接
		// 对接收的中文内容重新编码，固定写法
//		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");	// getBytes():把字符串转成2进制的，编码为ISO8859-1（前台传过来时，默认的编码方式）
//		
//		out.println(name);
//		System.out.println(name);
		
	
//		2. 输出
//		 request输出
//		//////////////////////////////////////////////////////////////////////////////////
//		String name = "李四";
//		name = URLEncoder.encode(name, "UTF-8");
//		
//		request.getRequestDispatcher("/b.jsp?username="+name).forward(request, response);
	
		
//		response输出
//		////////////////////////////////////////////////////////////////////////////////// 
//		String path = request.getContextPath();
//		System.out.println(path);
//		
//		response.sendRedirect(path + "/b.jsp?username="+name);
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
