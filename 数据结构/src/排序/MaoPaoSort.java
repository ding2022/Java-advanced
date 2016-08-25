package 排序;

public class MaoPaoSort {

	public static void main(String[] args) {
		test();
	}
	public static void test(){
		int[] a = { 9, 4, 7, 1, 7, 10, 45 };
		int len = a.length;
		sort(a);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	static void sort(int[] list) {//比i位小的就交换 
		int len = list.length;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (list[j] < list[i]) {
					int t = list[i];
					list[i] = list[j];
					list[j] = t;
				}
			}
		}
	}
}
