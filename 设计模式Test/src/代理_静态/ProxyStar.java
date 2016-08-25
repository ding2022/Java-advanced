package 代理_静态;

public class ProxyStar implements star{
	private star Star;
	
	ProxyStar(star Star){	//此处可以形成对真实对象的调用
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
