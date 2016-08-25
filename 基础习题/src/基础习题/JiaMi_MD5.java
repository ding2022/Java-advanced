package 基础习题;

import java.security.MessageDigest;

public class JiaMi_MD5 {

	private final static String[] hexArray={
		"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e",
	};
	public static String encrypByMD5(String orign){
		if(orign!=null){
			try{
				//创建具有MD5加密算法的信息摘要
				MessageDigest md=MessageDigest.getInstance("MD5");
				byte[] results=md.digest(orign.getBytes());
				//转换成16进制
				String resultString=byteArrayToHex(results);
				return resultString.toUpperCase();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String byteArrayToHex(byte[] b) {
		StringBuffer resultSb=new StringBuffer();
		for(int i:b){
			resultSb.append(byteToHex(b[i++]));
		}
		
		return null;
	}
	private static Object byteToHex(byte b) {
		int n=b;
		if(n<0)
			n=256+n;
		int d1=n/16;
		int d2=n%16;
		return hexArray[d1]+hexArray[d2];
	}
	public static String createEncrypPassword(String string){
		return encrypByMD5(string);
	}
	public static boolean isPassword(String password,String string){
		if(password.equals(encrypByMD5(string))){
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		String password=JiaMi_MD5.createEncrypPassword("hahahahao1234");
		System.out.println("hahahahao1234"+password);
		System.out.println(isPassword(password, "1234"));
	}
}
