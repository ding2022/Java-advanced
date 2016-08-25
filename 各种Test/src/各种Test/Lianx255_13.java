package 各种Test;



public class Lianx255_13 extends text{
	private static int i;
	public Lianx255_13() {
		super(i);
	}
	public static void main(String[] args){
		//int a=3;
		//text nText=new text();
		//super.create(a);
		//super鍏抽敭瀛楁寚鐨勬槸璋冪敤鐖剁被鐨勬瀯閫犳柟娉�
		//nText.create(a);
		//super();
		Lianx255_13 nLianx255_13=new Lianx255_13();
		
		
	}
	//@Override
	public void create(Double a) {
		super.create(a);
	}
}
class text extends test2{
	public text() {
		super();
		create();
		//System.out.println("aaa");
	}
	text(int a){
		super();
		System.out.println(a);
	}
	public void create(int a){
		System.out.println(a);
	}
	public void create(Double a){
		System.out.println(a);
	}
	public void create(){
		System.out.println("haha");
	}
	
}