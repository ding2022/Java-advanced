package com.haofeng.JDBCutils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

public class JdbcUtils {
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	static{// static �����   �������� ��Ȼ����� ����Ȼ���������
		try {
		InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");//ͨ��������� �����ļ���Դ
		Properties prop=new Properties();
		
			prop.load(in);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			
			Class.forName(driver);
		
		} catch (Exception e2) {
			throw new ExceptionInInitializerError();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(url,username,password);
	}
	
	public static void release(Statement stmt,Connection con,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
