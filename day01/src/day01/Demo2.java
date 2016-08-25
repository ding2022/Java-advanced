package day01;

import java.util.Arrays;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int sum=0;
		for(int i=1;i<=100;i++)
			sum+=i;
		System.out.print("sum="+sum);
*/		String[] s=new String[]{"A","B","C","d"};
		int pos=Arrays.binarySearch( s, "d");
		System.out.println(pos);
	} 
}