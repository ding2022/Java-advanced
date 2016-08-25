package WangYi;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
//		while (in.hasNext()) {
//		InputStream
//		Reader
//		Writer
			String ts = in.nextLine();
			int t = Integer.parseInt(ts);
			if (t <= 100)
				for (int i = 0; i < t; i++) {
					list.add(in.nextLine());
				}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(solve(list.get(i)));
			}
//		}
		in.close();
	}

	public static int solve(String line) {
		int n = 0;
		char[] p = { '9', '7', '0', '6' };
		char[] cl = line.toCharArray();
		int k = 0;
		int[] a = new int[4];
		boolean flag = true;
		if (cl.length <= 5000)
			while (flag) {
				flag = false;
				for (int i = 0; i < cl.length; i++) {
					if (cl[i] == p[k]) {
						a[k] = i;
						k++;
						if (k == 4) {
							flag = true;
							cl[a[0]] = '1';
							cl[a[1]] = '1';
							cl[a[2]] = '1';
							cl[a[3]] = '1';
							n++;
							k = 0;
						}
					}
				}
			}
		return n;
	}
}
