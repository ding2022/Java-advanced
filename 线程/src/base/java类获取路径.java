package base;

import java.io.File;

public class java���ȡ·�� {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(java���ȡ·��.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(java���ȡ·��.class.getResource(""));
		
		System.out.println(java���ȡ·��.class.getResource("/"));
		System.out.println(new File("/").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
	}
}
