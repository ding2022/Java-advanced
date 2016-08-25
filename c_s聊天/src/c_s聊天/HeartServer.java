package c_s����;

import java.io.*;
import java.net.*;
import java.util.*;

public class HeartServer {

	List<ClientThread> clients = new ArrayList<ClientThread>();

	public static void main(String[] args) {
		new HeartServer().start();
	}
	//����������
	public void start() {
		try {
			boolean iConnect = false;
			ServerSocket ss = new ServerSocket(1720);
			iConnect = true;
			while (iConnect) {
				System.out.println("�󶨷������˿ڳɹ���");
				Socket s = ss.accept();
				ClientThread currentClient = new ClientThread(s);// �����߳�����
				System.out.println("���ֿͻ��ˣ�");
				clients.add(currentClient);// �ѵ�ǰ�ͻ��˼��뼯��
				new Thread(currentClient).start();
				System.out.println("�ͻ��˽����Ѿ�������");
			}
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	//�ͻ��˽���
	class ClientThread implements Runnable {
		private Socket s;
		private DataInputStream dis;
		private DataOutputStream dos;
		private String str;
		private boolean iConnect = false;

		ClientThread(Socket s) {
			this.s = s;
			iConnect = true;
		}

		public void run() {
			System.out.println("run���������ˣ�");
			try {
				while (iConnect) {
					System.out.println("RUN�����е�whileѭ�����������ڵȴ��ͻ��˵ķ�����Ϣ...");
					dis = new DataInputStream(s.getInputStream());
					str = dis.readUTF();
					System.out.println(str);
					for (int i = 0; i < clients.size(); i++) {
						System.out.println("ת����Ϣ��..." + i);
						ClientThread c = clients.get(i);
						c.sendMsg(str);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//ת����Ϣ
		public void sendMsg(String str) {
			try {
				System.out.println("��������ܵ���");
				dos = new DataOutputStream(this.s.getOutputStream());
				System.out.println("������ͻ���д��Ϣ��");
				dos.writeUTF(str);
				System.out.println("������ͻ���д��Ϣ�ɹ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}