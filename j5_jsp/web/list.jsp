<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  	<%-- data source --%>
  	<%
  		List empList = new ArrayList();
  		empList.add("tom");
  		empList.add("jerry");
  		empList.add("jack");
  		empList.add("john");
  	 %>
  	
  
  	<%-- view --%>
  	<b>人员信息</b>
  	<table border="1px">
  		<tr>
  			<td>序号</td>
  			
  			
  			<td>姓名</td>
  		</tr>
  		
  		<!-- ///////////////// -->
  		<%
  			for (int i = 0; i < empList.size(); i++){
  		 %>
  			<tr>
	  			<td><%=i + 1 %></td>
	  			<td><%=empList.get(i) %></td>
  			</tr>
  		<%
  		}
  		%>
  		<!-- //////////////// -->
  				
  	</table>
  	
  </body>
</html>
