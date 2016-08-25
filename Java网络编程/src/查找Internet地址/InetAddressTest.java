package ����Internet��ַ;
//InetAddress ���ֳƻ�������ַ�࣬����Ķ����Ƿ�װ��������ƺ�ip��ַ��ʵ��

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++)
				System.out.println(lookup(args[i]));
		} else {
			BufferedReader bin = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("��������������IP��ַ������\"exit\"�˳�����");
			try{
				while(true){
					System.out.println("��������IP��ַ��");
					String host=bin.readLine();//���̶���
					if(host.equalsIgnoreCase("exit")||host.equalsIgnoreCase("quit"))
						break;
					System.out.println(lookup(host));
				}
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}

	private static String lookup(String host) {
		InetAddress addr;
		try{
			addr=InetAddress.getByName(host);
		}catch(UnknownHostException e){
			return "cannot find host"+host;
		}
		if(isHostname(host)){ //�ж��Ƿ�ΪIP��ַ
			System.out.println(host+"��IP��ַΪ��");
			return addr.getHostAddress();
		}else{
			System.out.println(host+"��������Ϊ��");
			return addr.getHostName();
		}
	}

	private static boolean isHostname(String host) {
		char[] ca=host.toCharArray();
		for(int i=0;i<ca.length;i++){
			if(!Character.isDigit(ca[i])){
				if(ca[i]!='.') //������ . ��Ϊip��ַ
					return true;
			}
		}
		return false;
	}
}
