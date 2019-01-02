package com.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

/*
 * steps:
 * 1. 定义filter
 * 2. 配置web.xml
 * */


public class LoginFilter implements Filter {
	
	// !ide代码前的空心箭头：表示实现某个抽象方法。
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter destroy....");
		
	}

	/**
	 * 进行过滤操作
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("do filter......");
		
		chain.doFilter(request, response);	// 无条件放行
		
		System.out.println("after do filter");
		// 注册过滤器
		// 测试：重启服务器
		// 观察控制台：
		// 服务器一启动，filter就启动了。
		// 2. 访问index.jsp
	
		// --------------------------------------------------------------
		/*
		 * 如何获取session
		 * 1. servlet中可以直接request.getSession
		 *    why? servlet中是HttpServletRequest. 它继承于ServletRequest
		 * 2. filter中不可以
		 * 	  why? filter中是ServletRequest. 
		 * 	
		 * check api: httpservletRequest, 看它是否是继承于servletrequest
		 * 
		 * */
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
	//	HttpServletResponse httpResponse = (HttpServletResponse)response;

		HttpSession httpSession = httpRequest.getSession();
		// ---------------------------------------------------------------

		// 设置welcome.jsp的访问权限：如果已经已经登陆，则可访问该页面；否则，跳转到login.jsp。
		if(httpSession.getAttribute("username") != null){

			chain.doFilter(request, response);
		} else {
	//		httpResponse.sendR edirect("/login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(httpRequest, response); // forward的参数：ServletRequest, ServletResponse
		}

		// 测试：
		// 再在web.xml中增加配置过滤welcome.jsp。
		
	}
	
	/**
	 * 创建过滤器时，由服务器自动调用，进行初始化工作。
	 * 
	 * 服务器启动时，就进行init。！观察
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter init.......");
		
	}

	

}

/*
 * 测试：
 * 访问index.jsp, 控制台输出 do filter...
 * 访问welcome.jsp, 控制台无输出。
 *
 * */

