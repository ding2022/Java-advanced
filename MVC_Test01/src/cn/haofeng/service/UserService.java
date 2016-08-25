package cn.haofeng.service;

import cn.haofeng.dao.UserDao;
import cn.haofeng.domin.User;

public class UserService {
	private UserDao userDao=new UserDao();
	
	public User find(){
		return userDao.find();
	}
}
