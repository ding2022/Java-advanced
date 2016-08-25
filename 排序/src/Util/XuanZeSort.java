package Util;

public class XuanZeSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 };
		int len = a.length;
		sort(a);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	static void sort(int [] list){//每次循环选出最小（大）的排在前面 和冒泡很像
		int minValue;
		int minIndex;
		int temp;
		int len=list.length;
		for(int i=0;i<len;i++){
			minIndex=i;
			minValue=list[i];
			for(int j=i;j<len;j++){
				if(list[j]<minValue){//这里不像冒泡 没有交换  最后交换一次即可 提高效率
					minIndex=j;
					minValue=list[j];
				}
			}
			temp=list[i];
			list[i]=list[minIndex];
			list[minIndex]=temp;
		}
	}
}
