<%@ page language="java" import="java.util.*,java.sql.*,com.domain.*,com.service.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- 核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 格式化标签库 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emps.jsp' starting page</title>
    
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
	  		EmpService empService = new EmpService();
			List<Emp> empList = empService.queryAllEmps();	
  			
			request.setAttribute("empList", empList);
  		%>
  		
  		<table border="1px">
  			<tr>
  				<td>编号</td>
  				<td>姓名</td>
  				<td>职务</td>
  				<td>薪水</td>
  				<td>雇佣日期</td>
  			</tr>
  			
  			<%-- 
  			<%
  				for (Emp e : empList){
  			%>	
  			<tr>
  				<td><%=e.getEmpno() %></td>
  				<td><%=e.getEname() %></td>
  				<td><%=e.getJob() %></td>
  				<td><%=e.getSal() %></td>
  			</tr>
  				
  			<% 		
  				}
  			%>
  			--%>
  			
  			<c:forEach items="${empList }" var="emp" >
  				<tr>
  				<td>${emp.empno }</td>
  				<td>${emp.ename }</td>
  				<td>${emp.job }</td>
  				<td><fmt:formatNumber value="${emp.sal }" pattern="0.00"></fmt:formatNumber> </td>
  				<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy/MM/dd"/> </td>		
  			</tr>
  			</c:forEach>
  				
  		</table>
  		
  		
  	
  </body>
</html>
