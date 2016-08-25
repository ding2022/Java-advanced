package cn.haofeng.javaBean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtils_test {
	@Test
	public void fun1() throws Exception{
		String className="cn/haofeng/javaBean/userBean".replace("/", ".");
		Class clazz=Class.forName(className);
		Object bean=clazz.newInstance();
		
		BeanUtils.setProperty(bean, "name", "zhangsan");
		BeanUtils.setProperty(bean, "gender", "nan");
		BeanUtils.setProperty(bean, "age", "12");
		
		System.out.println(bean);
	}
	/**
	 * 把map的属性封装到javabean中
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void fun2() throws IllegalAccessException, InvocationTargetException{
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "zhangsan2");
		map.put("gender", "nv");
		map.put("age", "14");
		
		userBean user=new userBean();
		BeanUtils.populate(user, map);
		
		System.out.println(user);
	}
}
