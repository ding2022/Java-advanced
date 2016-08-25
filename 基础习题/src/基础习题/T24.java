package 基础习题;/*銆愮▼搴�24銆� 
棰樼洰锛氱粰涓�涓笉澶氫簬5浣嶇殑姝ｆ暣鏁帮紝瑕佹眰锛氫竴銆佹眰瀹冩槸鍑犱綅鏁帮紝浜屻�侀�嗗簭鎵撳嵃鍑哄悇浣嶆暟瀛椼�� 
*/
import java.util.Scanner;

public class T24 {
	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		String string = in.next();
		int i=string.length();
		System.out.println(i);
		while(i--!=0)
		System.out.print(string.charAt(i));
	}
}
