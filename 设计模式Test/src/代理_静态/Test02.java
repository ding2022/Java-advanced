package ����_��̬;

public class Test02 {
	public static void main(String[] args) {
		star realStar=new RealStar();
		star proxy=new ProxyStar(realStar);
		
		//�ͻ�ֻ֪������  ��֪����ʵ����  ��ȫ ����
		proxy.bookmacket();
		proxy.sing();
		proxy.getMoney();
	}
}
