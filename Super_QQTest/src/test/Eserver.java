package test;
/*package echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class Eserver {

	UserName u=new UserName();
	private int port = UserName.getPort();
	
	public List<ThreadForClient> threadForClient =u.getThreadForClient();// �����ͻ��˵��߳��б�
	public Map<ThreadForClient, String> userAndThread=u.getUserAndThread();//���߳���ͻ���������

	public static void main(String[] args) {
		new Eserver();
	}
	public Eserver() {
		try {
			boolean iConnect = false;
			ServerSocket serverSocket = new ServerSocket(port);// һֱ���ڼ���״̬
			iConnect = true; // ���Ϻ��Ϊtrue

			while (iConnect) {
				System.out.println("������������"); // �˴���ȡ����ip��ַ ��Ϊ������ַ
				System.out.println("������������\n\n���ڵȴ���λ����������ԡ���");
				
				Socket socket = serverSocket.accept(); // ��ʼ����
				
				ThreadForClient currentClient = new ThreadForClient(socket);// �����߳�����
				System.out.println("�����û����ߣ�"); // ĳĳ����
				threadForClient.add(currentClient); // �����б�
				userAndThread.put(currentClient, UserName.getUsername());
				
				//TongBu();//�˴�ͬ�����б�����Ϣ
				
				new Thread(currentClient).start(); // ���������߳�
				//System.out.println("�ͻ��˽����Ѿ�������");
			}

		} catch (IOException e) {
			System.out.println("�����쳣");
			e.printStackTrace();
		}
	}
	
	public void TongBu(){
		u.setThreadForClient(threadForClient);
		u.setUserAndThread(userAndThread);
	}
	
	class ThreadForClient implements Runnable {
		private Socket s;// ÿ�����̵�����socket
		private DataInputStream dataInStreamC;// ���������
		private DataOutputStream dataOutputStreamC;
		private String str;
		private boolean isConnect = false;// �Ƿ����ӳɹ�

		ThreadForClient(Socket socket) {// �ض���socket
			this.s = socket;
			isConnect = true;
		}

		@Override
		public void run() {
			System.out.println("���û����Է����ˡ�������");// �˴����Ա�ʾÿ���ͻ��˵��ض���Ϣ
			try {
				while (isConnect) {
					//System.out.println("�ȴ����̷߳�����Ϣ");
					dataInStreamC = new DataInputStream(s.getInputStream());

					str = dataInStreamC.readUTF();// utf�������
					System.out.println(str);// �˴���ʾ�ͻ��˷�������Ϣ

					// ת����Ϣ
					for (int i = 0; i < threadForClient.size(); i++) {
						// System.out.println("ת����Ϣ��..." + i);
						ThreadForClient c = threadForClient.get(i);

						c.sendMsg(userAndThread.get(c)+"˵�� "+str);
					}

				}

			} catch (Exception e) {
			}
		}// ÿһ���̶߳��и�socket

		public void sendMsg(String str) {
			try {
				System.out.println("ת���С���");
				// Ϊÿ���̴߳���һ������� д������
				dataOutputStreamC = new DataOutputStream(
						this.s.getOutputStream());
				dataOutputStreamC.writeUTF(str);

				System.out.println("ת���ɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
*/