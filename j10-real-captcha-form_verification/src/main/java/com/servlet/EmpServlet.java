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
		
		//(1)��ѯԱ���������ܼ�¼����
		//ͳ��Ա������
		int count  = empService.countEmps();

		
		//��Ա���������浽request�������У�����empList.jspҳ�涯̬չʾ
		request.setAttribute("count", count);

		
		//(2)����Ա����¼������ÿҳ��С����ҳ�� ����ҳ����
		int pageSize = 3;			//ÿҳ��С
		//������ҳ��
		int pageCount = count % pageSize == 0 ? count/pageSize : count/pageSize+1;
		
		request.setAttribute("pageCount", pageCount);		// �����ҳ��
	
		//(3)��ѯָ��ҳ������
		//��ǰҳ��
		// �жϿ�ֵ
		int currentPage;
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//request.setAttribute("currentPage", currentPage);	// �����ڴ˴��棬��ᵼ������ĵ�ǰҳ���ܳ�����ʼ�����ķ�Χ��		
		// ------------------------------
		if(currentPage > pageCount){
			currentPage = pageCount;
		}
		if(currentPage <= 0){
			currentPage = 1;
		}	
		request.setAttribute("currentPage", currentPage);		// ��䵱ǰҳ��	
		// -------------------------------
		
		List<Emp> list = empService.queryEmps(currentPage, pageSize);		// currentPageֻҪ�����־��С����������ľ��н���������������ľ�Ϊnull��
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
