package ��Ԫģʽ;
/**
 * ��������Ҫ  ���ڲ�״̬���и���  ���ⲿ״̬���и��Զ���
 * @author feng
 *
 */
public class ClientFlyWeight {
	public static void main(String[] args) {
		ChessFlyWeight chess1=ChessFlyWeightFactory.getChess("hei");
		ChessFlyWeight chess2=ChessFlyWeightFactory.getChess("hei");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("�����ⲿ����");
		chess1.display(new Coordinate(10, 20));
		chess2.display(new Coordinate(20, 20));

	}
}
