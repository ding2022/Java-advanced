package Singleton单例模式;
//单例模式指某个类智能有一个类，而且必须可以自行创建这个实例并向整个系统提供这个实例
public class 单例模式 {

	public static void main(String[] args) {
		Singleton object1=Singleton.getSingleton(); //调用这个唯一实例
		Singleton object2=Singleton.getSingleton(); //调用这个唯一实例
		
		System.out.println("用singleton类实现单例模式的实例如下");
		System.out.println("调用next（）方法前");
		System.out.println("object1.amount="+object1.getAmount());
		System.out.println("object1.amount="+object2.getAmount());
		
		object1.next();
		System.out.println("调用后");
		System.out.println("object1.amount="+object2.getAmount());
		System.out.println("object1.amount="+object1.getAmount());
		System.out.println("object1.amount="+object2.getAmount());
		
	}

}
class Singleton{
	private static int amount=5;//私有属性
	private static Singleton singleton=new Singleton();//唯一的类
	
	private Singleton(){//创建私有的构造函数 以防止外界构造
	}
	public static Singleton getSingleton(){ //通过此方法获取实例
		return singleton;
	}
	public synchronized int getAmount(){//线程同步 只允许一个线程进行访问
		return amount;
	}
	public synchronized void next(){
		amount++;
	}
}