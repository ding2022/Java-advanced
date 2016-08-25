<%@page import="cn.haofeng.EL.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String name="ll";

	request.setAttribute(name, "request");
	pageContext.setAttribute(name, "pageContext");
	application.setAttribute(name, "application");
	session.setAttribute(name, "session");
	Beans bean=new Beans("aa","bb","cc");
	pageContext.setAttribute("cc", bean);
%>
<a href="${pageContext.request.contextPath }/EL/el.jsp">点击这里</a>
${fn:length("aaa") }
${fn:contains("aaa","b") }
${requestScope.ll }
${ll }
${cc }
${cc.a }
</body>
</html>