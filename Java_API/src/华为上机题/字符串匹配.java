package ��Ϊ�ϻ���;

import java.util.Scanner;

//ɾ���ظ��ַ� ��Ѱ���ض��Ӵ� ���ҵ����
public class �ַ���ƥ�� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input = in.nextLine();
		//	System.out.println(subString(1, 2, input)+input.substring(1, 2));
			deleteRepetChar2(input);
			deleteRepetChar(input);
		}
		in.close();
	}

	private static void deleteRepetChar(String input) {// ˳�򱣳ֲ��� ��ɾ���ظ��ַ�,�ӽ��ײ�
		boolean flag;
		int len = input.length(), k = 0;
		char[] in = input.toCharArray(), out = new char[in.length];
		System.out.println("ɾ���ظ��ַ�������У� ");
		subString(0, 0, input);
		for (int i = 0; i < len; i++) {
			flag = true;
			for (int j = 0; j < i; j++) {
				if (in[i] == out[j])
					flag = false;
				// break;
			}
			if (flag) {
				out[k++] = in[i];
				System.out.print(out[k - 1]);
			}
		}
		System.out.println();
	}

	private static void deleteRepetChar2(String input) {//
		char[] in = input.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < in.length; i++) {
			if (!builder.toString().contains(in[i] + "")) {
				builder.append(in[i]);
			}
		}
		System.out.println(builder.toString());
	}

	private static String subString(int begin, int end, String input) {
		StringBuilder builder = new StringBuilder();
		for (int i = begin; i <= end; i++) {
			builder.append(input.charAt(i));
		}
		return builder.toString();
	}
}
