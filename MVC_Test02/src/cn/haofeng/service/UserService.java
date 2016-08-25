package cn.haofeng.service;

import cn.haofeng.Dao.UserDao;
import cn.haofeng.domin.User;

public class UserService {
	private UserDao userDao=new UserDao();
	
	public void regist(User user) throws UserException{
		User _user = userDao.findByUserName(user.getUname());
		if(_user!=null){
			throw new UserException("<h1>用户名 <font color='red'>"+user.getUname()+" </font>已经被注册了<h1>");
		}else {
			userDao.addUser(user);
		}
	}
	
	public void login(){
		
	}
}