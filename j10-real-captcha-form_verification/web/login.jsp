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
	<form action="servlet/UserServlet" method="get"> 
		用户：<input type="text" name="username" /> <br>
		密码：<input type="password" name="pwd" /> <br>
		验证码：<input type="text" name="captcha" />
		 	   <img id="captcha" src="servlet/CAPTCHAServlet" />
		
		<a href="javascript:void(0)" onclick="refreshCAPTCHA()">看不清楚，重换一张</a>
		<input type="button" value="刷新" onclick="refreshCAPTCHA()" />

		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
		<br>
		<img id="captcha" src="0.jpg" />
	</form>
	
	<script type="text/javascript">
		function refreshCAPTCHA(){
			// 获得图片对象
			var captcha1 = document.getElementById("captcha");
			
			// 修改属性值
			// captcha1.src = "0001.jpg";
			captcha1.src = "servlet/CAPTCHAServlet?t=" + Math.random();
			// alert("good");
		}
	</script>

  </body>
</html>

<!-- 
	超链接，如果href=""，则其onclick事件不会起作用，它会直接进行跳转。
	用void(0)，就是阻止其执行默认的跳转动作。
	
	测试：
	href=""，再href="javascript:void(0)"
 -->
