package ����;

public class XiErSort {

	public static void main(String[] args) {
		int[] a = { 9, 4, 7, 1, 7, 10, 45 };
		int len = a.length;
		sort(a);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}

	static void sort(int [] list){//ϣ������ �Բ�������Ϊ����  �������м��Ϊh��������в���  h��ĳ�����ӽ�����С �Բ��ϵ�ʹ����������������� ��h=1ʱ ����Ϳ�����ȫ�ź��� ����֮ǰ���h��h�Ǳ仯�ģ���˳����� ���Ժ�ÿ�ε����Ĺ����� �����˺ܶ�εĽ����Ƚ� ���մ�������Ч��  �����ڴ�����������
		int len=list.length;
		int h=1;//����h��ҪΪ 1 �ģ���Ϊ���Ϊ1ʱ �Ż��ÿ����ֵ���Ƚϵ�
		while(h<len/3)//�����3�Ǹ�������ľ������������ ̫��Ļ�����Ͳ�����
			h=3*h+1;
		while(h>=1){
			int temp;
			for(int i=h;i<len;i++){//��hΪ��ͷ ȷ����ǰ���h������������� ����list 
				for(int j=i;j>=h&&list[j]<list[j-h];j-=h){
					temp=list[j];
					list[j]=list[j-h];
					list[j-h]=temp;
				}
			}
			h=h/3;//��С��� û��whileѭ���Ļ� �ٴ��Ը�С��h���� ����h=1ʱ �ź�
		}
	}
}
