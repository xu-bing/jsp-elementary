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
		
		out.println("����");
		// test:
		// ֱ�ӷ���
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// ��� html 
		out.println("servlet���html");
		out.println("<hr>");
		
//		1. ����

		///////////////////////////////////////////////////////////////////////////////////////////
		// ���յ�����, ��������=========================================================================
//		String name = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
		
		// 1. ����
		// 1.1 jsp: forward�����ݣ�
		// ����ǰ���룬���ܵĲ���Ҫ���±��룬����������
		
		// 1.2 ��, JS�ű���������
		// �Խ��յ������������±��룬�̶�д��
//		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");	// getBytes():���ַ���ת��2���Ƶģ�����ΪISO8859-1��ǰ̨������ʱ��Ĭ�ϵı��뷽ʽ��
//		
//		out.println(name);
//		System.out.println(name);
		
	
//		2. ���
//		 request���
//		//////////////////////////////////////////////////////////////////////////////////
//		String name = "����";
//		name = URLEncoder.encode(name, "UTF-8");
//		
//		request.getRequestDispatcher("/b.jsp?username="+name).forward(request, response);
	
		
//		response���
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
