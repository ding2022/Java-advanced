<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("code", "<script>alert('hello');</script>");
%>
<c:out value="${code }"></c:out>
<!-- 转译  默认为true 即不转译 -->
<c:out value="${code }" escapeXml="false"></c:out>
<!-- 设置属性 -->
<c:set var="arr" value="lalal" scope="request"></c:set>
<c:out value="${arr }"></c:out>
<c:out value="${code }" escapeXml="false"></c:out>
<!-- 移除属性 -->
<c:remove var="arr"/>
<!-- url标签 -->
<c:url value="/index.jsp">
<c:param name="username" value="zhangsan"/>
</c:url>

<!-- if标签 -->
<c:if test="${empty arr }">
	<c:out value="asdf"/>
</c:if>

<c:choose>
	<c:when test="${score>100 }">cuowu</c:when>
	<c:when test="${score>100 }">cuowu</c:when>
	<c:when test="${score>100 }">cuowu</c:when>
	<c:otherwise>abaf</c:otherwise>
</c:choose>
<!-- foreach 标签 -->
<c:forEach var="i" begin="1" end="10" step="2">
	${i }<br>
</c:forEach>
<%
	String[] strs={"one","two"};
	request.setAttribute("strs", strs);
%>
<c:forEach items="${strs }" var="str">
${str }<br>
</c:forEach>

<c:forEach var="item" items="${strs }" varStatus="vs">
	${vs.index } ${vs.count } ${vs.first } ${vs.last } ${vs.current }<br>
</c:forEach>
<!-- fmt格式化标签 -->
<%
	Date date=new Date();
	request.setAttribute("date", date);
%>
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>