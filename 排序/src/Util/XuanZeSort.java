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
	static void sort(int [] list){//ÿ��ѭ��ѡ����С���󣩵�����ǰ�� ��ð�ݺ���
		int minValue;
		int minIndex;
		int temp;
		int len=list.length;
		for(int i=0;i<len;i++){
			minIndex=i;
			minValue=list[i];
			for(int j=i;j<len;j++){
				if(list[j]<minValue){//���ﲻ��ð�� û�н���  ��󽻻�һ�μ��� ���Ч��
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
