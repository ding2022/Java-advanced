package 装饰器模式.zhuang2;

/**
 * 抽象组件
 * 
 * @author feng
 *
 */

public interface ICar {
	void move();
}

// 真实构件
class Car implements ICar {

	@Override
	public void move() {
		System.out.println("陆地上跑");
	}

}
//装饰角色
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
		System.out.println("天上飞");
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}
//具体装饰角色
class WaterCar extends SuperCar{

	public WaterCar(ICar car) {
		super(car);
	}
	public void swim(){
		System.out.println("水里游");
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
		System.out.println("自动跑");
	}
	@Override
	public void move() {
		super.move();
		auroRun();
	}
}