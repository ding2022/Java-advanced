package ��Ϊ�ϻ���;

import java.util.Scanner;
//����һ���ַ��������ַ����ڵ���ĸת���ɸ���ĸ����һ����ĸ��a����b��z����a��Z����A����aBfת����bCg���ַ����ڵ������ַ����ı䣬������������д����

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
