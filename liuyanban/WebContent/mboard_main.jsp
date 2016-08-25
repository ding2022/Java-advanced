<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浩氏留言板</title>
<%!int count=0; %>

<%!String account; %>
<%
request.setCharacterEncoding("utf-8");
account = request.getParameter("account");
if(account == null){
	account = "";
}
if(account.length()<=0){
	%>
	<jsp:forward page="mboard_login.jsp"></jsp:forward>
	<%
}else{
	if(session.getAttribute("account") == null){
		application.setAttribute("count",++count);
	}
	session.setAttribute("account",account);
} 
%>
</head>
<body background="image/back1.jpg" style="background-repeat:no-repeat">

<p>欢迎留言 <%=account%></p>

<hr/>
<form action="mboard_content.jsp" method="post">
<textarea name="content" cols="30" rows="7">
</textarea>
<br/>
<input type="submit" name="submit" value="留言"/>
<p>你是第<%=application.getAttribute("count")%>个访问本网站的用户</p>
<input type="hidden" name="account" value="<%=account %>"/>
</form>
<hr/>
<%!int msgCount=0; %>

<%
Object ObjMsgCount=application.getAttribute("MsgCount");
if(ObjMsgCount != null){
	String StrMsgCount = ObjMsgCount.toString();
	int msgCount =  Integer.parseInt(StrMsgCount);

	while(msgCount >0){
		Object Objaccount = application.getAttribute("account"+msgCount);
		Object Objcontent = application.getAttribute("content"+msgCount);
		out.print(Objaccount.toString()+":");
		out.print(Objcontent.toString()+"<hr/>");
		msgCount--;
	}
}

%>


</body>
</html>