package exte;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.SocketChannel;

public class C extends B {
	public void test() {
		System.out.println("C.test()");
	}
	public C() throws NoSuchMethodException, SecurityException {
		super.test();
		super.test1();
		super.getClass().getMethod("test", null);
	}
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IOException {
		new C();
		SocketChannel channel=SocketChannel.open();
//		Class aa=Class.forName("A");
//		Class parameterTypes;
//		Method mtest=aa.getMethod("test", aa);
	}
}
