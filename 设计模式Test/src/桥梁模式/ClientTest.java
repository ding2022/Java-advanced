package ����ģʽ;

public class ClientTest {
	public static void main(String[] args) {
		//��������ʼǱ�
		Computer2 c=new Laptop2(new Lenovo());
		c.sale();
		Computer2 d=new Desktop2(new Dell());
		d.sale();
		Computer2 e=new Pad2(new ShenZhou());//�ȼ��� pad2 �� ���ƽ�� �ټ��� ������  ����sale������ ������ݵ���
		//��Ϊ��Ϸ���
		e.sale();
	}
}
