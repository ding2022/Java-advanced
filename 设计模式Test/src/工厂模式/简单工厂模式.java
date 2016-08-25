package 工厂模式;
//工厂模式是提供创建对象的接口 相当于 new 关键字
//创建一个接口  有若干个类继承此接口    当要使用若干各类的时候   不需要再一个个new了     创建一个简单工厂类   在工厂类里面 根据不同的
//条件来生成相应的实例 高效简洁清晰
//但是要扩展时 必须修改源代码  违反了开闭原则
public class 简单工厂模式 {
	public static void main(String[] args) {
		try{
			Person person=PanDuan.findWork("H");
			System.out.println("工作经历");
			person.experence();
			Person person1=PanDuan.findWork("M");
			System.out.println("工作经历");
			person1.experence();
			Person person2=PanDuan.findWork("L");
			System.out.println("工作经历");
			person2.experence();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
interface Person{
	public void experence();
}

class PanDuan{
	public static Person findWork(String string)throws Exception{
		if(string.equals("L")){
			return new Low_Prommer();
		}else if(string.equals("M")){
			return new Mid_Prommer();
		}else if(string.equals("H")) {
			return new High_Prommer();
		}else {
			throw new Exception();
		}
	}
}

class Low_Prommer implements Person{
	public void experence() {
		System.out.println("我是新手");
	}
}
class Mid_Prommer implements Person{
	public void experence() {
		System.out.println("我中等水平");		
	}
}
class High_Prommer implements Person{
	public void experence() {
		System.out.println("我是高手");
	}
}