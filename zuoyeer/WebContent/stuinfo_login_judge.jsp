<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Judge</title>
</head>
<body>
<%
String userName = null;
String password = null;
userName = request.getParameter("username");
password = request.getParameter("password");

if(userName.equals("root") && password.equals("root")){
	

	%>
	
		<jsp:forward page="stuinfo_main.html">
		<jsp:param value="<%=userName %>" name="userName"/>
		</jsp:forward>
	<%
	
}else{
	%>
	<jsp:forward page="errorPage.jsp"></jsp:forward>
	<%
}
%>
</body>
</html>