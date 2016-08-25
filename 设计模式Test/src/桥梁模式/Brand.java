package 桥梁模式;

public interface Brand {
	void sale();
}

class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("联想电脑");
	}
	
}
class Dell implements Brand{

	@Override
	public void sale() {
		System.out.println("戴尔电脑");
	}
	
}
class ShenZhou implements Brand{

	@Override
	public void sale() {
		System.out.println("神舟电脑");
	}
	
}