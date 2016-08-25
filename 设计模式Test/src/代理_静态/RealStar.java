package 代理_静态;
//实现star接口  以方便客户调用这个接口
public class RealStar implements star{

	@Override
	public void bookmacket() {
		System.out.println("RealStar.bookmacket()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar(浩哥唱歌).sing()");
	}

	@Override
	public void getMoney() {
		System.out.println("RealStar.getMoney()");//此处要真的唱
	}

}
