package 华为上机题;

public class ArraySearch {
	public static void main(String[] args) {
		int [][] a={{1,2,3,4,5},{6,7,8,9,10}};
		System.out.println(solve(a, 11));
		
		
		String strin="we are family";
		String str=strin.replaceAll(" ","%20");
		System.out.println(str);
	}
	public static boolean solve(int [][] a,int n){
		boolean flag=false;
		int m=a[0].length;
		int k=a.length;
		//System.out.println(m+" "+k);
		for(int i=0;i<k;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]!=n){
					if(a[i][j]>n){
						m=j;
						i++;
					}
				}else {
					flag=true;
				}
			}
		}
		return flag;
	}
}
