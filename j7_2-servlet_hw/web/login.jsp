<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 
    	base是页面的相对路径，
    	nowe: 相对路径已经是根路径了，所以action的servlet不要再加根路径了。
    
     -->
    
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
	path: <%=path %> <br>
	basePath: <%=basePath %>
  <hr>
  	<!-- 
  		action的路径：
  		LoingServlet:
  		servlet/LoginServlet:
  	 -->
  	
  	<%--
  	
  	<%
  		if(request.getAttribute("result") != null){
  	
  			boolean result = (Boolean)request.getAttribute("result");
  			if(result == false){
  	%>
	  			<script type="text/javascript">
					alert("此账号已登陆，请勿重复登录");
				</script>
  	<%	
  			}
  		}
  		
  	 %>
  	 
  	  --%>
  	  
  	<!-- 
  		exp: why servlet/LoginServlet前不要加反斜杠。
  		
  		servlet中传递标识位：在表单中通过hidden
  	 -->
	<form action="servlet/LoginServlet" method="get">
		<input type="hidden" name="flag" value="flag"/>
		用户：<input type="text" name="username"><br>
		密码：<input type="password" name="pwd"><br>
		<input type="submit" value="提交"/>
		<input type="reset" value="重置"/>
			
	</form>

  </body>
</html>
