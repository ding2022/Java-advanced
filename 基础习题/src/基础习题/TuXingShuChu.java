package ����ϰ��;

public class TuXingShuChu {
	static void SanJiaoXing(int row){
		for(int i=0;i<row;i++){
			for(int j=1;j<=row-i;j++){
				System.out.print(" ");//����ո�
			}
			for(int x=1;x<=i*2-1;x++){
				System.out.print("*");//����*
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SanJiaoXing(10);
	}

}
