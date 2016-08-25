//Given an array of integers, every element appears twice except for one. Find that single one.
public class T136 {
	public static void main(String[] args) {
		int[] a = { 101, 15, 14, 14, 15, 101, -17, 18, 18 ,-17,19};
		System.out.println(solve(a));
	}

	public static long solve(int[] nums) {
		long tmp=0;
		for(int i=0;i<nums.length;i++){
			tmp^=nums[i];
			System.out.println(tmp);
		}
		return tmp;
		
		
	/*	int len = nums.length;
		if (len % 2 == 1) {
			for(int i=0;i<len;i++){
				int k=0;
				for(int j=len-1;j>=0;j--){
					if(nums[i]==nums[j]){
						k++;
					}
				}
				if(k%2==1){
					return nums[i];
				}
			}
		}
		return 0;*/
	}
}
