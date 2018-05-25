<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- 引入jstl核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jst.jsp' starting page</title>
    
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
   		request.setAttribute("username", "tom");
   	%>
   	
   	${username }
   	<c:out value="${username }"></c:out>
   	
   	<!-- 给变量赋值 -->
	<c:set scope="request" var="age" value="25"></c:set>
	<c:out value="${age }"></c:out>   
	
	<!-- c:if -->	
   	<c:if test="${age < 20}">
   		年纪太小了
   	</c:if>
   	
   	<!-- c:choose when otherwise -->
   	<c:choose>
   		<c:when test="${age < 19 }">
   			年龄太小了
   		</c:when>
   		<c:when test="${age >= 19 && age < 22 }">
   			正在上大学
   		</c:when>
   		<c:otherwise>
   			该成家了
   		</c:otherwise>		
   	</c:choose>
   	
   	<!-- c:forTokens -->
   	<c:set var="users" value="tom,jack,smith"></c:set>
   	<c:forTokens items="${users }" delims="," var="name">
   		<c:out value="${name }"></c:out>
   	</c:forTokens>
   	
   	
  </body>
</html>
