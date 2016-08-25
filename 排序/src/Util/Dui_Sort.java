package Util;

//��������һ�ֲ��ȶ�������
//���ѻ���С�� ���ڸ��ڵ㵽�ӽڵ��·���ϵ�ֵ���ǵ�����ݼ���
//������ ��Ҫ�����������ת�������ѻ���С��  �������ڵ���β�ڵ�λֵ   ������öѼ���
public class Dui_Sort {
	public static void createHeap(int[] a, int n, int h) {
		int i, j, flag;
		int temp;

		i = h; // iΪҪ���ѵĶ��������ڵ���±�
		j = 2 * i + 1; // jΪi�ڵ�������ӵ��±�

		temp = a[i];
		flag = 0;

		// �����Һ����е�ֵ�ϴ����ظ�����ɸѡ
		while (j < n && flag != 1) {
			// Ѱ�����Һ��ӽڵ��еĽϴ��� jΪ�±�
			if (j < n - 1 && a[j] < a[j + 1])
				j++;

			if (temp > a[j]) {
				// ���ڵ���ӽڵ��
				flag = 1;
			} else {// ����ѽϴ�� a[j]����
				a[i] = a[j];
				i = j;// �����ӽڵ�
				j = 2 * i + 1;// ����һ����
			}
		}
		a[i] = temp;// ������� a[i]��������a[j] ����
	}

	public static void initCreateHeap(int[] a) {// ����һ���� �ӳ�ʼ�����Ļ�һֱ�������
		int n = a.length;
		for (int i = (n - 1) / 2; i >= 0; i++) {
			createHeap(a, n, i);
		}
	}

	public static void heapSort(int[] a) {
		int temp;
		int n = a.length;

		initCreateHeap(a);

		for (int i = n - 1; i > 0; i--) {// ��ǰ���ѵĸ���ÿ�εݼ�1
			// �ѶѶ�a[0]Ԫ�غ͵�ǰ���ѵ����һ��Ԫ�ؽ���
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			createHeap(a, i, 0);// �������ڵ���������
		}
		// ��ʱa�Ѿ��ź���
	}
}
