package ����;

//���ֲ��� �۰����  ÿ��ѡ���յ�����Ƚ�  ѡ���Ƚ�����
public class BinerySearch {
	public static int biSearch(int[] a, int elem) {
		int n = a.length;
		int low = 0, high = n - 1, mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == elem)
				return mid;
			else if (a[mid] < mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
