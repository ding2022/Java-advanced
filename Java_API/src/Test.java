import java.util.ArrayList;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random  random=new Random();
		for(int i=0;i<20;i++)
		System.out.print(" "+random.nextFloat());
		
		
//		Math.pow(a, b);
		int [] a={1,2,3,4,5,6,7};
		ArrayList<Integer> list1=new ArrayList<Integer>();
		ArrayList<Integer> list2=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			if(a[i]%2==1){
				list1.add(a[i]);
			}else {
				list2.add(a[i]);
			}
		}
		list1.addAll(list2);
		System.out.println(list1);
		
		
		
		
		
		/*int n = 11, k = 0;
		for (int i = 0; i < 31; i++) {
			if (((1 << i) & n) != 0) {
				k++;
			}
		}
		System.out.println(k);*/
	}
}
