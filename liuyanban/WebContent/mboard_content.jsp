<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%!int MsgCount=0; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content</title>
</head>
<body background="image/back1.jpg" style="background-repeat:no-repeat">
<hr/>


<%
String account = request.getParameter("account");
String content = request.getParameter("content");

if(account.length()>0 && content.length()>0){
	
	MsgCount += 1;
	String AccountName = "account"+MsgCount;
	String ContentName = "content"+MsgCount;

	application.setAttribute(AccountName,account);

	application.setAttribute(ContentName,content);

	application.setAttribute("MsgCount",""+MsgCount);
}

if(account == null || content == null){
	%>
	<jsp:forward page="errorPage.jsp"></jsp:forward>
	<%
}
	%>
	<jsp:forward page="mboard_main.jsp"></jsp:forward>
</body>
</html>