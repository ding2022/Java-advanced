package cn.itcast.utils;

import java.io.InputStream;
import java.util.Properties;

import cn.itcast.dao.UserDao;

public class DaoFactory {
	
	private  UserDao userdao = null;
	
	private DaoFactory(){
		try{
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			String daoClassName = prop.getProperty("userdao");
			userdao = (UserDao)Class.forName(daoClassName).newInstance();
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final DaoFactory instance = new DaoFactory();
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	
	public UserDao createUserDao(){
		return userdao;
	}
	
}
