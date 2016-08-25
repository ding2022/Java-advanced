package 查找;

//二分查找 折半查找  每次选出终点与其比较  选定比较区间
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
