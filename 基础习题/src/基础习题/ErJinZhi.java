package ����ϰ��;

public class ErJinZhi {

	static void IntLeftMove(String s,int i){
		System.out.println(s+" �Ķ�������ʽ�� ");
		for(int j=31;j>=0;j--){
			if(((1<<j)&i)!=0){//1����jλ����i���������� �� i ����Ӧλ��ҲΪ1 ����� 1������� 0 ������ֳ�������
				System.out.print(1);
			}else {
				System.out.print(0);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		IntLeftMove("10", 10);
		IntLeftMove("1023", 1023);
	}
}
