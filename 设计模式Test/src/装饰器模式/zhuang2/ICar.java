package װ����ģʽ.zhuang2;

/**
 * �������
 * 
 * @author feng
 *
 */

public interface ICar {
	void move();
}

// ��ʵ����
class Car implements ICar {

	@Override
	public void move() {
		System.out.println("½������");
	}

}
//װ�ν�ɫ
class SuperCar implements ICar {
	protected ICar car;

	public SuperCar(ICar car){
		super();
		this.car=car;
	}
	@Override
	public void move() {
		car.move();
	}

}
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
	}
	public void fly(){
		System.out.println("���Ϸ�");
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}
//����װ�ν�ɫ
class WaterCar extends SuperCar{

	public WaterCar(ICar car) {
		super(car);
	}
	public void swim(){
		System.out.println("ˮ����");
	}
	@Override
	public void move() {
		super.move();
		swim();
	}
}

class AICar extends SuperCar{

	public AICar(ICar car) {
		super(car);
	}
	public void auroRun(){
		System.out.println("�Զ���");
	}
	@Override
	public void move() {
		super.move();
		auroRun();
	}
}