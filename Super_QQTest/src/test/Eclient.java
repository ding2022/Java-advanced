package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class Eclient {
	private int port = UserName.getPort();
	private String host = UserName.getHost();
	private Socket socket;// socket
	private DataOutputStream dataOutStream; // 输出流
	private DataInputStream dataInStream; // 输入流

	public Eclient() {
		try {
			socket = new Socket(host, port);

			dataOutStream = new DataOutputStream(socket.getOutputStream());// 接受socket传来的消息
			dataInStream = new DataInputStream(socket.getInputStream());

			new Thread(new SendThread()).start();// 同步创建接受消息线程
		
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} finally {
		}
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
					str = dataInStream.readUTF();//始终读取来自socket的内容
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
