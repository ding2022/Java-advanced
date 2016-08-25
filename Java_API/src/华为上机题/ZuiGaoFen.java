package 华为上机题;

import java.util.Arrays;
import java.util.Scanner;

public class ZuiGaoFen {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
/*			int n = in.nextInt();
			String stringn=in.nextLine();
			int n=Integer.parseInt(stringn);
			
//			String stringm=in.nextLine();
//			int 
			int[] a = new int[n];
int m = in.nextInt();
*/
		while(in.hasNextLine()){
			String inputString[]=(in.nextLine()).split(" ");
			int n= Integer.parseInt( inputString[0]);
			int m= Integer.parseInt( inputString[1]);
//			for (int i = 0; i < n; i++) {
//				a[i] = in.nextInt();
				String[] string=(in.nextLine()).split(" ");
				int grades[]=new int[string.length];
				for(int ii=0;ii<grades.length;ii++)
				{
					grades[ii]=Integer.parseInt(string[ii]);
				}
//			}
			for (int i = 0; i < m; i++) {
//				System.out.println("hi");
				String s = in.nextLine();

				String[] data = s.split(" ");
				String c = data[0];
				int n1 = Integer.parseInt(data[1]);
				int n2 = Integer.parseInt(data[2]);
				if (c.equals("Q")) {
					System.out.println(maxnum(grades, n1-1, n2-1));
				} else if (c.equals("U")){
					grades[n1-1] = n2;
//					System.out.println(grades[n1-1]);
				}
//				System.out.println(Arrays.toString(grades));
			}}
		}	
	static int maxnum(int[] a, int s, int e) {
		int max = a[s];
		for (int i = s; i <= e; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}
}
