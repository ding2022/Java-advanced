package 华为上机题;

import java.util.Scanner;

public class 进制转换 {

	public static void main(String[] args) {
		System.out.println("计算相应数字进制数字的和\n输入");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			String input1 = in.next(), input2 = in.next();
			System.out.println(StringToNum(input1, n) + StringToNum(input2, n));
		}
		in.close();
	}

	public static long StringToNum(String input, int n) {
		char[] inputToChar = input.toCharArray();
		int len = inputToChar.length;
		int num = 0, WeiZhi = 1;
		for (int i = len - 1; i >= 0; i--) {
			int bit = inputToChar[i];
			int numPerBit;
			if (n <= 9 && n >= 2) {
				if (bit - 48 >= 0 && bit - 48 <= n) {
					numPerBit = bit - 48;
				} else {
					System.out.println(-1);
					break;
				}
			} else if (n >= 10 && n <= 35) {
				if (bit - 48 <= 9 && bit - 48 >= 0) {
					numPerBit = bit - 48;
				} else if (bit - 87 > 10 && bit - 87 <= n) {
					numPerBit = bit - 87;
				} else {
					System.out.println(-1);
					break;
				}
			} else {
				System.out.println(-1);
				break;
			}
			// System.out.println(numPerBit);
			num += numPerBit * WeiZhi;
			WeiZhi *= n;
		}
		return num;
	}
}
