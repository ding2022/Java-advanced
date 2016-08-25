package Adapter适配器模式;

//adapter适配器模式就是改变接口的性质  使一些接口不兼容的类 可以兼容相互工作
public class Adapter {
	public static void main(String[] args) {
		benTian bTia = new benTian();
		bTia.setColor("red");
		bTia.setSpeed(100);
		bTia.display();
		bTia.move();

		AudiAdapter audi = new AudiAdapter();
		audi.setColor("black");
		audi.setSpeed(10000);
		audi.display();
		audi.move();
	}
}

interface Car {
	public void setColor(String color);

	public String getColor();

	public void setSpeed(int speed);

	public int getSpeed();

	public void move();

	public void display();
}

class benTian implements Car {
	String color;
	int speed;

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void move() {
		System.out.println("benTia " + 3 * speed);
	}

	@Override
	public void display() {
		System.out.println(color);
	}
}

class Audi {
	String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void display() {
		System.out.println(color);
	}
}

class AudiAdapter implements Car {
	private Audi audi;
	private int speed;

	public AudiAdapter() {
		audi = new Audi();
	}

	@Override
	public void display() {
		audi.display();
	}

	@Override
	public String getColor() {
		return audi.getColor();
	}

	@Override
	public void setColor(String color) {
		audi.setColor(color);
	}

	// 此处为扩展部分
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void move() {
		System.out.println("aodi " + 3 * speed);
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}