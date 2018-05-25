<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
      java脚本	
     -->
    <%
    	// string
    	String str = "HelloWorld 你好";
    	out.println(str);
    	out.println("<br>");
    	
    	// number
    	int i = 1;
    	out.println(i + 1);
    	
    	// date
    	Date d = new Date(); 
    	out.println(d);
    	
    	// bool
    	out.println(true);
    	
    	// loop
    	int sum = 0;
    	for (int j = 1; j <= 100; j++){
    		sum += j;
    	}
    	out.println(sum);
     %>
     
     <br>
     
     <%-- 表达式 --%>
     字段：<%=str %>
     <%=i+1  %>
     <%=d.getDate() %>
     <%="tom" %>
     
     
    <%-- jsp声明--%>
     <%!
     	public String name;
     	
     	public void test(){}
     	
     	public class Test{}
    
      %>
    
  </body>
</html>
