package ����ģʽ;

public interface Brand {
	void sale();
}

class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("�������");
	}
	
}
class Dell implements Brand{

	@Override
	public void sale() {
		System.out.println("��������");
	}
	
}
class ShenZhou implements Brand{

	@Override
	public void sale() {
		System.out.println("���۵���");
	}
	
}