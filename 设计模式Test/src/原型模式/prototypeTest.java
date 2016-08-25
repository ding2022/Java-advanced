package 原型模式;

//被克隆对象 必须继承 Cloneable接口 
public class prototypeTest implements Cloneable {

	private String Name;
	private String age;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();  //此处实现了克隆 ，点进去源码可以发现这是一个 native方法 在object类中，即直接和核心c++打交道，
		//内存操作效率非常高  以此这个 模式的复制效率非常高 
		return obj;
	}
	
	public prototypeTest(String name,String age) {
		this.age=age;
		this.Name=name;
	}
	public prototypeTest() {
	}
}
