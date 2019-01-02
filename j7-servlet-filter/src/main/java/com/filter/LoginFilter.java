package com.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

/*
 * steps:
 * 1. ����filter
 * 2. ����web.xml
 * */


public class LoginFilter implements Filter {
	
	// !ide����ǰ�Ŀ��ļ�ͷ����ʾʵ��ĳ�����󷽷���
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter destroy....");
		
	}

	/**
	 * ���й��˲���
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("do filter......");
		
		chain.doFilter(request, response);	// ����������
		
		System.out.println("after do filter");
		// ע�������
		// ���ԣ�����������
		// �۲����̨��
		// ������һ������filter�������ˡ�
		// 2. ����index.jsp
	
		// --------------------------------------------------------------
		/*
		 * ��λ�ȡsession
		 * 1. servlet�п���ֱ��request.getSession
		 *    why? servlet����HttpServletRequest. ���̳���ServletRequest
		 * 2. filter�в�����
		 * 	  why? filter����ServletRequest. 
		 * 	
		 * check api: httpservletRequest, �����Ƿ��Ǽ̳���servletrequest
		 * 
		 * */
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
	//	HttpServletResponse httpResponse = (HttpServletResponse)response;

		HttpSession httpSession = httpRequest.getSession();
		// ---------------------------------------------------------------

		// ����welcome.jsp�ķ���Ȩ�ޣ�����Ѿ��Ѿ���½����ɷ��ʸ�ҳ�棻������ת��login.jsp��
		if(httpSession.getAttribute("username") != null){

			chain.doFilter(request, response);
		} else {
	//		httpResponse.sendR edirect("/login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(httpRequest, response); // forward�Ĳ�����ServletRequest, ServletResponse
		}

		// ���ԣ�
		// ����web.xml���������ù���welcome.jsp��
		
	}
	
	/**
	 * ����������ʱ���ɷ������Զ����ã����г�ʼ��������
	 * 
	 * ����������ʱ���ͽ���init�����۲�
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter init.......");
		
	}

	

}

/*
 * ���ԣ�
 * ����index.jsp, ����̨��� do filter...
 * ����welcome.jsp, ����̨�������
 *
 * */

