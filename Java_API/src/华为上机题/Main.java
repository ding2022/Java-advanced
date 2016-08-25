package 华为上机题;

import java.util.Scanner;

public class Main {
	static int max(int a[], int i, int j) {
		int max = a[i - 1];
		for (int s = i - 1; s < j; s++) {
			if (max < a[s])
				max = a[s];
		}
		return max;
	}

	public static void main(String[] args) {
		int N, M;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String[] NM = (scanner.nextLine()).split(" ");
			N = Integer.parseInt(NM[0]);
			M = Integer.parseInt(NM[1]);
			String grades[] = scanner.nextLine().split(" ");
			int[] grade = new int[grades.length];
			for (int i = 0; i < N; i++) {
				grade[i] = Integer.parseInt(grades[i]);
			}
			while (M-- > 0) {
				String string[] = (scanner.nextLine()).split(" ");
				int a, b;
				a = Integer.parseInt(string[1]);
				b = Integer.parseInt(string[2]);
				if (string[0].equals("Q")) {
					System.out.println(max(grade, a, b));
				}
				if (string[0].equals("U")) {
					grade[a - 1] = b;
				}
			}
		}
	}
}
