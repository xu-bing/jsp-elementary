<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%-- 
    <%=path %> <br>
    <%=basePath %><br>
    --%>
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  
  <body onload="parent.location.href='login.jsp'">
	<form action="servlet/LoginServlet">
		<input type="hidden" name="flag" value="login" />
		用户：<input type="text" name="username" /> <br>
		密码：<input type="pwd" name="pwd"/> <br>
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
  </body>
</html>