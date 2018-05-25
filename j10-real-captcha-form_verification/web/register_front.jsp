<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
		function verify(){
			
		//	boolean result = checkUsername();	// register.jsp:75 Uncaught SyntaxError: Unexpected identifier 
		var result = checkUsername();
		var result1 = checkAge();
			
		return result && result1;
		
		}	// verify
		
		
		function checkUsername(){
			var username = document.getElementById("username").value;
			var usernameMsg = document.getElementById("usernameMsg");
			
			if(username == null || username == ""){
				usernameMsg.innerHTML = "姓名不能为空！"
				usernameMsg.style.display = "inline";
				
				return false;
			} else if (username.length > 10){
				usernameMsg.innerHTML = "姓名长度不能大于10！"
				usernameMsg.style.display = "inline";
				
				return false;
			} else {
				usernameMsg.style.display = "none";
				
				return true;
			}
		}	// checkUsername()
		
		function checkAge(){
			var age = document.getElementById("age").value;
			var ageMsg = document.getElementById("ageMsg");
			
			if(age == null || age == ""){
				ageMsg.innerHTML = "年龄不能为空！"
				ageMsg.style.display = "inline";
				
				return false;
			} else if (age > 100 || age < 1){
				ageMsg.innerHTML = "年龄必须在1-100之间！"
				ageMsg.style.display = "inline";
				
				return false;
			} else {
				ageMsg.style.display = "none";
				
				return true;
			}
		
		}	// checkAge()
		
		function checkMobile(){
			var mobile = document.getElementById("mobile").value;
			var mobileMsg = document.getElementById("mobileMsg");
			//var reg = /^1[3|4|5|8]\d{9}$/;
			 var reg = new RegExp(/^1[3|4|5|8]\d{9}$/);	// 2nd写法
			
			if(mobile == null || mobile == ""){
				mobileMsg.innerHTML = "手机号码不能为空！"
				mobileMsg.style.display = "inline";
				
				return false;
			} else if(!reg.test(mobile)){
				mobileMsg.innerHTML = "号码格式不对！"
				mobileMsg.style.display = "inline";
				
				return false;
			} else {
				mobileMsg.style.display = "none";
				
				return true;
			}
		}	// checkMobile
	
		
	</script>

  </head>
  
  <body>
	<form action="" method="post" onsubmit="return verify()">
		用户：<input type="text" id="username" name="username" onblur="checkUsername()"/>
			<span id="usernameMsg" style='color:red;display:none'></span>
			<br>
		年龄：<input type="text" id="age" name="age" onblur="checkAge()"/>
			<span id="ageMsg" style='color:red;display:none'></span>
			<br>	
		手机：<input type="text" id="mobile" name="mobile" onblur="checkMobile()"/>
			<span id="mobileMsg" style='color:red;display:none'></span>
			<br>	
		<input type="submit" value="提交" />
		
	</form>


  </body>
</html>
