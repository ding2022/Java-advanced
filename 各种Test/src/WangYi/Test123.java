package WangYi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test123 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			String[] num = str.split(" ");
			int [] price=new int[num.length];
			for(int i=0;i<num.length;i++){
				price[i]=Integer.parseInt(num[i]);
			}
			solve(price, price.length);
		}
		in.close();
	}
	public static int solve(int [] price,int length){

		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i:price){
			a.add(i);
		}
//		Arrays.sort(price);*/
//		System.out.println(price[0]);
		
		
		
		int min=price[0];
		for(int i=1;i<length;i++){
			if(price[i]<min){
				min=a.get(i);
			}
		}
		
		/*if(a.size()==0){
			return 0;
		}else if(a.size()==1){
			
		}*/
		
		
		
		return 0;
	}
}
