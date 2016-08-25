package 串;

/*模式匹配 子串与主串匹配
 * KMP移动的元素更多些
 * 前面有相应的实现
 */
public class KMP__BruteForce_模式匹配 {
	public static void main(String[] args) {
		String a = "abcdefgefghief";
		String b = "ef";
		NormalS.PiPei(b, a);
	}

}

class KMP_Test {
	/*
	 * public static boolean PiPei(String ziChuan,String FuChuan){ char[] zi =
	 * ziChuan.toCharArray(); char[] fu = FuChuan.toCharArray();
	 * 
	 * int fuL=fu.length; int ziL=zi.length; boolean teste=false;
	 * 
	 * 
	 * 
	 * return teste; }
	 */
	 public static void pattern(String str,String sub,int[] next) {
         char[] ch1 = str.toCharArray();
         char[] ch2 = sub.toCharArray();
         int i = 0,j = 0;  //i控制ch1,j控制ch2;
         for(;i<ch1.length; ) {
             if(ch1[i]==ch2[j]) {//匹配就自动递增，往后匹配。
                 if(j==ch2.length-1) {
                     System.out.println(i-ch2.length+1);
                     break;
                 }
                 j++;
                 i++;
             }
             else if(j==0) {
                  i++;
             }
             else {
                 j = next[j-1]+1;
             }
         }
     }
	// KMP中的核心算法，获得记录跳转状态的next数组
	public static int[] next(String sub) {
		int[] a = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length = sub.length();
		int i, j;
		a[0] = -1;
		i = 0;
		for (j = 1; j < length; j++) {
			i = a[j - 1];
			while (i >= 0 && c[j] != c[i + 1]) {
				i = a[i];
			}
			if (c[j] == c[i + 1]) {
				a[j] = i + 1;
			} else {
				a[j] = -1;
			}
		}
		return a;
	}
}

class NormalS {
	public static boolean PiPei(String ziChuan, String FuChuan) {
		char[] zi = ziChuan.toCharArray();
		char[] fu = FuChuan.toCharArray();

		int fuL = fu.length;
		int ziL = zi.length;
		boolean teste = false;

		for (int i = 0; i < fuL; i++) {
			boolean flag = true;
			for (int j = 0; j < ziL; j++) {
				if (zi[j] != fu[i + j]) {
					// System.out.println(fu[i]);
					flag = false;
					break;
				}
			}
			if (flag) {
				teste = flag;
				System.out.println(i + 1);
			}
		}
		return teste;
	}
}
