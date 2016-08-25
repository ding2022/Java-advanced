package HDOJ;

import java.util.Scanner;

public class TH02 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		//int [] a=null;
		int num = 0;
		while(in.hasNext()){
			num=in.nextInt();
			System.out.println(solve(num)+"\n");
			/*a=new int[num];
			for(int i=0;i<num;i++){
				a[i]=in.nextInt();
			}
			break;*/
		}
		in.close();
		/*for(int i=0;i<num;i++){
			System.out.println(solve(a[i]));
		}*/
	}

	private static long solve(int i) {
		return (i+1)*i/2;
	}
}
