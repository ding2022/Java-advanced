package ����;

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
			for(int j=i;j>0&&list[j]<list[j-1];j--){//��iλ�õ�ֵ ������ǰ��������бȽ� ���С�� ��ǰ���ֵ���н���  ����ѭ�� j���ϵ���С ����iλ�õ�ֵ���ϵ���ǰ����бȽ� ֱ���ҵ�����λ�� �����ȥ ���ʺϴ������������
				temp=list[j];
				list[j]=list[j-1];
				list[j-1]=temp;
			}
		}
	}
}
