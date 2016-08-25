package WangYi;

import java.util.Scanner;

public class Test333 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] ss = str.split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			int c = Integer.parseInt(ss[2]);
			int d = Integer.parseInt(ss[3]);

			System.out.println(solve(a) + solve(b) + solve(c) + solve(d));
		}
		in.close();
	}

	public static int solve(int n) {
		int sum = n;
		while (n != 0) {
			n = n / 2;
			sum += n * 2;
		}
		return sum;
	}
}
