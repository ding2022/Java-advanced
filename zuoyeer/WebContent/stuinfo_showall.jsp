<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
<title>All</title>


</head>
<body>
<%
String driver = "com.mysql.jdbc.Driver";
String url ="jdbc:mysql://localhost:3306/student";
//String url = "jdbc:mysql://localhost/stuinfos";
String userName = "root";
String password = "haofeng";

Connection conn = null;

String sql = null;
Statement stmt = null;

ResultSet rs = null;

try{
	Class.forName(driver);
}catch(ClassNotFoundException e) {
	out.println("加载驱动器类时出现异常");
}

try{
	
	conn = null;
	conn = DriverManager.getConnection(url,userName,password);
	
	stmt = conn.createStatement();
	
	sql="select * from student";
	
	rs = stmt.executeQuery(sql);
	%>

<div class="res">
	<form id="form3" name= "form3" action="#" method="post">
	<table class="allstutab">	
	<tr bgcolor="#6495ED">
	<th>选择</th><th >学号</th><th>班级</th><th>姓名</th><th>性别</th>
	</tr>
	
	<%
	while(rs.next()){
		String sno = rs.getString(1);
		String sclass = rs.getString(2);
		String sname = rs.getString(3);
		String ssex = rs.getString(4);				
		%>
		<tr bgcolor="#A1A1A1">
		<td><input type="radio" name="sno" value="<%=sno %>" checked="true"/></td>
		<td><%=sno %></td><td><%=sclass %></td><td><%=sname %></td><td><%=ssex %></td>		
		</tr>

<%
	}
rs.close();
stmt.close();
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

</table>
<input type="button" value="删除" onclick="del();" class="btn"/>
<input type="button" value="修改" onclick="upd();" class="btn"/>
</form>
<script type="text/javascript" language="JavaScript">
function del(){

	form3.action="stuinfo_delete.jsp";
	form3.submit();
}
function upd(){
	form3.action="stuinfo_update.jsp";
	form3.submit();
}
</script>

</div>
<br/>
<div class="back">
<a href="stuinfo_main.html">返回</a>
</div>
</body>
</html>