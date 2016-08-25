package 各种Test;


public class XiXieGui {
	static String aString="";

	public static void main(String[] args) {
		int i;
		for(i=1000;i<10000;i++){
			if(chuli(i)!=0){
				System.out.println(chuli(i)+"*"+i/chuli(i)+"="+i);
			}
		}
	}
	public static int chuli(int i){
		int a,b,c,d;
		a=i%10;
		b=(i/10)%10;
		c=(i/100)%10;
		d=i/1000;
		//闈欐�佹柟娉曞彧鑳借皟鐢ㄩ潤鎬佺殑涓�浜涙娊璞＄被 鎴栧璞�
		System.out.println(aString);
	//	Bag n=new Bag();
		if(zaoshu(a,b)*zaoshu(c,d)==i){
			return zaoshu(a,b);
		}else if(zaoshu(a,b)*zaoshu(d,c)==i){
			return zaoshu(a,b);
		}else if(zaoshu(b,a)*zaoshu(d,c)==i){
			return zaoshu(b,a);
		}else if(zaoshu(b,a)*zaoshu(c,d)==i){
			return zaoshu(b,a);
		}else if(zaoshu(a,c)*zaoshu(b,d)==i){
			return zaoshu(a,c);
		}else if(zaoshu(a,c)*zaoshu(d,b)==i){
			return zaoshu(a,c);
		}else if(zaoshu(c,a)*zaoshu(b,d)==i){
			return zaoshu(c,a);
		}else if(zaoshu(c,a)*zaoshu(d,b)==i){
			return zaoshu(c,a);
		}else if(zaoshu(a,d)*zaoshu(b,c)==i){
			return zaoshu(a,d);
		}else if(zaoshu(a,d)*zaoshu(c,b)==i){
			return zaoshu(a,d);
		}else if(zaoshu(d,a)*zaoshu(b,c)==i){
			return zaoshu(d,a);
		}else if(zaoshu(d,a)*zaoshu(c,b)==i){
			return zaoshu(d,a);
		}else 
			return 0;
	}
	public static int zaoshu(int a,int b){
		return a*10+b;
	}
}
