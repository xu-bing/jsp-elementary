<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'a.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		function sub(){
			// 跳转至 jsp
			//location.href = "b.jsp?username=location href 张三";
			// window.open("b.jsp?username=window open 张三");
			
			// 跳至servlet
			location.href="servlet/MyServlet?username=js脚本跳转";
			
			// 输出前: 不要重新编码
			// 接受的: 要重新编码,不管是jsp页面，还是servlet
		}
	</script>

  </head>
  
  <body>
  
 
  
  <!-- 1. /////////////////////////////////////////////////////////////////////// -->
  	<!-- jsp:forward -->
  	<!-- 传前：编码；接受：无-->
  	<%--
  	<%
  		request.setCharacterEncoding("UTF-8");
  	 %>
  	 --%>
  	
  	<%--
  	<!--至 jsp-->
  	<jsp:forward page="b.jsp">
  		<jsp:param name="username" value="张三" />
  	</jsp:forward>
	--%>
	 
  
  <!--2.==============================向servlet传递参数==================================== -->
  <!-- 注释掉上面的内容 -->
  <!-- jsp标签 -->
  	<%
  		request.setCharacterEncoding("UTF-8");

  		request.getParameterNames()
  	 %>
  
  <!-- /////////////////////////////////////////////////////////////////////// -->
  	<!-- 超链接 -->
  	<!-- 注意路径的写法 
  		参数值：没有双  引号，URL传参
  		
  		接受的要重新编码
  	-->
  	<a href="servlet/MyServlet?username=超链">超链传参</a>
	  
  <!-- /////////////////////////////////////////////////////////////////////// -->
  	<!-- 
  		form表单传参与超链传参是一回事，解决方法完全一样。
  		它与提交方法无关。
  		注意： 提交方式为post, 不要用get。
  		method不写，则默认为get。
  	 -->
  	 
  	 // action的地址： 如果是b.jsp，则应是b.jsp, 不是/b.jsp
  	<form action="servlet/MyServlet" method="post">
  		<input type="text" name="username"/><br>
		<input type="submit" value="提交">  		
  	</form>
  	
  <!-- /////////////////////////////////////////////////////////////////////// -->
  	<!-- JS脚本跳转 -->
  	<input type="button" value="跳转" onclick="sub()"/>
  
  </body>
</html>
