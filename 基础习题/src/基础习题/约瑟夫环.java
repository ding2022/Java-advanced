package ����ϰ��;

import java.util.Iterator;
import java.util.LinkedList;
//���õ�����   ������10 ���� �Ƴ�������  ������ʵ��
public class Լɪ�� {
	public static void main(String[] args) {
		LinkedList<Integer> lucky = new LinkedList<Integer>();

		int num, cnt;// numΪ���������� cntΪ��ǰʣ�µ���

		for (num = 1; num <= 100; num++)
			// ȫ�����
			lucky.addLast(num);
		System.out.println(lucky);
		cnt = 100;
		num = 0;
		Iterator<Integer> it = lucky.iterator();
		// ѭ��ɾ���˳�����
		while (cnt > 1) {
			if (it.hasNext()) {// û�е�ĩβ
				it.next();
				++num;
			} else {
				it = lucky.iterator();
				System.out.println(lucky);
			}

			if (num == 10) { //���� 10 ��   һ��ѭ��������
				num = 0;
				it.remove();
				--cnt;
			}
		}
		System.out.println(lucky.element());
	}
}
