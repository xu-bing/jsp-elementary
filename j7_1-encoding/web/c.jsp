<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'c.jsp' starting page</title>
    
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
    	// 传参前先编码
    	String username = "张三";
    	// URLEncoder : java.net
    	username = URLEncoder.encode(username, "UTF-8");
		
		// !! 传参时出现空指针异常
		// 原因： 传出的参数名  --- 接收的参数名不一致。
    	response.sendRedirect("b.jsp?username="+username);	// 加号前后不要有空格。
    %>
  </body>
</html>
