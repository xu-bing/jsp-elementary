<%@ page language="java" import="java.util.*,com.service.*, com.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emplist.jsp' starting page</title>
    
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
  		//EmpService empService = new EmpService();
  		//List<Emp> empList = empService.queryAllEmps();
  		
  		List<Emp> empList = (List<Emp>)request.getAttribute("empList");
  	 %>
  	 
  	 ${empList }
  	
  	
  	<table border="1px">
  		<tr>
  			<td>编号</td>
  			<td>姓名</td>
  			<td>职务</td>
  			<td>薪水</td>
  			<td>操作</td>
  		</tr>
  		
  	<%
  		for (Emp emp : empList){
  	%>
  		<tr>
  			<td><%=emp.getEmpNo() %></td>
  			<td><%=emp.getName() %></td>
  			<td><%=emp.getJob() %></td>
  			<td><%=emp.getSal() %></td>
  			<td><a href="servlet/EmpServlet?flag=del_emp&empno=<%=emp.getEmpNo() %>">删除</a>
  				<a href="servlet/EmpServlet?flag=query_by_id&empno=<%=emp.getEmpNo() %>">更新</a>
  			</td>
  		</tr>
  	<%	
  		}
  	 %>
  		
  	</table>
  </body>
</html>
