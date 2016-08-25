package com.haofeng.JDBCutils;

import java.sql.*;

import javax.swing.JOptionPane;

public class ZSGC {
	
	public Statement getStmt(){
		Connection con;
		Statement stmt = null;
		try {
			con = JdbcUtils.getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法与数据库去的连接！\n请使用mysql数据库，并开启");
			e.printStackTrace();
		}
		return stmt;
	}

	public void insert() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = JdbcUtils.getConnection();
			stmt = con.createStatement();
			String sql = "";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(stmt, con, rs);
		}
	}

	public void delete() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtils.getConnection();
			stmt = con.createStatement();
			String sql = "";
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(stmt, con, rs);
		}
	}

	public void update() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtils.getConnection();
			stmt = con.createStatement();
			String sql = "";
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(stmt, con, rs);
		}
	}

	public void find() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtils.getConnection();
			stmt = con.createStatement();
			String sql = "";
			stmt.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(stmt, con, rs);
		}
	}
}
