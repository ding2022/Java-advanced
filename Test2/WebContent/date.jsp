<%@ page language="java" pageEncoding="GB18030"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>time</title>
</head>
<body>
	<%
		Date now=new Date();
		String dateStr;
		dateStr=String.format("%tY年%tm月%td日",now,now,now);
	%>
	当前日期是：<%=dateStr %>
	<br>
</body>
</html>