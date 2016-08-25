package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import 反射.test.User;

/*
 * java反射机制 为java的动态性提供了保障  因此java是一门准动态语言  比c c++强
 * java动态性操作主要有 两种   一个是 反射 一个是 字节码操作  
 * 反射机制使得程序组织 编写更加灵活 
 * 在spring stures 等架构里面反射大量运用  使得应用程序的构建更加快速
 * 但是 反射的效率不高   大约是正常机制的30倍 
 * 可以通过设置 禁止类型检查 来提高反射的效率 大概能改进4倍以上
 * 
 * 可以通过反射 获得属性  类名 方法 构造器 实例化类等   
 * 可以通过反射 对注解等进行读取 操作  方法进行调用 
 * 在jvm中 任何类型 包括封装类型 和 基本类型 都是一个类  Class 实现 
 * forname方法  class.getclass（） 等方法都可以获得一个 Class 类实例  一个类只有一个实例化Class
 * 
 * @authotr haofeng
 */
public class FansheTest {
	public static void main(String[] args) throws Exception {
		
		String path="反射.User";
		Class clazz=Class.forName(path);
		
		Field[] fileds = clazz.getDeclaredFields();//获取全部属性 包括私有的属性
		Field[] filedss = clazz.getFields(); //获取 public 类型的属性
		
		
		User u=(User) clazz.newInstance();//获得一个实例化的类
		
		System.out.println();

		for(int i=0;i<fileds.length;i++){
			System.out.println(fileds[i]);
		}
		Method[] m1=clazz.getMethods();//获取方法
//		Method m2=clazz.getMethod(name, parameterTypes);

		Constructor[] constructor=clazz.getConstructors();//获取构造方法
	
	}
}
