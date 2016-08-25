package bestCoder;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T2002 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			double num=in.nextDouble();
			DecimalFormat df=new DecimalFormat("#.000");
			System.out.println(df.format((4./3.)*3.1415927*num*num*num));
		}
		in.close();
	}
}
