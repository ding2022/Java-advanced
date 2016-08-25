/*package 基础习题;
import java.awt.Dialog.ModalExclusionType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
//【程序4】 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。 

public class T04 {

	private static Scanner input;
	public static void main(String[] args) {
			System.out.println("请输入你要分解的任意大小整数");
			
			BigDecimal num;//高精度数
			int one=1,two=2;
			
			input = new Scanner(System.in);
			while(input.hasNext()){
				num=input.nextBigDecimal();
				int k=0;
			System.out.print(num+"=");
			int a[]=new int[100];
			
			BigDecimal yi=BigDecimal.valueOf(one);
			BigDecimal er=BigDecimal.valueOf(two);
			
			for(BigDecimal i=er;i.compareTo(num)<0;i.add(yi)){
				int j= i.intValue();
			while(T02.isSushu(j)&&num.==0){
				a[k]=i;
				k++;
				num/=i;
			}
			for(int i=0;i<k-1;i++){
				System.out.print(a[i]+"*");
			}
			System.out.print(a[k-1]);
		}
			}
	}
}
*/