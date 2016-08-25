package 排序;

public class KuaiPaiSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 ,1,1,8,23,100,1};
		int len = a.length;
		sort(a,0,len-1);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	static int getMiddle(int [] list,int left,int right){//每次寻找到的中心点总是位置已经排好的
		int temp;//交换时的中间变量
		//进行一趟快排 返回中心点位置
		/*
		 * 1 3 4 5 9
		 * 
		 * 4 1 5 9 3
		 * 3 1 5 9 4
		 * 3 1 4 9 5  //把4的最终位置确定下来了
		 * 
		 * 
		 */
		
		int mid=list[left];//通常把中心置于 a[0] 即新数组的第一个位置
		while(left<right){//重要  每一次循环就是把mid这个值往中间逼近的过程  最终无法逼迫时  位置就确定了
			while(left<right&&list[right]>=mid){//找到比中心点小的数 交换
				right--;
			}
			temp=list[right];
			list[right]=list[left];
			list[left]=temp;
			while(left<right&&list[left]<=mid){
				left++;
			}
			temp=list[right];
			list[right]=list[left];
			list[left]=temp;
		}
		//list[left]=mid;//中心移到正确位置  这是关键，确定了位置 下一次不进行比较 并且到这个地方 left已经是mid了
		return left;//此处返回right也是一样
	}
	static int[] sort(int [] list,int left,int right){
		if(left<right-1){	//不断找到中间点，交换两边值，最终构成有序的数组
			int mid=getMiddle(list, left, right);
			sort(list, left, mid-1);
			sort(list, mid+1, right);
		}
		return list;
	}
}
