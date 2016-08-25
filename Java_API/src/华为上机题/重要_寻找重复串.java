package 华为上机题;

import java.util.Scanner;

public class 重要_寻找重复串 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input = in.nextLine();
			// quick(input, "qwe");
			// System.out.println(input);
			maxString(input);
		}
		in.close();
	}

	private static void quick(String input, String sub) {
		int len = input.length(), num = 0;
		System.out.println(sub+" 出现位置 ");
		for (int i = 0; i < len - 1; i++) {
			if (input.regionMatches(false, i, sub, 0, sub.length())) {
				num++;
				System.out.println(i);
			}
		}
		if (num > 1) {
			System.out.println(sub + " 出现次数 " + num);
		}
	}

	private static String subString(int begin, int end, String input) {
		StringBuilder builder = new StringBuilder();
		for (int i = begin; i <= end; i++) {
			builder.append(input.charAt(i));
		}
		return builder.toString();
	}

	public static void containStr(String input, String subStr) {
		int len1 = input.length(), len2 = subStr.length();
		int num = 0;
		// boolean flag;
		for (int i = 0; i < len1 - len2 + 1; i++) {
			if (subString(i, i + len2 - 1, input) == subStr) {
				// System.out.println(i);
				if (num++ > 1) {
					System.out.println(subStr + ":" + i);
				}
			}
			/*
			 * flag=true; for(int j=0;j<len2;j++){ 核心算法
			 * if(subStr.indexOf(j)!=input.indexOf(i+j)){ flag=false; break;
			 * //不匹配的话，跳出，与下一位进行比较 } } if(flag){ num++;//重复串出现的次数 }
			 */
		}
		// if(num>1){
		// System.out.println(subStr+"出现了 "+num+" 次");
		// }
	}

	private static String maxString(String input) {
		int len = input.length();
		String str;
		StringBuilder builder = new StringBuilder();
		for (int j = 1; j < len / 2; j++) {
			for (int i = 0; i < len - j; i++) {
				str = subString(i, i + j, input);
				if (!builder.toString().contains(str)) {
					builder.append(str);
					quick(input, str);
				}
				// containStr(input, str);

				// input.replaceAll("`"+i, str);
				// System.out.println(input);

				/*
				 * for(int k=0;k<len-j-1&&k!=i;k++){ flag=true; label: for(int
				 * l=0;l<j+1;l++){ if(str.indexOf(l)!=input.indexOf(k+l)){
				 * flag=false; break label; } } if(flag){
				 * System.out.println("重复串："+str); } }
				 */
			}
		}
		return null;
	}
}