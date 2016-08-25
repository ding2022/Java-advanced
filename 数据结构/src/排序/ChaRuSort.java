package 排序;

public class ChaRuSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 };
		int len = a.length;
		sort(a);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	static void sort(int [] list){
		int len=list.length;
		int temp;
		for(int i=0;i<len;i++){
			for(int j=i;j>0&&list[j]<list[j-1];j--){//把i位置的值 与相邻前面的数进行比较 如果小于 与前面的值进行交换  带个循环 j不断地缩小 即让i位置的值不断地与前面进行比较 直到找到合适位置 插入进去 不适合大量无序的数组
				temp=list[j];
				list[j]=list[j-1];
				list[j-1]=temp;
			}
		}
	}
}
