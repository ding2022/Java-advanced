package ArrayTest;

import java.util.Arrays;
import java.util.Random;

public class Array_Method_Test {
	public static void main(String[] args) {
		int[] a = new int[10];
		int[] b = new int[2000];

		Arrays.fill(a, 100);
		//Arrays.fill(b, 40);
		Random rand=new Random();
		for(int i=0;i<2000;i++){
			b[i]=rand.nextInt()%1000;
		}
		System.out.println(Arrays.equals(a, b));//equals
		
		System.arraycopy(a, 0, b, 6, a.length);
		System.out.println("b = "+Arrays.toString(b));
		
		Arrays.sort(b);
		
		System.out.println("sort b = "+ Arrays.toString(b));
		
	}
}

