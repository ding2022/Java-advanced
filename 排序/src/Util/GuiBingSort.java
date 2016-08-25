package Util;

public class GuiBingSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 };
		int len = a.length;
//		sort(a,0,3,6);
		sort2(a);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}	
	}
	static void sort2(int[] list){
		int len=list.length;
		int n=len/2;
		int [] temp=new int[len];
		
		for(int i=0;i<len;i++)
			temp[i]=list[i];
		int j=n,i=0;
			for(int k=0;k<=len;k++){//比较麻烦
				if(i>n)  //左边的子数组 用完了 说明左边的都排进了数组  那右边肯定有剩余没放进数组 即j是小于high的 还要进行后面的比较  
					list[k]=temp[j++];
				else if(j>len) //左边没完 右边的子数组 用完了 
					list[k]=temp[i++];
				else if(temp[j]<temp[i]) //最开始情况 两边都没完 比较 两边数组相应位比较 
					list[k]=temp[j++]; //右边的小于左边的 那么 右边j位置值给第一个
				else 
					list[k]=temp[i++]; 
		}
		int h=len;
		while(h!=0){
			h=h/2;
			int [] aux1,aux2;
			aux1=new int[h];
			aux2=new int[h];
			for(int l=0;l<h;l++){
				aux1[l]=list[l];
				aux2[l]=list[l+h];
			}
			sort2(aux1);
			sort2(aux2);
		}
	}
	static void sort(int [] list,int low,int mid,int high){//原地归并 借助辅助数组aux 对分成两部分的数组进行分别排序后 按大小顺序放入aux中
		int i=low,j=mid+1;//i,j 分别是两子数组的开始位置
		int [] aux = new int[list.length];
		for(int k=low;k<=high;k++)
			aux[k]=list[k];
		for(int k=low;k<=high;k++){//比较麻烦
			if(i>mid)  //左边的子数组 用完了 说明左边的都排进了数组  那右边肯定有剩余没放进数组 即j是小于high的 还要进行后面的比较  
				list[k]=aux[j++];
			else if(j>high) //左边没完 右边的子数组 用完了 
				list[k]=aux[i++];
			else if(aux[j]<aux[i]) //最开始情况 两边都没完 比较 两边数组相应位比较 
				list[k]=aux[j++]; //右边的小于左边的 那么 右边j位置值给第一个
			else 
				list[k]=aux[i++]; //左边的给第一个 
			//k++了 对第下一个进行取值 最终排好了 list；
		}
	}
}