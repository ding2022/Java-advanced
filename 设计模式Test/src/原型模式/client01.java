package 原型模式;

public class client01 {
	public static void main(String[] args) throws Exception {
	
		prototypeTest pp=new prototypeTest("haoge",13+"");
		System.out.println(pp);
		System.out.println(pp.getName());
		System.out.println(pp.getAge());
		
		prototypeTest dp=(prototypeTest) pp.clone();
		System.out.println(dp);
		System.out.println(dp.getName());
		System.out.println(dp.getAge());
		
		dp.setName("lala");
		System.out.println(dp.getName());
	}
	
}
