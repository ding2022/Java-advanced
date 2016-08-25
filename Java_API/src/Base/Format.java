package Base;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Formatter;
import java.util.Scanner;

public class Format {

	private static Formatter f = new Formatter(System.out);

	public static void main(String[] args) {
		String str = "haoge";
		int a = 100, c = 1000;
		// 1
		System.out.format("%s %d\n%d\n", str, a, c);
		// 2
		// f.format("%s %d\n%d", str,a,c);
		f.format("%s\n%-10d\n%-10d", str, a, c);
		// 3
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int e = in.nextInt(), f = in.nextInt();
			double g = in.nextDouble();
			System.out.format("%d  %d %f", e, f, g);
		}
		in.close();
		BufferedReader reader = new BufferedReader(new StringReader(
				"a,b\n,c,d\n"));
		try {
			while (reader.readLine() != null) {
				System.out.println(reader.read());
			}
			reader.close();
		} catch (Exception e) {

		}

	}
}