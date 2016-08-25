package 工厂模式;
//创建一个可提供创建对象的接口 由其子类决定实现哪一个对象 去掉了简单工厂模式中工厂方法的静态属性
public class 工厂方法模式 {
	public static void main(String[] args) {
		Forms forms=new shanxi();//在接口里面有相应的约束 实例化到类中 就自然联系起来了
		meet meet1=forms.place();
		
		meet1.form();
	}
}
interface meet{
	public void form();
}
interface Forms{
	public meet place();
}
class jiudian implements meet{
	@Override
	public void form() {
		System.out.println("jiudian");
	}
}
class jia implements meet{
	@Override
	public void form() {
		System.out.println("jia ");
	}
}
class shanxi implements Forms{
	@Override
	public meet place() {
		return new jiudian();
	}
}
class weinan implements Forms{
	@Override
	public meet place() {
		// TODO Auto-generated method stub
		return new jia();
	}
}