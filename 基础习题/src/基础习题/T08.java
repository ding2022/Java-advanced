package 基础习题;
import java.util.Scanner;

/*銆愮▼搴�8銆� 
棰樼洰锛氭眰s=a+aa+aaa+aaaa+aa...a鐨勫�硷紝鍏朵腑a鏄竴涓暟瀛椼�備緥濡�2+22+222+2222+22222(姝ゆ椂鍏辨湁5涓暟鐩稿姞)锛宎鐨勫�间笌澶氬皯涓浉鍔犻」鐢辩敤鎴疯緭鍏ャ��
鎵╁睍锛氭敮鎸佺粨鏋滃�艰秴鍑簂ong鍊肩殑鑼冨洿
*/
public class T08 {
	private static Scanner input;

	public static void main(String[] args) {
		long[] he=new long[20];
		int i=0;
		
		input = new Scanner(System.in);
		int a=input.nextInt();
		//System.out.println();
		int num=input.nextInt();
		//System.out.println(num+a);
		
		while(i<num){
			int j=0;
			int b=a;
			while(j<=i){
			he[i]+=b;
			b*=10;
			j++;
			}
			i++;
		}
		i=0;
		long s=0;
		while(i<num){
			 s += he[i];			
			 System.out.println(he[i++]);
		}
		System.out.println(s);
	}
}
