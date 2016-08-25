package ArrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class system_arraycopyTest {
	public static void main(String[] args) {
		int[] i=new int[7];
		int[] j=new int[10];
		
		Arrays.fill(i, 47);//fill方法 将数组i全部填为 47
		Arrays.fill(j, 99);
		
		c sssC=new c();
		ArrayList<Integer> a=new ArrayList<Integer>();
		
		
		a.sort(sssC);
		
		System.out.println("i = "+Arrays.toString(i));
		System.out.println("j = "+Arrays.toString(j));
		
		System.arraycopy(i, 0, j, 0, i.length);//迅速的复制数组 效率很高
		
		System.out.println("j = "+Arrays.toString(j));
		
		int[] k=new int[5];
		Arrays.fill(k, 103);
		
		System.arraycopy(i, 0, k, 0, k.length);
		
		System.out.println("k = "+Arrays.toString(k));
		
		Arrays.fill(k, 103);
		
		System.arraycopy(k, 0, i, 0, k.length);
		
		System.out.println("i = "+Arrays.toString(i));
	}
}
class c implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
