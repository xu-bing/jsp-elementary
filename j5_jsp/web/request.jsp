<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'request.jsp' starting page</title>
    
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
  	<!-- 
  		作用域：1存2跳3取	
  	 -->
  
  	<%	
  		request.setAttribute("username","tom");
  	 %>
  	 
  	 <!-- 1. --> 	 
  	 <%-- 
  	 	<%=request.getAttribute("username") %>
  	 --%>
  	 
  	 <!-- 2. -->
  	 <%--

  	 <jsp:forward page="request_scope.jsp"></jsp:forward>
  	 --%>
  	 <%-- 
  	 <%
  	 	// 服务器重定向
  	 	// 通过代码跳转
  	 	request.getRequestDispatcher("request_scope.jsp").forward(request, response);	
  	  %>
  	 --%>
  	 
	<!-- 3. -->
	<%
		// 浏览器端重定向
		response.sendRedirect("request_scope.jsp");
	 %>
  	 
  </body>
</html>
