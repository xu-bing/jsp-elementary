package com.servlet;

// 1.
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


// 2.

public class MyServlet extends HttpServlet{

	private String username;


	/**
	 * 用于servlet创建后的初始化 或者说 服务器装入Servlet时执行
	 * 它由服务器自动调用
	 * 仅执行1次
	 */
	// 方式1：
	/*@Override
	public void init(){

		System.out.println("init....");

	}*/

	// 方式2：
	public init(ServletConfig config) throws ServletException {
		super.init(config); 	// 不可删除，否则不能获取application, 也不能取初始化参数。
	}


	/**
	 * 接受客户端请求
	 * 调用相应的doGet, doPost方法
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
		// 获得内置对象
		// 获得out
		// 页面输出用到的类：PrintWriter
		// PrintWriter 属于 java.io
		PrintWriter out = response.getWriter();	// 异常处理

		out.println("HelloWorld");		// 向页面输出
		System.out.println("console output");	// 向控制台输出

		// 获得session
		HttpSession session = request.getSession();
		// 获得application
		ServletContext application = this.getServletContext();
		// 获得config
		ServletConfig config = this.getServletConfig();

		// -----------------------------------------------------------------------------
		// 测试 init-param 配置参数
		out.println("init-param:\t" + this.getInitParameter("age"));
		// => 查看页面输出

		// ------------------------------------------------------------------------------
		// 测试多线程并发
		// 发生时机：客户端访问servlet，调用其方法时发生。
		// 同时打开2个浏览器标签（myeclipse中）
		// ...MyServlet?username=tom
		// ...MyServlet?username=jack

		username = request.getParameter("username");	// 获得username的值，并将其赋给username.
		//	String username = request.getParameter("username");

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println(username);
		// => 结果：JACK, JACK
		// why?
		// 1st：给username赋值为tom， 打印之前sleep了6秒，
		// 而2nd：在1st打印前，给username赋值为jack。

		// 如何避免：
		// 使用局部变量来保存传入的值。
		// why?
		// 同一个servlet对象，但是调用方法是时，虚拟机都会给方法开辟单独的方法栈。
		// 2个局部变量就是2个内存空间。


	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		System.out.println("doPost...");

		// 获得application对象
		ServletContext applicatioin = this.getServletContext();

		// 获得config对象
		ServletConfig config = this.getServletConfig();

	}

	/**
	 * 用于servlet对象销毁时调用，或者说在容器移除servlet时执行，或者说服务器停止且卸装Servlet时执行
	 * 做一些善后工作, 如清理任务、释放占用资源
	 * 服务器自动调用
	 * 仅执行
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
		 * why? 方法是 protected
		 *
		 * 注意点：
		 * 没有处理异常
		 *
		 *
		 * !! 多次访问servlet, 观察output
		 * servlet单例
		 * init只执行1次。
		 * service, doGet访问一次servlet就执行1次。
		 * destroy: 没有执行 why? gc由服务器决定的
		 *
		 * !! 关闭服务器，观察输出
		 * destroy：执行1次。
		 *
		 * 获得jsp内置对象
		 * application
		 * cofig
		 *
		 */
