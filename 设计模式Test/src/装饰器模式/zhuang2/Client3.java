package װ����ģʽ.zhuang2;

public class Client3 {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();

		System.out.println("�����¹���");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		System.out.println("ˮ���ε�car");
		WaterCar waterCar = new WaterCar(car);
		waterCar.move();
		
		System.out.println("������Ϻ�ĳ�����������");
		
		AICar aiCar=new AICar(waterCar);
		aiCar.move();
	}
}
