<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add</title>
</head>
<body>

<%
String driver = "com.mysql.jdbc.Driver";
//String url = "jdbc:mysql://localhost/stuinfos";
//String url ="jdbc:mysql://ip:3306:stuinfos";
String url ="jdbc:mysql://localhost:3306/student";
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



if(sno.length()<=0 || sclass.length()<=0 || sname.length()<=0 || ssexy.length()<=0 ){
	%>
	<jsp:forward page="errorPage.jsp"></jsp:forward>	
	<%
}

try{
	Class.forName("com.mysql.jdbc.Driver");
}catch(ClassNotFoundException e) {
	out.println("加载驱动器类时出现异常");
}

try{
	
	conn = null;
	conn = DriverManager.getConnection(url,"root","haofeng");
/*
	//PreparedStatement方法发生异常 Unknown system variable 'tx_read_only'
	
	sql = "insert into student(sno,sclass,sname,ssexy) values(?,?,?,?)";
	
	PreparedStatement pstmtInsert = conn.prepareStatement(sql);
	out.print(sno+sclass+sname+ssexy+"--------<br/>");
	pstmtInsert.setString(1,sno);
	pstmtInsert.setString(2,sclass);
	pstmtInsert.setString(3,sname);
	pstmtInsert.setString(4,ssexy);
	pstmtInsert.executeUpdate();
	out.print("#######"+sno+sclass+sname+ssexy+"--------<br/>");	
	pstmtInsert.close();
*/


	sql = "insert into student values('"+sno+"','"+sclass+"','"+sname+"','"+ssexy+"'"+")";

	stmt = conn.createStatement();
	int affectRowCount = stmt.executeUpdate(sql);
	if(affectRowCount == 1){
		out.print("已经成功添加学生："+sname+"<br/>");
	}else{
		out.print("添加失败");
	}

%>


<%
}catch(SQLException e) {
	out.println("连接数据库的过程中出现SQL异常2");
	e.printStackTrace();
}finally {	//关闭语句和数据库连接
		try {
			if (conn != null) conn.close();
		} catch(SQLException e) {
  			out.println("关闭数据库连接时出现异常");
		} 
}
%>
<br/><br/><a href="stuinfo_main.html">返回</a>
</body>
</html>