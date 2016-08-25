public class addDigits {
	public static void main(String[] args) {
		int n=996,i=0,m=0;
		char[] a=(n+"").toCharArray();
		while(i+1<=a.length){
			m+=Integer.parseInt(a[i]+"")+Integer.parseInt(a[i++]+"");
			}
		while(m>=10){
			m=(m/10+m%10);
		}
		System.out.println(m);
		System.out.println(solve(11));
	}
	public static int solve(int n){
		int flag=0;
		for(int i=31;i>=0;i--){
			if(((1<<i)&n)!=0)
				flag++;
		}
		return flag;
	}
}
