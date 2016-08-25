<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
<title>修改信息</title>
</head>
<body>
<%
String sno = null;
sno = request.getParameter("sno");
%>
<div class="mform" align="left">
	
	<hr/>


	<p>修改学生</p>
	<form action="stuinfo_update_judge.jsp" method="post" name="form3">
	学号：<%=sno %><br/>
	<input type="hidden" name="sno" value="<%=sno %>"/>
	班级：<input type = "text" placeholder="班级" name="sclass"/><br/>
	姓名：<input type = "text" placeholder="姓名" name="sname"/><br/>
	性别：<input type = "radio" name="ssexy" value="男" checked="true"/>男
	<input type = "radio" name="ssexy" value="女"/>女<br/><br/>
	<input type = "submit" value="修改" name="submit" class="submitbtn"/>
	</form><br/>
</div>
<br/>
<div class="back">
<a href="stuinfo_main.html">返回</a>
</div>
</body>
</html>