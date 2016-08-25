<%@page import="org.eclipse.jdt.internal.compiler.ast.ThisReference"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- java代码片段 方法里面能写什么 这个就能写什么 -->
<%
	String path = request.getContextPath();//获取项目名
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<!-- 向页面输出basepath -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello
	<%
	int a = 10, b = 100;
	out.print("whats the fox say");
%>
	<!-- 此标签表示声明 ，此处声明了一个成员变量-->
	<%!int a = 100;%>
	<br>
	<!-- 此标签本身就相当于一个输出，与out.print()等价 -->
	<%=a + b%>
	<br>
	<%=this.a++%>


	<!-- 表格 -->
	<table border="5" align="center" width="60%">
		<tr>
			<td>姓名</td>
			<td>年龄</td>
		</tr>
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<tr>
			<td>浩哥</td>
			<td>18</td>
		</tr>
		<%
			}
		%>


	</table>

</body>
</html>