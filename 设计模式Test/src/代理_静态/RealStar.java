package ����_��̬;
//ʵ��star�ӿ�  �Է���ͻ���������ӿ�
public class RealStar implements star{

	@Override
	public void bookmacket() {
		System.out.println("RealStar.bookmacket()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar(�Ƹ糪��).sing()");
	}

	@Override
	public void getMoney() {
		System.out.println("RealStar.getMoney()");//�˴�Ҫ��ĳ�
	}

}
