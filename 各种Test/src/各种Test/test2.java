package 各种Test;

import java.util.Scanner;


public class test2 {
	public test2() {
		System.out.println("haha");
	}
	protected void name() {
		System.out.println("鎴戞槸protected鏂规硶鐨勫鍑�");
	}
	private void mian() {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int a=in.nextInt();
			int b=in.nextInt();
			System.out.println(a+b);
		}

	}
}
