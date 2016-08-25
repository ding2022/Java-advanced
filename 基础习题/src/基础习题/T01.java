package 基础习题;
/*銆愮▼搴�1銆� 
棰樼洰锛氬彜鍏搁棶棰橈細鏈変竴瀵瑰厰瀛愶紝浠庡嚭鐢熷悗绗�3涓湀璧锋瘡涓湀閮界敓涓�瀵瑰厰瀛愶紝灏忓厰瀛愰暱鍒扮涓変釜鏈堝悗姣忎釜鏈堝張鐢熶竴瀵瑰厰瀛愶紝鍋囧鍏斿瓙閮戒笉姝伙紝闂�2骞村唴姣忎釜鏈堢殑鍏斿瓙鎬绘暟涓哄灏戯紵 
澶т腑灏� 100 010 101 111 212 323 535 858 
````1   1   2   3   5   8   13  21 `````鏂愭尝閭ｅ
*/
public class T01 {
	//final private static int CHENG_ZHANG=3;
	public static void main(String[] args) {
		for(int i=1;i<24;i++){
			System.out.println("绗� "+i+" 鏈堝叡鏈夊厰瀛愶細"+he(i)+" 瀵�");
		}
	}

	public static int he(int m){
		int rubbit=1;
		if(m<=2)
			return rubbit;
		else {
			rubbit=he(m-1)+he(m-2);
			return rubbit;
		}
	}
}
