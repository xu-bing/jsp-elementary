package com.servlet;

// 1.
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


// 2.

public class MyServlet extends HttpServlet{

	private String username;


	/**
	 * ����servlet������ĳ�ʼ�� ����˵ ������װ��Servletʱִ��
	 * ���ɷ������Զ�����
	 * ��ִ��1��
	 */
	// ��ʽ1��
	/*@Override
	public void init(){

		System.out.println("init....");

	}*/

	// ��ʽ2��
	public init(ServletConfig config) throws ServletException {
		super.init(config); 	// ����ɾ���������ܻ�ȡapplication, Ҳ����ȡ��ʼ��������
	}


	/**
	 * ���ܿͻ�������
	 * ������Ӧ��doGet, doPost����
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("service....");
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("doGet...");

		// -----------------------------------------------------------------------------
		// ������ö���
		// ���out
		// ҳ������õ����ࣺPrintWriter
		// PrintWriter ���� java.io
		PrintWriter out = response.getWriter();	// �쳣����

		out.println("HelloWorld");		// ��ҳ�����
		System.out.println("console output");	// �����̨���

		// ���session
		HttpSession session = request.getSession();
		// ���application
		ServletContext application = this.getServletContext();
		// ���config
		ServletConfig config = this.getServletConfig();

		// -----------------------------------------------------------------------------
		// ���� init-param ���ò���
		out.println("init-param:\t" + this.getInitParameter("age"));
		// => �鿴ҳ�����

		// ------------------------------------------------------------------------------
		// ���Զ��̲߳���
		// ����ʱ�����ͻ��˷���servlet�������䷽��ʱ������
		// ͬʱ��2���������ǩ��myeclipse�У�
		// ...MyServlet?username=tom
		// ...MyServlet?username=jack

		username = request.getParameter("username");	// ���username��ֵ�������丳��username.
		//	String username = request.getParameter("username");

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println(username);
		// => �����JACK, JACK
		// why?
		// 1st����username��ֵΪtom�� ��ӡ֮ǰsleep��6�룬
		// ��2nd����1st��ӡǰ����username��ֵΪjack��

		// ��α��⣺
		// ʹ�þֲ����������洫���ֵ��
		// why?
		// ͬһ��servlet���󣬵��ǵ��÷�����ʱ�������������������ٵ����ķ���ջ��
		// 2���ֲ���������2���ڴ�ռ䡣


	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		System.out.println("doPost...");

		// ���application����
		ServletContext applicatioin = this.getServletContext();

		// ���config����
		ServletConfig config = this.getServletConfig();

	}

	/**
	 * ����servlet��������ʱ���ã�����˵�������Ƴ�servletʱִ�У�����˵������ֹͣ��жװServletʱִ��
	 * ��һЩ�ƺ���, �����������ͷ�ռ����Դ
	 * �������Զ�����
	 * ��ִ��
	 *
	 *
	 */
	@Override
	public void destroy(){
		System.out.println("destroy...");
	}




}	// HttpServlet

		/*
		 * todo:
		 * why? ������ protected
		 *
		 * ע��㣺
		 * û�д����쳣
		 *
		 *
		 * !! ��η���servlet, �۲�output
		 * servlet����
		 * initִֻ��1�Ρ�
		 * service, doGet����һ��servlet��ִ��1�Ρ�
		 * destroy: û��ִ�� why? gc�ɷ�����������
		 *
		 * !! �رշ��������۲����
		 * destroy��ִ��1�Ρ�
		 *
		 * ���jsp���ö���
		 * application
		 * cofig
		 *
		 */
