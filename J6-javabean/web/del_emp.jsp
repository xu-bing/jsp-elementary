<%@ page language="java" import="java.util.*, com.service.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'del_emp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
  <body>
  	<%
  		// 获取输入参数
  		int empno = Integer.parseInt(request.getParameter("empno"));
  		
  		// 调用服务
  		EmpService empService = new EmpService();
  		
  		boolean result = empService.deleteEmp(empno);
  		
  		if(result == true){
  			//request.getRequestDispatcher("emplist.jsp").forward(request, response);	// URL地址栏：del_emp.jsp页面，刚被删除的那个。
  			response.sendRedirect("emplist.jsp");
  			
  		}else{
  			// when 会出错？
  			//  使用 request.getRequestDispatcher....时，当删除了一个员工后
  			// URL地址栏中的显示是仍是刚被删除掉的员工，直接在地址栏中回车执行，就会出错（该员工不存在。）
  			response.sendRedirect("error.jsp");
  		}
  		
  	 %>
  </body>
</html>
