import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DuQu {

	public static void main(String[] args) throws Exception {

		String url="jdbc:mysql://localhost:3306/day14";
		String username="root";
		String password="haofeng";
		
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=	DriverManager.getConnection(url,username,password);
	
		Statement statement= connection.createStatement();
		
		String sql="select id,name,password,email,birthday from users";
		ResultSet rSet=	statement.executeQuery(sql);
		
		while(rSet.next()){
			System.out.println(rSet.getObject("id")+"");
			System.out.println(rSet.getObject("name")+"");
			System.out.println(rSet.getObject("password")+"");
			System.out.println(rSet.getObject("email")+"");
			System.out.println(rSet.getObject("birthday")+"");
		}
		rSet.close();
		statement.close();
		connection.close();
	}

}
