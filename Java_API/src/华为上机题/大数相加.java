package 华为上机题;

import java.math.BigInteger;

public class 大数相加 {

	public static void main(String[] args) {
		Way1();
		Way2();
	}

	public static void Way1() {
		BigInteger bigint = new BigInteger("1394789234987132412341234");
		BigInteger bigint2 = new BigInteger("132412341234");
		System.out.println(bigint.add(bigint2));
	}

	public static void Way2() {
		String a = "1073481351923487118246", b = "813251038134134123";
		char[] d = a.toCharArray(), e = b.toCharArray();
		int al = d.length, bl = e.length, all = al, bll = bl;
		int[] ac = new int[al], bc = new int[bl];

		while (al != 0) {
			al--;
			ac[al] = d[al] - '0';
		}
		while (bl != 0) {
			bl--;
			bc[bl] = e[bl] - '0';
		}
		if (all >= bll) {
			for (int i = 0; i < all; i++) {
				ac[i] += bc[i];
				if (ac[i] > 9) {
					ac[i] = ac[i] - 10;
					ac[i + 1]++;
				}
			}
		}
		for(int i=0;i<all;i++){
			System.out.println(ac[i]);
		}
	}
}
