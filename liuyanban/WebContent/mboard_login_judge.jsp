<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>judge</title>
</head>
<body background="image/back1.jpg" style="background-repeat:no-repeat">
<%
request.setCharacterEncoding("UTF-8");
String account = request.getParameter("account");
String password =request.getParameter("password");
if(account == null&&password==null){
	account = "";
}
if(account.length()<=0){
	%>
	<jsp:forward page="errorPage.jsp"></jsp:forward>
	<%
}else{
	%>
	<jsp:forward page="mboard_main.jsp">
	<jsp:param value="<%=account %>" name="account"/>	
	</jsp:forward>
	<%
%>
<%--
Enumeration enu = request.getParameterNames();
while(enu.hasMoreElements()){
	String parameterName = (String) enu.nextElement();
	String parameterValue = (String) request.getParameter(parameterName);
	out.print("参数名称："+parameterName+"<br/>");
	out.print("参数内容："+parameterValue+"<br/>");
	out.flush();
}
--%>
<%
}
%>

</body>
</html>