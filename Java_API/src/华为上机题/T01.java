package 华为上机题;

import java.util.Scanner;
//给定一个字符串，把字符串内的字母转换成该字母的下一个字母，a换成b，z换成a，Z换成A，如aBf转换成bCg，字符串内的其他字符不改变，给定函数，编写函数

public class T01 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			char[] str1 = str.toCharArray();
			for(int i=0;i<str1.length;i++){
				str1[i]+=1;
			}
			System.out.println(str1);
		}
		in.close();
	}
}
