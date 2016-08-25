import java.util.Scanner;

public class GoogleSolve3 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext())
		{
			int num=in.nextInt();
			for(int i=0;i<num;i++){
				int n=in.nextInt();
				String[] str=new String[n];
				for(int j=0;j<n+1;j++){
					str[j]=in.nextLine();
				}
				System.out.println("Case #"+(i+1)+": "+solve(str));
			}
		}
		in.close();
	}
	public static int solve(String [] s){
		int len=s.length,k=0;
		String temp=null;
		for(int i=0;i<len;i++){
			for(int j=i-1;j>=0;j--){
				if(s[i].compareTo(s[j])<0){
					temp=s[i];
					s[i]=s[j];
					s[j]=temp;
					k++;
				}
			}
		}
		return k;
	}
}
