package ����_��̬;

import java.lang.reflect.Proxy;

public class client {
	public static void main(String[] args) {
		star realstar=new RealStar();
		
		//handler ����ӿ� invoke
		StarHandler handler=new StarHandler(realstar);
		//���ɴ�����
		star proxyStar=(star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{star.class}, handler);

		//�����������ʵ��ķ���
		proxyStar.bookmacket();
		proxyStar.sing();
	}

}
