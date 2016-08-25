package Singleton����ģʽ;
//����ģʽָĳ����������һ���࣬���ұ���������д������ʵ����������ϵͳ�ṩ���ʵ��
public class ����ģʽ {

	public static void main(String[] args) {
		Singleton object1=Singleton.getSingleton(); //�������Ψһʵ��
		Singleton object2=Singleton.getSingleton(); //�������Ψһʵ��
		
		System.out.println("��singleton��ʵ�ֵ���ģʽ��ʵ������");
		System.out.println("����next��������ǰ");
		System.out.println("object1.amount="+object1.getAmount());
		System.out.println("object1.amount="+object2.getAmount());
		
		object1.next();
		System.out.println("���ú�");
		System.out.println("object1.amount="+object2.getAmount());
		System.out.println("object1.amount="+object1.getAmount());
		System.out.println("object1.amount="+object2.getAmount());
		
	}

}
class Singleton{
	private static int amount=5;//˽������
	private static Singleton singleton=new Singleton();//Ψһ����
	
	private Singleton(){//����˽�еĹ��캯�� �Է�ֹ��繹��
	}
	public static Singleton getSingleton(){ //ͨ���˷�����ȡʵ��
		return singleton;
	}
	public synchronized int getAmount(){//�߳�ͬ�� ֻ����һ���߳̽��з���
		return amount;
	}
	public synchronized void next(){
		amount++;
	}
}