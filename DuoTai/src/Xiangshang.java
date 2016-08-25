public class Xiangshang {
	public static void play(Cycle c){
		//System.out.println("aa");
		c.play();
	}
	public static void main(String[] args) {
		Uncycle u=new  Uncycle();
		Bicycle bicycle=new Bicycle();
		Tricycle tricycle=new Tricycle();
		play(u);
		play(bicycle);
		play(tricycle);
	}
}
