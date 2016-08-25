package 华为上机题;

import java.util.Scanner;

//重复字符串
public class T02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			if(str.equals(null))
				System.out.println("空");
			solve2(str);
			boolean flag = false;
			char[] charStr = str.toCharArray(), output = charStr;

			int len = charStr.length;

			for (int i = 0; i < len - 1; i++) {
				for (int j = 0; j < len - 1 && j != i; j++) {
					if (output[j] == charStr[i]
							&& output[j + 1] == charStr[i + 1]) {
						flag = true;
						int k = i;
						while (output[k++-1] == charStr[k++-1] && k < len) {
							System.out.println(charStr[k-1]);
						}
						break;
					}
					// output[i]=charStr[i];
				}
			}
			if (flag) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
		in.close();
	}

	public static void solve2(String input) {
		String str = null;
		int len = input.length();
		for (int i = 1, j = 2; i < len - 2; i++) {
			if (i + j < len) {
				str = input.substring(i, i + j);
				while (input.contains(str)) {
					// System.out.println(1);
					// System.err.println("重复字符串为"+str);
					j++;
					if(i+j<=len){
						str = input.substring(i, i + j);
					}
				}
			}
		}
		System.out.println(str);
	}
}
