<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    
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
    	//先获得账号和密码
    	String username = request.getParameter("username");
    	String pwd = request.getParameter("pwd");
    	
    	List<String> nameList = (List<String>)application.getAttribute("nameList");
    	if(nameList != null && nameList.contains(username)){		// 已经登录
    	
    		request.setAttribute("result", -1);
    		request.getRequestDispatcher("login.jsp").forward(request,response);
    		
    	}else if(username.equals("tom") && pwd.equals("123")){		// 
    	
    		//List<String> usernames = new ArrayList<String>();
    		//usernames.add(username);
    		//List<String> usernames = (List<String>)application.getAttribute("namesList");
    		
    		if(nameList == null){								
    			nameList = new ArrayList<String>();
    		}
    		nameList.add(username);
    		application.setAttribute("nameList",nameList);
    		
    		session.setAttribute("username",username);
    		//验证通过，跳转到欢迎页面
    		request.getRequestDispatcher("welcome.jsp").forward(request,response);			
    	}else{
    		request.setAttribute("result",0);		// 账号或密码错误
    		request.getRequestDispatcher("login.jsp").forward(request,response);
    }
     %>
  </body>
</html>
