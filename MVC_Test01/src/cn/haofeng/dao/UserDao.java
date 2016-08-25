package cn.haofeng.dao;

import cn.haofeng.domin.User;
/**
 * 查询到的结果封装到 user中
 * @author hao.feng
 *
 */
public class UserDao {
	public User find(){
		return new User("haha", "lala");
	}
}
