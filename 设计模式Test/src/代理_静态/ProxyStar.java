package ����_��̬;

public class ProxyStar implements star{
	private star Star;
	
	ProxyStar(star Star){	//�˴������γɶ���ʵ����ĵ���
		super();
		this.Star=Star;
	}

	@Override
	public void bookmacket() {
		System.out.println("ProxyStar.bookmacket()");
	}

	@Override
	public void sing() {
		Star.sing();
	}

	@Override
	public void getMoney() {
		System.out.println("ProxyStar.getMoney()");
	}
}
