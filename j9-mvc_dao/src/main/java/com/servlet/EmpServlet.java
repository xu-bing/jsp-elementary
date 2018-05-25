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
		
		empService = new EmpService();	// servlet�ǵ����ģ�����empServiceֻ�ᴴ��1��ʵ����
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
		
		//EmpService empService = new EmpService();	// Ҫ���� queryAllEmps(), ������Ϊ��Ա������
		// д�ڴ˴����ص㣺ÿ�ε���doPost�����ᴴ��EmpServiceʵ���������Ч�ʵ��½�������Ϊ��Ա������ֻ�ᴴ��1�Ρ�
		
		// ��ò�����ʶλ
		// !!��һд��
		// String flag = request.getParameter("flag") == null? "" : request.getParameter("flag").trim(); 
		// if (flag.equals("query"))
		
		String flag = request.getParameter("flag");		// !!���ǻ��flag��ʶ����
		// => flag��null ���� query
		// null�ǲ��ɽ����κ�����ġ�
		
		// if(flag != null && flag.equals("query"))		//  ����˼·
		// �򻯵�д��
		if("query".equals(flag)){	// ע�⣺ flag�Ǳ��������ǳ���"flag"
			
			// ����ҳ������: ��ѯ����Ա��
			// ����EmpService���JavaBean�����
			
			/*List<Emp> empList = empService.queryAllEmps();
			
			// ���������򴫲Σ�ʹ��request
			request.setAttribute("empList", empList);
			//
			request.getRequestDispatcher("/emplist.jsp").forward(request, response);*/
			this.queryAllEmps(request, response);
			
		} else if ("del_emp".equals(flag)){
			// ɾ������Ҫ�����£�
			// ɾ���� ��ѯ��ɾ�����Ա��������ʾ
			
			// 1. ɾ��
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
			
			// 2. ��ѯ����Ա��
			// 3. ���Σ���ʾ��ѯ������Ա��
			
		} else if("query_by_id".equals(flag)){
			
			// ��ȡ�������
			String strEmpNo = request.getParameter("empno") == null ? "0" : request.getParameter("empno").trim();
			int empNo = Integer.parseInt(strEmpNo);
			
			// ��ѯԱ��
			Emp emp = empService.queryEmpById(empNo);
			
			// ����Ա������ת������ҳ��
			request.setAttribute("emp", emp);
			
			request.getRequestDispatcher("/update_emp.jsp").forward(request, response);
			
			
		} else if("updateEmpById".equals(flag)){
			// ����������
			String strEmpNo = request.getParameter("empno") == null ? "0" : request.getParameter("empno").trim();	// ����trim(), ���� NumberFormatingException. ��������empno�����ո�
			int empNo = Integer.parseInt(strEmpNo);
			
			String name = request.getParameter("name") == null ? "" : request.getParameter("name").trim();
			String job = request.getParameter("job") == null ? "" : request.getParameter("job").trim();
			
			String strSal = request.getParameter("sal") == null ? "0.0" : request.getParameter("sal").trim();
			double sal = Double.parseDouble(strSal);
			
			// ���ø��²���
			// ���²����Ĳ���
			Emp emp = new Emp(empNo, name, job, sal);
			// ִ�и���
			boolean result = empService.updateEmpById(emp);
			
			if(result == true){
				/*List<Emp> empList = empService.queryAllEmps();
				
				// ���������򴫲Σ�ʹ��request
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
	 * ��ѯ����Ա��
	 * 
	 * Ϊ�η���ֵ��void��������List<Emp>? ����Ҫ��
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
