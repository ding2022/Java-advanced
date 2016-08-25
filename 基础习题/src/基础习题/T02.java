package 基础习题;
//銆愮▼搴�2銆戦鐩細鍒ゆ柇101-200涔嬮棿鏈夊灏戜釜绱犳暟锛屽苟杈撳嚭鎵�鏈夌礌鏁般�� 鍙兘琚竴鍜屼粬鏈韩姝ｅ

public class T02 {

	public static void main(String[] args) {
		for(int i=100;i<=200;i++){
			if(isSushu(i)){
				System.out.println(i);
			}
		}
	}
	public static boolean isSushu(int i){
		boolean flag=true;
		for(int j=2;j<Math.sqrt(i);j++)
			if(i%j==0){
				 flag=false;
				 return flag;
			}
		return flag;
	}

}
