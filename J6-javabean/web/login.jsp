<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
  
  <body>
  
  	<%
  		Integer result = (Integer)request.getAttribute("result");
  		if(result != null){
  		
  			if(result == 0){
  	%>		
  				<script>
  					alert("账号或者密码错误，请重试!");
  				</script>
  	<% 
  			}else if(result == -1){
  			
  	%>
  				<script>
  					alert("请不要重复登录!");
  				</script>
  	<%		
  			}
  		}	
  	%>
  
    <form action="check.jsp" method="get">
    	账号：<input type="text" name="username" ><br>
    	密码：<input type="password" name="pwd"><br>
    	<input type="submit" value="登录">
    </form>
  </body>
</html>