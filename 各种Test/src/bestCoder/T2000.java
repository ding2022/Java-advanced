package bestCoder;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T2000 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			String[] s=str.split(" ");
			
			double x=Double.parseDouble(s[0]);
			double y=Double.parseDouble(s[1]);
			double a=Double.parseDouble(s[2]);
			double b=Double.parseDouble(s[3]);
			double result=Math.sqrt((a-x)*(a-x)+(b-y)*(b-y));

			DecimalFormat df=new DecimalFormat("#.00");
			System.out.println(df.format(result));
		}
		in.close();
	}
}
