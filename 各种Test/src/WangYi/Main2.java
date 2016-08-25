package WangYi;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while (in.hasNext()) {
			String ts = in.nextLine();
			int t = Integer.parseInt(ts);
			for (int i = 0; i < t; i++) {
				System.out.println(solve(in.nextLine()));
			}
		}
	}
	public static int solve(String line){
		int n=0;
		char[] cl = line.toCharArray();
		int len=cl.length;
		for(int i=0;i<len;i++){
			if(true){
				
			}
		}
		
		return n;
	}
}
