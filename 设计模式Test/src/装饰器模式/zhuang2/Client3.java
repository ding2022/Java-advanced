package 装饰器模式.zhuang2;

public class Client3 {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();

		System.out.println("增加新功能");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		System.out.println("水里游的car");
		WaterCar waterCar = new WaterCar(car);
		waterCar.move();
		
		System.out.println("增加组合后的车，两个功能");
		
		AICar aiCar=new AICar(waterCar);
		aiCar.move();
	}
}
