package Ա����Ϣ����;

//not useful
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class JDBCPIMS {

	public static void main(String[] args)throws Exception {
		//String DBDriver ="jdbc:mysql://localhost:3306/person";//����
		//String con="jdbc:odbc:person";
		//String DBDriver="org.gjt.mm.mysql.Driver";
		//String con="jdbc:mysql://127.0.0.1:3306/person?useUnicode=true&characterEncoding=gbk ;";
		//String DBDriver="com.mysql.jdbc.Driver()";
		String con="jdbc:mysql://localhost:3306/person";
		Connection connection=null;
		Statement stmt =null;
		ResultSet rs=null;
		//Class.forName(DBDriver).newInstance();//�����������ڴ�
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//����ע�᷽ʽҲ����
		connection=DriverManager.getConnection(con,"root","haofeng");
		
		stmt=connection.createStatement();
		rs= stmt.executeQuery("Select * from name");
		while(rs.next()){
			System.out.println(rs.getInt("num")+"");
			System.out.println(rs.getString("name")+"");
		}
		stmt.close();
		connection.close();
	}
}
