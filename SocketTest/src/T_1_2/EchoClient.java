package T_1_2;

import java.io.IOException;
import java.net.Socket;

public class EchoClient {
	private String host="localhost";
	private int port=8000;
	private Socket socket;
	
	public EchoClient() throws IOException{
		socket=new Socket(host,port);
	}
	
	public static void main(String[] args) {
//		 new EchoClient().talk();
	}

}
