package »ù´¡Ï°Ìâ;

public class JieCheng {
	public static void main(String[] args) {
		System.out.println(JieCheng(3));
		System.out.println(jiecheng2(4));
	}

	public static int JieCheng(int n) {
		int num = 1;
		for (int i = 1; i <= n; i++)
			num *= i;
		return num;
	}

	public static int jiecheng2(int n) {
		int zhi = 1;
		while (n-- == 1) {
			return zhi;
		}
		zhi = jiecheng2(n) * (n+1);
		return zhi;
	}
}
