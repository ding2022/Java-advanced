package 基础习题;

public class ErJinZhi {

	static void IntLeftMove(String s,int i){
		System.out.println(s+" 的二进制形式是 ");
		for(int j=31;j>=0;j--){
			if(((1<<j)&i)!=0){//1左移j位后与i进行与运算 若 i 在相应位置也为1 则输出 1否则输出 0 最后体现出二进制
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
