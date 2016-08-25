package bestCoder;

//����һ����ά���� ��¼��Ӧ���ֵ  ����ѭ��  �ڲ�ѭ���ж��Ƿ�Ϊÿ�е���βλ�� ����ֵ������ά���� ���ǵĻ�������Ӧλ�õĵ��ֵ  ����i-1���j-1 ��jλ�õĺ� ����������ά����
import java.util.Scanner;

public class YangHuiT2032 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] s = str.split(" ");
			int[] num = new int[s.length];
			for (int i = 0; i < s.length; i++) {
				num[i] = Integer.parseInt(s[i]);
				if (num[i] >= 1 && num[i] <= 30) {
					// YangHui(num[i]);
					yanghui2(num[i]);
					// System.out.println();
				}
			}
		}
		in.close();
	}

	public static void yanghui2(int n) {
		int[] b = new int[31];
		b[0] = 1;
		int i, j;
		System.out.println(b[0]);
		for (i = 1; i < n; i++) {
			b[i] = 1;
			for (j = i - 1; j > 0; j--) {
				b[j] = b[j] + b[j - 1];
			}
			for (j = 0; j <= i; j++) {
				System.out.print(b[j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void YangHui(int n) {
		int[][] s = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {// ��������
			for (int j = 1; j <= i; j++) {// ����ÿ����ʾ����
				// System.out.print(1+" ");
				if (j == 1) {// ÿ�е�һ������ֵ
					System.out.print(1 + " ");
					s[i][j] = 1;// ��ֵ
				} else if (j == i) {// ÿ������ֵ
					System.out.print(1);
					s[i][j] = 1;
				} else {// ��ӡ��ÿ�е��м���ֵ
					s[i][j] = s[i - 1][j - 1] + s[i - 1][j];
					System.out.print(s[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
