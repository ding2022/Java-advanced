<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String uname="";
	Cookie[] cs =request.getCookies();
	if(cs!=null){
		for(Cookie c:cs){
			if("user".equals(c.getName())){
				uname=c.getValue();
			}
		}
	}

%>
<%
	String msg="";
	String mess=(String) request.getAttribute("msg");
	if(mess!=null){
		msg=mess;
	}
%>
<%=msg%>
<br>
<%
	String msg2="";
	String mess2=(String) request.getAttribute("msg2");
	if(mess2!=null){
		msg2=mess2;
	}
%>
<%=msg2%>
<form action="/JSP1/loginServlet" method="post">

	用户名：<input type="text" name="user" value="<%=uname%>"/><br>
	密码：<input type="password" name="pass"/><br>
	验证码：<input type="text" name="vcode">
	<img src="/JSP1/verifyCodeServlet">
	<br>
	<input type="submit" value="登录"/><br>
</form>

</body>
</html>