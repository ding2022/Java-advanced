package ¸¨Öútest;

import java.util.Scanner;

public class ShuXian {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			boolean flag = false;
			for (int i = a; i <= b; i++) {
				if (solve(i)) {
					flag = true;
					System.out.print(i + " ");
				}
			}
			if (flag) {
				System.out.println();
			} else {
				System.out.println("no");
			}

		}
	}

	private static boolean solve(int n) {
		if (n < 100 || n > 999) {
			return false;
		}
		int a = n / 100;
		int b = n / 10 % 10;
		int c = n % 10;
		if (a * a * a + b * b * b + c * c * c == n) {
			return true;
		}
		return false;
	}
}
