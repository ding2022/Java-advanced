package Util;

public class KuaiPaiSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 ,1,1,8,23,100,1};
		int len = a.length;
		sort(a,0,len-1);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	static int getMiddle(int [] list,int left,int right){//ÿ��Ѱ�ҵ������ĵ�����λ���Ѿ��źõ�
		int temp;//����ʱ���м����
		//����һ�˿��� �������ĵ�λ��
		int mid=list[left];//ͨ������������ a[0] ��������ĵ�һ��λ��
		while(left<right){
			while(left<right&&list[right]>=mid){//�ҵ������ĵ�С���� ����
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
		//list[left]=mid;//�����Ƶ���ȷλ��  ���ǹؼ���ȷ����λ�� ��һ�β����бȽ� ���ҵ�����ط� left�Ѿ���mid��
		return left;
	}
	static int[] sort(int [] list,int left,int right){
		if(left<right-1){	//�����ҵ��м�㣬��������ֵ�����չ������������
			int mid=getMiddle(list, left, right);
			sort(list, left, mid-1);
			sort(list, mid+1, right);
		}
		return list;
	}
}
