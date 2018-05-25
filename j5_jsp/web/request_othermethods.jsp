<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'request_othermethods.jsp' starting page</title>
    
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
	 
  	 <%=request.getRequestURI() %><br>
  	 <%=request.getRequestURL() %><br>
  	 
  	 <%
  	 	// getHeader, getHeaderNames
  	 	
  	 	Enumeration enu = request.getHeaderNames();
  	 	
  	 	while (enu.hasMoreElements()){
  	 		String headerName = (String)enu.nextElement();
  	 		String header = request.getHeader(headerName);
  	 		out.println(headerName + ":\t" + header + "<br>");	
  	 	}
  	  %>
  
  </body>
</html>
