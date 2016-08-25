package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;


public class EchoClient {
	SocketServer sos = new SocketServer();
	int port = sos.port_public;
	String host = sos.host;
	Socket socket = null;

	public EchoClient() throws IOException {

		socket = new Socket();
		SocketAddress remoteAddr = new InetSocketAddress(host, port);
		socket.connect(remoteAddr, 20000);
		new Thread(new SendThread()).start();
		// System.out.println("host:" + host + ",port:" + port);
	}

	public void talk(InputStream message) throws IOException {
		try {

			PrintWriter pw = sos.getWriter(socket);

			InputStreamReader in = new InputStreamReader(message);
			BufferedReader localw = new BufferedReader(in);

			String msg = null;
			pw.print("");
			if ((msg = localw.readLine()) != null) {
				if (msg.equals("bye")) {
				}
				pw.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) throws IOException {
		ByteArrayInputStream str = new ByteArrayInputStream(("haoge")
				.toString().getBytes());
		new EchoClient().talk(str);
	}
	class SendThread implements Runnable {
		private String str;
		private boolean iConnect = false;

		public void run() {
			iConnect = true;
			recMsg();
		}

		public void recMsg() {
			try {
				while (iConnect) {
				/*	str = dis.readUTF();
					taContent.setText(str);*/
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
