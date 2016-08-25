<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body background="image/back1.jpg" style="background-repeat:no-repeat">
<p>输入账户密码登入留言板</p>
<form action="mboard_login_judge.jsp" method="post">
<input type="text" name="account"/>
<p>
<input type="password" name="password"/>
<input type="submit" value="登录" name="Submit"/>

</form>


</body>
</html>