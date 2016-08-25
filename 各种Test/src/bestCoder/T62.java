package bestCoder;

import java.util.Scanner;

public class T62 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			solve(a, b);
		}
		in.close();
	}

	private static void solve(int a, int b) {
		int k = 0;
		if (a < b&&b<1000000) {
			for (int i = a; i <= b; i++) {
				
				/*String s = i + "";
				if (s.contains("4") || s.contains("62")) {
					k++;
				}*/
				if(suan(i)){
					k++;
				}
			}
			System.out.println(b - a - k + 1);
		}else {
			System.out.println(0);
		}
	}
	private static boolean suan(int n){
		
		while(n!=0){
			int temp=n%10;
			n=n/10;
			if(temp==4){
				return true;
			}else if(temp==2&&n%10==6){
				return true;
			}
		}
		return false;
	}
}
