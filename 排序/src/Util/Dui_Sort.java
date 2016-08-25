package Util;

//堆排序是一种不稳定的排序
//最大堆或最小堆 对于根节点到子节点的路径上的值总是递增或递减的
//堆排序 把要排序的数组先转换成最大堆或最小堆  交换根节点与尾节点位值   再整理该堆即可
public class Dui_Sort {
	public static void createHeap(int[] a, int n, int h) {
		int i, j, flag;
		int temp;

		i = h; // i为要建堆的二叉树根节点的下标
		j = 2 * i + 1; // j为i节点的做孩子的下标

		temp = a[i];
		flag = 0;

		// 沿左右孩子中的值较大者重复向下筛选
		while (j < n && flag != 1) {
			// 寻找左右孩子节点中的较大者 j为下标
			if (j < n - 1 && a[j] < a[j + 1])
				j++;

			if (temp > a[j]) {
				// 父节点比子节点大
				flag = 1;
			} else {// 否则把较大的 a[j]上移
				a[i] = a[j];
				i = j;// 降到子节点
				j = 2 * i + 1;// 往下一层走
			}
		}
		a[i] = temp;// 把最初的 a[i]赋予最后的a[j] 交换
	}

	public static void initCreateHeap(int[] a) {// 创建一个队 从初始创建的话一直是有序的
		int n = a.length;
		for (int i = (n - 1) / 2; i >= 0; i++) {
			createHeap(a, n, i);
		}
	}

	public static void heapSort(int[] a) {
		int temp;
		int n = a.length;

		initCreateHeap(a);

		for (int i = n - 1; i > 0; i--) {// 当前最大堆的个数每次递减1
			// 把堆顶a[0]元素和当前最大堆的最后一个元素交换
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			createHeap(a, i, 0);// 调整根节点满足最大堆
		}
		// 此时a已经排好序
	}
}
