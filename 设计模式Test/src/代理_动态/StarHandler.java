package ����_��̬;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{

	star realstar;
	StarHandler(star realstar){
		super();
		this.realstar=realstar;
	}
	
	//����ʵ��ɫ�Ĵ����ڴ˷����д���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)//ʹ�õ��˷��������
			throws Throwable {
		System.out.println("�Ƹ翪ʼ��");
		method.invoke(realstar, args);
		System.out.println("�Ƹ������");
		return null;
	}

}
