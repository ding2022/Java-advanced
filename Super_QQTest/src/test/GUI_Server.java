package test;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI_Server {
	JFrame f = null;
	JTextArea textArea;
	String str=null;
	public GUI_Server() {
		f = new JFrame(UserName.getUsername() + "-������--�����Ƽ�");
		f.setBounds(100, 100, 450, 300);
		Container container = f.getContentPane();

		textArea = new JTextArea(20, 40);

		container.add(textArea);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new Thread(new serviceRun()).start();
		f.pack();
		f.setVisible(true);
	}

	public void setTextView(String string){
		str=str+string+"\n";
		textArea.setText(str);
	}
	class serviceRun implements Runnable { // ����������

		@Override
		public void run() {
			try {
				new Eserver();
			} catch (Exception e) {
				System.out.println("����������ʧ�ܣ�");
				setTextView("����������ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new GUI_Server();
	}

	//�������˽���
	class Eserver {

		UserName u = new UserName();
		private int port = UserName.getPort();
		
		public List<ThreadForClient> ListthreadForClient =u.getThreadForClient();// �����ͻ��˵��߳��б�
		public Map<ThreadForClient, String> MapuserAndThread=u.getUserAndThread();//���߳���ͻ���������
		 
//		public List<ThreadForClient> ListthreadForClient = new ArrayList<ThreadForClient>();// �����ͻ��˵��߳��б�
//		public Map<ThreadForClient, String> MapuserAndThread=new HashMap<ThreadForClient, String>();//���߳���ͻ���������

		public Eserver() {
			try {
				boolean iConnect = false;
				ServerSocket serverSocket = new ServerSocket(port);// һֱ���ڼ���״̬
				iConnect = true; // ���Ϻ��Ϊtrue

				while (iConnect) {
					System.out.println("������������"); // �˴���ȡ����ip��ַ ��Ϊ������ַ
					System.out.println("������������\n\n���ڵȴ���λ����������ԡ���");
					
					setTextView("������������\n"+"������������\n\n���ڵȴ���λ����������ԡ���");

					Socket socket = serverSocket.accept(); // ��ʼ����

					ThreadForClient currentClient = new ThreadForClient(socket);// �����߳�����
					System.out.println("�����û����ߣ�"); // ĳĳ����
					setTextView("�����û����ߣ�");
					ListthreadForClient.add(currentClient); // �����б�
					MapuserAndThread.put(currentClient, UserName.getUsername());

					// TongBu();//�˴�ͬ�����б����Ϣ

					new Thread(currentClient).start(); // ���������߳�
					// System.out.println("�ͻ��˽����Ѿ�������");
				}

			} catch (IOException e) {
				System.out.println("�����쳣");
				setTextView("�����쳣");
				e.printStackTrace();
			}
		}

		/*
		 * public void TongBu(){ u.setThreadForClient(threadForClient);
		 * u.setUserAndThread(userAndThread); }
		 */

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
				setTextView("���û����Է����ˡ�������");
				try {
					while (isConnect) {
						// System.out.println("�ȴ����̷߳�����Ϣ");
						dataInStreamC = new DataInputStream(s.getInputStream());

						str = dataInStreamC.readUTF();// utf�������
						System.out.println(str);// �˴���ʾ�ͻ��˷�������Ϣ

						// ת����Ϣ
						for (int i = 0; i < ListthreadForClient.size(); i++) {
							// System.out.println("ת����Ϣ��..." + i);
							ThreadForClient c = ListthreadForClient.get(i);

							c.sendMsg(MapuserAndThread.get(c) + "˵�� " + str);
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
}
