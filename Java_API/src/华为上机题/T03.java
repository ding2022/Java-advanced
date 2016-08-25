package 华为上机题;

import java.util.Scanner;

public class T03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str1 = in.nextLine(), str2 = in.nextLine();
			solve(str1, str2);
			solve2(str1, str2);
		}
		in.close();
	}

	private static void solve(String str1, String str2) {
		int a = Integer.parseInt(str1), b = Integer.parseInt(str2);
		System.out.println("solve1: " + a * b);
	}

	private static void solve2(String str1, String str2) {
		System.out.println("solve2: "+fenjie(str1) * fenjie(str2));
	}

	private static int fenjie(String a) {
		int len = a.length(), c, s = 0, n = 1;
		char[] b;
		b = a.toCharArray();
		for (int i = len-1; i >=0; i--) {
			c = b[i] - '0';
			s += c * n;
			n *= 10;
		}
		return s;
	}
}
