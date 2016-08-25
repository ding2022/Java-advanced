package 排序;

public class XiErSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 };
		int len = a.length;
		sort(a);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}

	static void sort(int [] list){//希尔排序 以插入排序为基础  对数组中间隔为h的数组进行插排  h以某个因子进行缩小 以不断地使间隔化的子数组有序 当h=1时 数组就可以完全排好了 由于之前间隔h（h是变化的）的顺序调整 在以后每次调整的过程中 都少了很多次的交换比较 最终大大提高了效率  适用于大型乱序数组
		int len=list.length;
		int h=1;//最终h是要为 1 的，因为间隔为1时 才会把每个数值都比较到
		while(h<len/3)//这里的3是根据数组的具体情况而定的 太大的话意义就不大了
			h=3*h+1;
		while(h>=1){
			int temp;
			for(int i=h;i<len;i++){//以h为开头 确保把前面的h长度数组遍历到 遍历list 
				for(int j=i;j>=h&&list[j]<list[j-h];j-=h){
					temp=list[j];
					list[j]=list[j-h];
					list[j-h]=temp;
				}
			}
			h=h/3;//缩小间隔 没出while循环的话 再次以更小的h插排 最终h=1时 排好
		}
	}
}
