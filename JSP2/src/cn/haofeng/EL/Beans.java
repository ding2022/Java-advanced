package cn.haofeng.EL;

public class Beans {
	public String a;
	public String b;
	public String c;
	
	public Beans(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Beans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Beans [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
