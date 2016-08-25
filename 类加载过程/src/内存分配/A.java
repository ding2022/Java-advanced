package 内存分配;
class A {
	public static String a;
	String b;
	static{
		System.out.println("我是A类的静态方法");
		System.out.println("A的静态属性 a "+a);
//		System.out.println("A的属性 b "+ b);
	}
	void testa(){
		System.out.println("A.testa()");
	}
	
	public A(String a) {
		this.a=a;
		System.out.println("A的属性 a "+this.a);
	}
	public A(){
		super();
	}
}
