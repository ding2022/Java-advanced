package 查找Internet地址;
//InetAddress 类又称互联网地址类，该类的对象是封装计算机名称和ip地址的实例

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
			System.out.println("请输入主机名或IP地址，输入\"exit\"退出程序！");
			try{
				while(true){
					System.out.println("主机名或IP地址：");
					String host=bin.readLine();//键盘读入
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
		if(isHostname(host)){ //判断是否为IP地址
			System.out.println(host+"的IP地址为：");
			return addr.getHostAddress();
		}else{
			System.out.println(host+"的主机名为：");
			return addr.getHostName();
		}
	}

	private static boolean isHostname(String host) {
		char[] ca=host.toCharArray();
		for(int i=0;i<ca.length;i++){
			if(!Character.isDigit(ca[i])){
				if(ca[i]!='.') //若含有 . 则为ip地址
					return true;
			}
		}
		return false;
	}
}
