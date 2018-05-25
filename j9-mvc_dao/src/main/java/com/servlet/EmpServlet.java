package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import com.domain.*;

import com.service.*;
import com.service.iface.*;

public class EmpServlet extends HttpServlet {
	
	//private EmpService empService;
	private EmpServiceIface empService;

	/**
	 * Constructor of the object.
	 */
	public EmpServlet() {
		super();
		
		empService = new EmpService();	// servlet是单例的，所以empService只会创建1个实例。
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

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//EmpService empService = new EmpService();	// 要调用 queryAllEmps(), 将其作为成员变量。
		// 写在此处的特点：每次调用doPost，都会创建EmpService实例，会造成效率的下降，而作为成员变量，只会创建1次。
		
		// 获得操作标识位
		// !!另一写法
		// String flag = request.getParameter("flag") == null? "" : request.getParameter("flag").trim(); 
		// if (flag.equals("query"))
		
		String flag = request.getParameter("flag");		// !!这是获得flag标识本身。
		// => flag：null 或者 query
		// null是不可进行任何运算的。
		
		// if(flag != null && flag.equals("query"))		//  常规思路
		// 简化的写法
		if("query".equals(flag)){	// 注意： flag是变量，不是常量"flag"
			
			// 接收页面请求: 查询所有员工
			// 调用EmpService这个JavaBean来完成
			
			/*List<Emp> empList = empService.queryAllEmps();
			
			// 作用作用域传参，使用request
			request.setAttribute("empList", empList);
			//
			request.getRequestDispatcher("/emplist.jsp").forward(request, response);*/
			this.queryAllEmps(request, response);
			
		} else if ("del_emp".equals(flag)){
			// 删除动作要做的事：
			// 删除， 查询（删除后的员工），显示
			
			// 1. 删除
			String strEmpNo = request.getParameter("empno") == null ? "0" : request.getParameter("empno").trim();
			int empNo = Integer.parseInt(strEmpNo);
			
			boolean result = empService.delEmpById(empNo);
			
			if (result == true){
				/*List<Emp> empList = empService.queryAllEmps();
				
				request.setAttribute("empList", empList);
				
				request.getRequestDispatcher("/emplist.jsp").forward(request, response);*/
				
				this.queryAllEmps(request, response);
				
			} else {
				
				response.sendRedirect("/error.jsp");
			}
			
			// 2. 查询现有员工
			// 3. 传参，显示查询的现有员工
			
		} else if("query_by_id".equals(flag)){
			
			// 获取输入参数
			String strEmpNo = request.getParameter("empno") == null ? "0" : request.getParameter("empno").trim();
			int empNo = Integer.parseInt(strEmpNo);
			
			// 查询员工
			Emp emp = empService.queryEmpById(empNo);
			
			// 传递员工，跳转至更新页面
			request.setAttribute("emp", emp);
			
			request.getRequestDispatcher("/update_emp.jsp").forward(request, response);
			
			
		} else if("updateEmpById".equals(flag)){
			// 获得输入参数
			String strEmpNo = request.getParameter("empno") == null ? "0" : request.getParameter("empno").trim();	// 必须trim(), 否则： NumberFormatingException. 传出来的empno包含空格。
			int empNo = Integer.parseInt(strEmpNo);
			
			String name = request.getParameter("name") == null ? "" : request.getParameter("name").trim();
			String job = request.getParameter("job") == null ? "" : request.getParameter("job").trim();
			
			String strSal = request.getParameter("sal") == null ? "0.0" : request.getParameter("sal").trim();
			double sal = Double.parseDouble(strSal);
			
			// 调用更新操作
			// 更新操作的参数
			Emp emp = new Emp(empNo, name, job, sal);
			// 执行更新
			boolean result = empService.updateEmpById(emp);
			
			if(result == true){
				/*List<Emp> empList = empService.queryAllEmps();
				
				// 作用作用域传参，使用request
				request.setAttribute("empList", empList);
				//
				request.getRequestDispatcher("/emplist.jsp").forward(request, response);*/
				
				this.queryAllEmps(request, response);
				
			} else {
				
					
					response.sendRedirect("/error.jsp");
				
			}
		
		}
		
		
		
	
		
		
		
		
		
	}	// doPost
	
	/**
	 * 查询所有员工
	 * 
	 * 为何返回值是void，而不是List<Emp>? 不需要。
	 */
	public void queryAllEmps(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		List<Emp> empList = empService.queryAllEmps();
		
		request.setAttribute("empList", empList);
		
		request.getRequestDispatcher("/emplist.jsp").forward(request, response);
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
