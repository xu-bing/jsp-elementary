package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.domain.Emp;
import com.service.EmpService;

public class EmpServlet extends HttpServlet {
	
	private EmpService empService;
	
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
		empService = new EmpService();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		//(1)查询员工总数（总记录数）
		//统计员工总数
		int count  = empService.countEmps();

		
		//将员工总数保存到request作用域中，并在empList.jsp页面动态展示
		request.setAttribute("count", count);

		
		//(2)根据员工记录总数和每页大小求总页数 （总页数）
		int pageSize = 3;			//每页大小
		//计算总页数
		int pageCount = count % pageSize == 0 ? count/pageSize : count/pageSize+1;
		
		request.setAttribute("pageCount", pageCount);		// 填充总页数
	
		//(3)查询指定页的数据
		//当前页码
		// 判断空值
		int currentPage;
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//request.setAttribute("currentPage", currentPage);	// 不可在此处存，这会导致请求的当前页可能超出起始结束的范围。		
		// ------------------------------
		if(currentPage > pageCount){
			currentPage = pageCount;
		}
		if(currentPage <= 0){
			currentPage = 1;
		}	
		request.setAttribute("currentPage", currentPage);		// 填充当前页码	
		// -------------------------------
		
		List<Emp> list = empService.queryEmps(currentPage, pageSize);		// currentPage只要是数字就行。满足条件的就有结果，不满足条件的就为null。
		request.setAttribute("list", list);		
		request.getRequestDispatcher("/emplist.jsp").forward(request, response);		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
