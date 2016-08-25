package 代理_动态;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{

	star realstar;
	StarHandler(star realstar){
		super();
		this.realstar=realstar;
	}
	
	//对真实角色的处理都在此方法中处理
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)//使用到了反射等内容
			throws Throwable {
		System.out.println("浩哥开始了");
		method.invoke(realstar, args);
		System.out.println("浩哥结束了");
		return null;
	}

}
