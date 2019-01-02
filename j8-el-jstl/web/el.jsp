<%@ page language="java" import="java.util.*,com.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'scope.jsp' starting page</title>
    
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
    <%--el表达式取作用域中的值--%>

    <%
    	String str = "tom";

		pageContext.setAttribute("username", "tom");
    	pageContext.setAttribute("age", 20);
    	request.setAttribute("age", 21);
    	session.setAttribute("age", 22);
    	application.setAttribute("age", 23);


    %>
	<%=str%>

    ${str } <!-- 返回：空字符串，因为它取作用域中的值-->

    ${username } 
    ${username1 } 	<!-- 属性不存在，其值显示为空字符串 -->
    
    <br>
    ${age }
    ${pageScope.age }
    ${requestScope.age }
    ${sessionScope.age }
    ${applicationScope.age }
    
    <!-- ////////////////////////////////////////////////////// -->
    <!-- 表单 -->
    <form action="scope_receiver.jsp">
    	性别：<input type="text" name="gender"><br>
    	爱好：<input type="checkbox" name="hobby" value="music">音乐
    		  <input type="checkbox" name="hobby" value="movie">电影 <br>
    	<input type="submit" value="提交"> 	
    </form>
    
    <!-- ////////////////////////////////////////////////////// -->
    <%
		// javabean
    	User user = new User("tom", 20);
    	request.setAttribute("user", user);
    	

    	// list
    	List<String> nameList = new ArrayList<String>();
    	nameList.add("tom");
    	nameList.add("jack");
    	nameList.add("jerry");
    	
    	request.setAttribute("nameList", nameList);

    	// map
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("username", "tom");
    	map.put("age", 20);
    	map.put("birthdate", new Date());
    
    	request.setAttribute("userMap", map);

    	// 作业：复杂对象
    	User user1 = new User("tom", 20, new Account(1500));
    	Map map0 = new HashMap();
    	map0.put("height", 193);
    	map0.put("weight", 160);
    	user1.setAttrMap(map0);
    	
    	User user2 = new User("jack", 21, new Account(1600));
    	Map map1 = new HashMap();
    	map1.put("height", 180);
    	map1.put("weight", 120);
    	user2.setAttrMap(map1);
    	
    	List<User> userList = new ArrayList<User>();
    	userList.add(user1);
    	userList.add(user2);
    	
    	request.setAttribute("userList", userList);
    %>
    
    
    <jsp:forward page="target.jsp"></jsp:forward>
    
  </body>
</html>
