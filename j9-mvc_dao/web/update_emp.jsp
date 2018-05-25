<%@ page language="java" import="java.util.*,com.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update_emp.jsp' starting page</title>
    
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
  	
	<form action="servlet/EmpServlet" method="post">
		<input type="hidden" name="empno" value="${emp.empNo }" />
		<!-- <input type="hidden" name="empno" value="${emp.empNo }" /> -->
		<!-- 
		<input type="text" name="empno" readonly="readonly" value="5" />
		 -->
		姓名：<input type="text" name="name" value="${emp.name }"/> <br>
		职位：<input type="text" name="job"	value="${emp.job }"/> <br>
		薪水：<input type="text" name="sal"	value="${emp.sal }"/> <br>
		<input type="hidden" name="flag" value="updateEmpById" />
		<input type="submit" value="保存"/>
		<input type="reset" value="重置" />
	</form>

  </body>
</html>
