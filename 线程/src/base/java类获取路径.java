package base;

import java.io.File;

public class java类获取路径 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(java类获取路径.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(java类获取路径.class.getResource(""));
		
		System.out.println(java类获取路径.class.getResource("/"));
		System.out.println(new File("/").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
	}
}
