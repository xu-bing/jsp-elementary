<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'compute.jsp' starting page</title>
    
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
		request.setAttribute("max","9");
		request.setAttribute("min",6);
	%>
	
	${max + min }
	${max - min }
	${max < min }
	${max > 7 && min < 7}


    <%--ex--%>
	<%
		request.setAttribute("max", 9);
		request.setAttribute("min", 5);

		request.setAttribute("num", "5");
		request.setAttribute("num1", "6.0");

		request.setAttribute("str", "string0");
		request.setAttribute("str1", "string1");

		request.setAttribute("trueval", true);
		request.setAttribute("falseval", false);
	%>

	<%--
		四则运算，逻辑运算。	// 只举这个示例
	--%>
	${4+3 }	<%-- => 7--%>
	${max-min }
	${max > 7 && min < 6 }

	<%--
        四则运算时，运算的值可以直接是数值，或是数值型字符串。
    --%>
	${num + num1 }

	<%--
        不可进行字符串拼接
        java.lang.NumberFormatException: For input string: "string0"

        ${str+str1 }
    --%>

	<%--
        运算的式子可以是布尔值
    --%>
	${trueval && falseval }
  </body>
</html>
