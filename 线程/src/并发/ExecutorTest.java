package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//�߳�ִ����
public class ExecutorTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();// ����һ��ִ����
		for (int i = 0; i < 5; i++) {
			exec.execute(new threadTest());
		}
		exec.shutdown();
//		String s="a s f d h l a s d f";
//		String[] ss = s.split(" ");
//		ArrayList<String> list=(ArrayList<String>) Arrays.asList(ss);
//		Iterator iterator=(Iterator) list.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
//		System.out.println();
	}
}

class threadTest implements Runnable {
	private int num;

	@Override
	public void run() {
		System.out.println("  " + num++);
	}

}