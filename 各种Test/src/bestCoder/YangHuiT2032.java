package bestCoder;

//生成一个二维数组 记录相应点的值  两层循环  内层循环判断是否为每行的首尾位置 并把值付给二维数组 不是的话计算相应位置的点的值  等于i-1层的j-1 和j位置的和 把它赋给二维数组
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

		for (int i = 1; i <= n; i++) {// 控制行数
			for (int j = 1; j <= i; j++) {// 控制每行显示个数
				// System.out.print(1+" ");
				if (j == 1) {// 每行第一个数的值
					System.out.print(1 + " ");
					s[i][j] = 1;// 赋值
				} else if (j == i) {// 每行最后的值
					System.out.print(1);
					s[i][j] = 1;
				} else {// 打印出每行的中间数值
					s[i][j] = s[i - 1][j - 1] + s[i - 1][j];
					System.out.print(s[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
