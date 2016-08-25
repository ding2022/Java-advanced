package 代理_动态;

import java.lang.reflect.Proxy;

public class client {
	public static void main(String[] args) {
		star realstar=new RealStar();
		
		//handler 代理接口 invoke
		StarHandler handler=new StarHandler(realstar);
		//生成代理类
		star proxyStar=(star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{star.class}, handler);

		//代理类调用真实类的方法
		proxyStar.bookmacket();
		proxyStar.sing();
	}

}
