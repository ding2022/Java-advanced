package bestCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T1205 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			while (T-- != -1) {
				int n = in.nextInt();
				int k = 1;
				if (k-- >= 0) {
					String str = in.nextLine();
					String[] s = str.split(" ");
					Set<String> ss = new HashSet<String>();
					for (String j : s)
						ss.add(j);
					if (ss.size() >= n / 2) {
						System.out.println("Yes");
					} else {
						System.out.println("No");
					}
				}
			}
		}
		in.close();
	}
}
