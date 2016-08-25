package 基础习题;

import java.util.Scanner;

public class IsRuiNian {
	public static void main(String[] args) {
		System.out.println("输入年份");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int year = in.nextInt();
			boolean flag1 = year % 400 == 0;
			boolean flag2 = (year % 4 == 0) && (year % 100 != 0);

			String message = flag1 || flag2 ? "是闰年" : "不是闰年";

			System.out.println(year + " " + message);
		}
		in.close();
		//boolean i=isLeapYear(2013);
	}

}
