<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'b.jsp' starting page</title>
    
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
   			// 接受jsp:forward
   		
   			//String username = request.getParameter("username");
   			// 如果 传过来的参数名 --- 接收的参数名 ： 不一致，则出现 null pointer。
   			// 如何避免
   			 String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();

			// ================================================================
   			// jsp标签传递过来的内容
   			// jsp: forward, jsp: include过来的的不需要重新编码，重新编码反而会出错。
   			
   			// js, response传过来的参数要重新编码
   			// Encodes this String into a sequence of bytes using the platform's default charset, 
   			// storing the result into a new byte array. 
   			username = new String(username.getBytes("ISO8859-1"), "UTF-8");
   			
   			out.println(username);
   		 %>
  </body>
</html>
