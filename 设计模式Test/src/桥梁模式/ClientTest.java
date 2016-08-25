package 桥梁模式;

public class ClientTest {
	public static void main(String[] args) {
		//销售联想笔记本
		Computer2 c=new Laptop2(new Lenovo());
		c.sale();
		Computer2 d=new Desktop2(new Dell());
		d.sale();
		Computer2 e=new Pad2(new ShenZhou());//先加载 pad2 类 输出平板 再加载 神州类  调用sale方法后 输出神州电脑
		//此为组合方法
		e.sale();
	}
}
