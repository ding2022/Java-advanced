package ����ģʽ;
//����ģʽ���ṩ��������Ľӿ� �൱�� new �ؼ���
//����һ���ӿ�  �����ɸ���̳д˽ӿ�    ��Ҫʹ�����ɸ����ʱ��   ����Ҫ��һ����new��     ����һ���򵥹�����   �ڹ��������� ���ݲ�ͬ��
//������������Ӧ��ʵ�� ��Ч�������
//����Ҫ��չʱ �����޸�Դ����  Υ���˿���ԭ��
public class �򵥹���ģʽ {
	public static void main(String[] args) {
		try{
			Person person=PanDuan.findWork("H");
			System.out.println("��������");
			person.experence();
			Person person1=PanDuan.findWork("M");
			System.out.println("��������");
			person1.experence();
			Person person2=PanDuan.findWork("L");
			System.out.println("��������");
			person2.experence();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
interface Person{
	public void experence();
}

class PanDuan{
	public static Person findWork(String string)throws Exception{
		if(string.equals("L")){
			return new Low_Prommer();
		}else if(string.equals("M")){
			return new Mid_Prommer();
		}else if(string.equals("H")) {
			return new High_Prommer();
		}else {
			throw new Exception();
		}
	}
}

class Low_Prommer implements Person{
	public void experence() {
		System.out.println("��������");
	}
}
class Mid_Prommer implements Person{
	public void experence() {
		System.out.println("���е�ˮƽ");		
	}
}
class High_Prommer implements Person{
	public void experence() {
		System.out.println("���Ǹ���");
	}
}