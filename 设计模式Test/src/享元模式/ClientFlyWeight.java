package 享元模式;
/**
 * 工厂很重要  对内部状态进行复用  对外部状态进行个自定义
 * @author feng
 *
 */
public class ClientFlyWeight {
	public static void main(String[] args) {
		ChessFlyWeight chess1=ChessFlyWeightFactory.getChess("hei");
		ChessFlyWeight chess2=ChessFlyWeightFactory.getChess("hei");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("增加外部处理");
		chess1.display(new Coordinate(10, 20));
		chess2.display(new Coordinate(20, 20));

	}
}
