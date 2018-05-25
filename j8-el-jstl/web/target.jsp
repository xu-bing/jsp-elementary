<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'scope_receiver.jsp' starting page</title>
    
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
    	
    	${age }
    	<hr>
    	<!-- /////////////////////////////////// -->
    	${param.gender }
    	${paramValues.gender }
    	${paramValues.gender[0] }
    	
    	${paramValues.hobby }
    	${paramValues.hobby[1] }
    	<hr>
    	<!-- /////////////////////////////////// -->
    	<!-- javabean
    		 对象.属性名
    	 -->
    	${user }
    	${user.username }
    	<hr>
    	<!-- /////////////////////////////////// -->
    	<!-- list 
    		 [下标]
    	-->
    	${nameList }
    	${nameList[1] }
    	<hr>
    	
    	<!-- /////////////////////////////////// -->
    	<!-- map 
    		 a:: [键的名称]
    		 b:: .键的名称
    	-->
    	${userMap }
    	${userMap["username"] }
    	${userMap.age }
    	${userMap.birthdate }
    	<hr>
    	
    	<!-- /////////////////////////////////// -->
    	${userList}
    	${userList[1]}
    	${userList[1].username }
    	${userList[1].account.money }
    	${userList[1].attrMap["height"] }
    	
  </body>
</html>
