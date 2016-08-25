package 基础习题;//銆愮▼搴�3銆� 棰樼洰锛氭墦鍗板嚭鎵�鏈夌殑"姘翠粰鑺辨暟"锛屾墍璋�"姘翠粰鑺辨暟"鏄寚涓�涓笁浣嶆暟锛屽叾鍚勪綅鏁板瓧绔嬫柟鍜岀瓑浜庤鏁版湰韬�備緥濡傦細153鏄竴涓�"姘翠粰鑺辨暟"锛屽洜涓�153=1鐨勪笁娆℃柟锛�5鐨勪笁娆℃柟锛�3鐨勪笁娆℃柟銆� 

public class T03 {
	public static void main(String[] args){
		for(int i=100;i<999;i++){
			if(suan(i)){
				System.out.println(i);
			}
		}
	}
	public static boolean suan(int i){
		int a,b,c;
		a=i%10;
		b=i/10%10;
		c=i/100;
		if(Math.pow(a, 3)+Math.pow(b, 3)+Math.pow(c, 3)==i){
			return true;
		}else {
			return false;
		}
	}
}
