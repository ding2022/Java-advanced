package bestCoder;

import java.util.Scanner;

public class T01_360 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int T=in.nextInt();
			for(int i=0;i<T;i++){
				String str=in.nextLine();
				String[] s=str.split(" ");
				int n=Integer.parseInt(s[0]);
				int m=Integer.parseInt(s[1]);
				int [] a=new int[m];
				int [] b=new int[m];
				for(int j=0;j<m;j++){
					String str1=in.nextLine();
					String[] s1=str.split(" ");
					a[j]=Integer.parseInt(s[0]);
					b[j]=Integer.parseInt(s[1]);
				}
				
			//	solve();
			}
		}
	}
}
