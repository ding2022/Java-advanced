package MathTest;

import java.util.Random;

public class MathUse {
	public static void main(String[] args) {
		// random �� ������math��,�����
		Random random = new Random();
		int a = random.nextInt(100);
		System.out.println(a);
		// ����math��
		Math.random();
		
		//�����ֵ
		Math.cbrt(a);//��������
		Math.log10(a);//����10Ϊ�ף�a�Ķ���ֵ
		
		//ʹ��ȡ������
		Math.abs(a);//����ֵ
		Math.ceil(a);//���ڵ���a����С�ĸ�������ʽ������
		Math.floor(a);//С�ڵ���a�����ĸ�������ʽ������
		Math.rint(a);//�������� ��������ʽ������
		Math.round(a);//�������� ������
		
		
		
	}
}
