package 自定义类加载器;

public class ClassLoaderTest extends ClassLoader{
	//
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);
		//查找是否家再过此类
		if(c!=null){
			return c;
		}else {
			//获得了appclassloader
			ClassLoader parentClassLoader=this.getParent();
			c=parentClassLoader.loadClass(name);
			if(c!=null){
				return c;
			}else {
				byte[] classData=getClassData(name);
				if(classData==null){
					throw new ClassNotFoundException();
				}else {
					c=defineClass(name, classData,0,classData.length);
				}
			}
			
		}
		return c;
	}
	private byte[] getClassData(String classname){
//		String path=
		byte[] a=new byte[10];
		return a;
	}
}
