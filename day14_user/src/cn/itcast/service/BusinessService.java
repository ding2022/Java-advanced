package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface BusinessService {

	//提供注册服务
	void registerUser(User user) throws UserExistException;

	User loginUser(String username, String password);

}