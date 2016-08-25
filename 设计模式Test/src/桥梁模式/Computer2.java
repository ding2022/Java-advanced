package 桥梁模式;

//电脑类型维度
public class Computer2 {
	protected Brand brand; // 持有了品牌这个属性 它的子类天然具有品牌属性

	public Computer2(Brand b) {
		this.brand = b;
	}

	public void sale() {
		brand.sale();
	}
}

class Desktop2 extends Computer2 {

	public Desktop2(Brand b) {
		super(b);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售台式机");
	}

}

class Laptop2 extends Computer2 {

	public Laptop2(Brand b) {
		super(b);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售笔记本");
	}

}

class Pad2 extends Computer2 {

	public Pad2(Brand b) {
		super(b);
		System.out.println("销售平板");
	}
}