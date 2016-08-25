package WangYi;

import java.util.Scanner;

public class asdf{
	public static void main(String [] args){
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
//			int num=1;
			int m=n;
			for(int i=0;i<n-1;i++){
				m=(m++)*n;
			}
			System.out.println(m-n+1);
		}
		in.close();
	}
	/*public static int solve(int n){
		//int sum=0;
		//sum+=n;
		int i=1;
		if(i<=n)
		 n=(n+1)*n;
		return ;
	}*/
}