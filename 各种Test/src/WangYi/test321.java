package WangYi;

public class test321 {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		int [] p=solve(a, 4);
		for(int i=0;i<p.length;i++){
			System.out.println(p[i]);
		}
	}

	public static int[] solve(int[][] arr, int n) {
		int [] num=new int[n*n];
		int t=0;
		for (int k = 0; k < n*2; k++)
			for (int j = 0; j < n; j++)
				for (int i = 0; i < n; i++) {
					if ((i + j) == k) {
						num[t++]=arr[j][n-1-i];
					}
				}
		return num;
	}
}
