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
	private DataOutputStream dataOutStream; // �����
	private DataInputStream dataInStream; // ������

	public Eclient() {
		try {
			socket = new Socket(host, port);

			dataOutStream = new DataOutputStream(socket.getOutputStream());// ����socket��������Ϣ
			dataInStream = new DataInputStream(socket.getInputStream());

			new Thread(new SendThread()).start();// ͬ������������Ϣ�߳�
		
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
					str = dataInStream.readUTF();//ʼ�ն�ȡ����socket������
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
