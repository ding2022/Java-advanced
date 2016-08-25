package ¸¨Öútest;

import java.util.Scanner;
public class JingDu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			double c=solve(a, b);
			
			System.out.println(suan(c));
		}
		in.close();
	}
	public static double suan(double n){
		n=n*1000;
		double k=0;
		if(n%10>=5){
			int a=(int) (n/10);
			k=(a+1)/100.;
		}else{
			int a=(int) (n/10);
			k=a/100.;
		}
		return k;
	}
	public static double solve(double n ,int m){
		double sum=n;
		while(m--!=1){
			sum+=Math.sqrt(n);
			n=suan(Math.sqrt(n));
		}
		return sum;
	}
}
