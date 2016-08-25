package 代理_静态;

public class Test02 {
	public static void main(String[] args) {
		star realStar=new RealStar();
		star proxy=new ProxyStar(realStar);
		
		//客户只知道代理  不知道真实对象  安全 方便
		proxy.bookmacket();
		proxy.sing();
		proxy.getMoney();
	}
}
