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
			for(int k=0;k<=len;k++){//�Ƚ��鷳
				if(i>n)  //��ߵ������� ������ ˵����ߵĶ��Ž�������  ���ұ߿϶���ʣ��û�Ž����� ��j��С��high�� ��Ҫ���к���ıȽ�  
					list[k]=temp[j++];
				else if(j>len) //���û�� �ұߵ������� ������ 
					list[k]=temp[i++];
				else if(temp[j]<temp[i]) //�ʼ��� ���߶�û�� �Ƚ� ����������Ӧλ�Ƚ� 
					list[k]=temp[j++]; //�ұߵ�С����ߵ� ��ô �ұ�jλ��ֵ����һ��
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
	static void sort(int [] list,int low,int mid,int high){//ԭ�ع鲢 ������������aux �Էֳ������ֵ�������зֱ������ ����С˳�����aux��
		int i=low,j=mid+1;//i,j �ֱ�����������Ŀ�ʼλ��
		int [] aux = new int[list.length];
		for(int k=low;k<=high;k++)
			aux[k]=list[k];
		for(int k=low;k<=high;k++){//�Ƚ��鷳
			if(i>mid)  //��ߵ������� ������ ˵����ߵĶ��Ž�������  ���ұ߿϶���ʣ��û�Ž����� ��j��С��high�� ��Ҫ���к���ıȽ�  
				list[k]=aux[j++];
			else if(j>high) //���û�� �ұߵ������� ������ 
				list[k]=aux[i++];
			else if(aux[j]<aux[i]) //�ʼ��� ���߶�û�� �Ƚ� ����������Ӧλ�Ƚ� 
				list[k]=aux[j++]; //�ұߵ�С����ߵ� ��ô �ұ�jλ��ֵ����һ��
			else 
				list[k]=aux[i++]; //��ߵĸ���һ�� 
			//k++�� �Ե���һ������ȡֵ �����ź��� list��
		}
	}
}