package cn.itcast.demo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;

//使用jdbc对数据库增删改查
public class Demo4 {

	@Test
	public void insert(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into users(id,name,password,email,birthday) values(4,'xxx','123','xx@sina.com',to_date('1980-09-09','YYYY-MM-DD'))";
			int num = st.executeUpdate(sql);  //update
			if(num>0){
				System.out.println("插入成功！！");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	@Test
	public void delete(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "delete from users where id=4";
			st = conn.createStatement();
			int num = st.executeUpdate(sql);
			if(num>0){
				System.out.println("删除成功！！");
			}
		}catch (Exception e) {
			
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	@Test
	public void update(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "update users set name='wuwang',email='wuwang@sina.com' where id=3";
			st = conn.createStatement();
			int num = st.executeUpdate(sql);
			if(num>0){
				System.out.println("更新成功！！");
			}
		}catch (Exception e) {
			
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	@Test
	public void find(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where id=1";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				System.out.println(rs.getString("name"));
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
}
