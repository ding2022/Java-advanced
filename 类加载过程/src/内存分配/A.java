package �ڴ����;
class A {
	public static String a;
	String b;
	static{
		System.out.println("����A��ľ�̬����");
		System.out.println("A�ľ�̬���� a "+a);
//		System.out.println("A������ b "+ b);
	}
	void testa(){
		System.out.println("A.testa()");
	}
	
	public A(String a) {
		this.a=a;
		System.out.println("A������ a "+this.a);
	}
	public A(){
		super();
	}
}
