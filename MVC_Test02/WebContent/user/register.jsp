<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registe</title>
</head>
<body>
	<h1>注册</h1>
	<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
	用户名：<input type="text" name="uname"/><br>
	密     码：<input type="password" name="upass"/><br>
	验证码：<input type="text" name="vcode"/><br>
	<img id="vecode" src="${pageContext.request.contextPath }/verfiycodeServlet">
	<a href="${pageContext.request.contextPath }/verfiycodeServlet">看不清</a>	
	<input type="submit" value="注册"/>	<br><br>
	
	${msg }
	</form>
</body>
</html>