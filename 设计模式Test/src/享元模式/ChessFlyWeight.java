package ��Ԫģʽ;

/**
 * ��Ԫ�� Χ��
 * 
 * @author feng
 *
 */
public interface ChessFlyWeight {
	void setColor(String color);

	String getColor();

	void display(Coordinate c);
}

class ConcreateChess implements ChessFlyWeight {

	private String color;

	public ConcreateChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("������ɫ��" + color);
		System.out.println("����λ�ã�" + c.getX() + "  " + c.getY());
	}

}