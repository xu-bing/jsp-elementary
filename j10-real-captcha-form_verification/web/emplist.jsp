<%@ page language="java" import="java.util.*, com.domain.*" pageEncoding="UTF-8"%>
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
	<meta http-equiv="Content-type" content="text/html;charset=gbk">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  <!-- datasource -->
  <%
  	//EmpService empService = new EmpService();
  	//List<Emp> empList = empService.queryEmps();
  	
  	List<Emp> empList = (List<Emp>)request.getAttribute("list");
   %>
   
  
  <!-- view -->
    <table border="1px">
    	<tr>
    		<td>编号</td>
    		<td>姓名</td>
    		<td>职务</td>
    		<td>薪水</td>
    	</tr>
    	
    	<!-- ////////////////////////////////////////////////////////////// -->
    	<%
    		for(Emp emp:empList){
    	 %>
    	 	
    	 	<tr>
    	 		<td><%=emp.getEmpno() %></td>
    	 		<td><%=emp.getEname() %></td>
    	 		<td><%=emp.getJob() %></td>
    	 		<td><%=emp.getSal() %></td>
    	 	</tr>
    	 	
    	 <%
    	 	}
    	  %>
    	  
    	  <!-- ///////////////////////////////////////////////////////// -->
    </table>
    
      <div>
     	<form action="servlet/EmpServlet" method="get">
     	当前页${currentPage}/${pageCount }&nbsp;
     	总记录数${count }&nbsp;
     	
     	<a href="servlet/EmpServlet?currentPage=1">首页</a>&nbsp;
     	<a href="servlet/EmpServlet?currentPage=${currentPage-1}">上一页</a>&nbsp;
     	<a href="servlet/EmpServlet?currentPage=${currentPage+1}">下一页</a>&nbsp;
     	<a href="servlet/EmpServlet?currentPage=${pageCount }">尾页</a>&nbsp;
     	跳转到<input type="text" name="currentPage" id="currentPageInput" size="5" onkeyup="value=value.replace(/[^\d]/g,'')" ><input type="submit" value="GO">
     	
     	</form>
     </div>
    
  </body>
</html>
