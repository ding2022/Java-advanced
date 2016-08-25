<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
<%
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/student";
String userName = "root";
String password = "haofeng";

Connection conn = null;

String sql = null;
Statement stmt = null;

String sno =null;
String sclass = null;
String sname = null;
String ssexy = null;



sno = request.getParameter("sno");
sclass = new String(request.getParameter("sclass").getBytes("iso-8859-1"),"utf-8");
sname = new String(request.getParameter("sname").getBytes("iso-8859-1"),"utf-8");
ssexy = new String(request.getParameter("ssexy").getBytes("iso-8859-1"),"utf-8");


if(sno.length()<=0){
	%>
	<jsp:forward page="errorPage.jsp"></jsp:forward>
	<%	
}

try{
	Class.forName(driver);
}catch(ClassNotFoundException e) {
	out.println("加载驱动器类时出现异常");
}

try{
	
	conn = null;
	conn = DriverManager.getConnection(url,userName,password);
	
	stmt = conn.createStatement();
	sql = "update student set sclass='"+sclass+"',sname='"+sname+"',ssexy='"+ssexy+"' "+"where sno="+"'"+sno+"'";
	int affectRowCount = stmt.executeUpdate(sql);
	if(affectRowCount == 1){
		out.print("成功修改学号为"+sno+"的学生<br/>");
		out.print("学号："+sno+"<br/>");
		out.print("班级："+sclass+"<br/>");
		out.print("姓名："+sname+"<br/>");
		out.print("性别："+ssexy+"<br/>");
	}else{
		out.print("修改失败");
	}

%>



<%
}catch(SQLException e) {
	out.println("连接数据库的过程中出现SQL异常");
	
}finally {	//关闭语句和数据库连接
		try {
			if (conn != null) conn.close();
		} catch(SQLException e) {
  			out.println("关闭数据库连接时出现异常");
		} 
}
%>


<br/>
<div class="back">
<a href="stuinfo_main.html">返回</a>
</div>
</body>
</html>