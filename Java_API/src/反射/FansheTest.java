package ����;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ����.test.User;

/*
 * java������� Ϊjava�Ķ�̬���ṩ�˱���  ���java��һ��׼��̬����  ��c c++ǿ
 * java��̬�Բ�����Ҫ�� ����   һ���� ���� һ���� �ֽ������  
 * �������ʹ�ó�����֯ ��д������� 
 * ��spring stures �ȼܹ����淴���������  ʹ��Ӧ�ó���Ĺ������ӿ���
 * ���� �����Ч�ʲ���   ��Լ���������Ƶ�30�� 
 * ����ͨ������ ��ֹ���ͼ�� ����߷����Ч�� ����ܸĽ�4������
 * 
 * ����ͨ������ �������  ���� ���� ������ ʵ�������   
 * ����ͨ������ ��ע��Ƚ��ж�ȡ ����  �������е��� 
 * ��jvm�� �κ����� ������װ���� �� �������� ����һ����  Class ʵ�� 
 * forname����  class.getclass���� �ȷ��������Ի��һ�� Class ��ʵ��  һ����ֻ��һ��ʵ����Class
 * 
 * @authotr haofeng
 */
public class FansheTest {
	public static void main(String[] args) throws Exception {
		
		String path="����.User";
		Class clazz=Class.forName(path);
		
		Field[] fileds = clazz.getDeclaredFields();//��ȡȫ������ ����˽�е�����
		Field[] filedss = clazz.getFields(); //��ȡ public ���͵�����
		
		
		User u=(User) clazz.newInstance();//���һ��ʵ��������
		
		System.out.println();

		for(int i=0;i<fileds.length;i++){
			System.out.println(fileds[i]);
		}
		Method[] m1=clazz.getMethods();//��ȡ����
//		Method m2=clazz.getMethod(name, parameterTypes);

		Constructor[] constructor=clazz.getConstructors();//��ȡ���췽��
	
	}
}
