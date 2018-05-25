<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  		<!-- 
    	base是页面的相对路径，
    	nowe: 相对路径已经是根路径了，所以action的servlet不要再加根路径了。
    	 -->
  		<!-- action后接url-pattern, 不是servletname -->
  		<form action="servlet/LoginServlet2" method="get">	
  			<input type="hidden" name="flag" value="login"/>
  			用户：<input type="text" name="username"/><br>
  			密码：<input type="text" name="pwd"/ ><br>
  			<input type="submit" value="提交">
  			<input type="reset" value="重置"/>
  		</form>
  <body>
   	
  </body>
</html>
