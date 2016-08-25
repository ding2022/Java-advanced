package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoXmlImpl;
import cn.itcast.domain.User;

public class UserDaoTest {
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setId("22222");
		user.setUsername("bbbb");
		user.setPassword("123");
		user.setEmail("bb@sina.com");
		user.setBirthday(new Date());
		
		UserDao dao = new UserDaoXmlImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind(){
		
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("bbbb","123");
		System.out.println(user);
	}
	
	@Test
	public void testFindByUsername(){
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("ssss");
		System.out.println(user);
	}
	
}
