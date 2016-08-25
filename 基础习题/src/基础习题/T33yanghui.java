package 基础习题;
import java.util.Scanner;

public class T33yanghui {
	public static void main(String args[]) {
		int Line_num;
		int row, col;
		int yh[] = new int[20]; // 涓嶈秴杩�20琛�
		Scanner reader = new Scanner(System.in);
		System.out.print("璇疯緭鍏ヨ鏁�:");
		Line_num = reader.nextInt();
		yh[0] = 1;
		for (row = 0; row < Line_num; row++) { // 鎺у埗杈撳嚭琛屾暟涓篖ine_num鐨勫惊鐜帶鍒�
			for (col = row; col > 0; col--) {
				yh[col] = yh[col - 1] + yh[col];
			}
			for (int i = 1; i < Line_num - row; i++) { // 鎺у埗杈撳嚭姣忚鍓嶅绌烘牸鐨勫惊鐜帶鍒�
				System.out.print(" ");
			}
			for (col = 0; col <= row; col++) {
				System.out.print(yh[col] + " "); // 杈撳嚭涓嬫爣涓篶ol鐨勯」鐨勪唬鐮�
			}

			System.out.println("");
		}
	}

}