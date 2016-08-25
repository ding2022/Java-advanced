package test;

import java.awt.Container;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI_Client implements ActionListener {

	// ����
	JFrame f = null;
	JTextArea tf_msg = null;
	List list_msgList = null;
	List list_userList = null;
	JMenuBar menuBar = null;
	
	protected DataOutputStream dataOutStream; // �����
	protected DataInputStream dataInStream; // ������
	UserName u=new UserName();
	//
	/*EchoService service;
	EchoClient client;
	SocketServer server;*/

	public static void main(String[] args) {
		new GUI_Client();
	}
	public GUI_Client() {
		f = new JFrame(u.getUsername() + "-�ͻ���--�����Ƽ�");
		f.setBounds(100, 100, 450, 300);
		Container container = f.getContentPane();
		JPanel panel = new JPanel();

		menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);

		JMenu menu = new JMenu("����");
		menuBar.add(menu);
		JMenuItem single = new JMenuItem("��������");
		JMenuItem mult = new JMenuItem("��������");
		menu.add(single);
		menu.add(mult);
		single.addActionListener(this);
		mult.addActionListener(this);

		JMenu cmenu = new JMenu("ѡ��");
		menuBar.add(cmenu);
		JMenuItem cutCon = new JMenuItem("�Ͽ�����");
		JMenuItem exit = new JMenuItem("�˳�����");
		cmenu.add(cutCon);
		cmenu.add(exit);
		cutCon.addActionListener(this);
		exit.addActionListener(this);

		JMenu helpmenu = new JMenu("����");
		menuBar.add(helpmenu);
		JMenuItem about = new JMenuItem("����");
		helpmenu.add(about);
		about.addActionListener(this);

		/*JButton bt_server = new JButton("����������");
		bt_server.addActionListener(this);
		panel.add(bt_server);
		*/
		/*JButton bt_client = new JButton("��Ϊ�ͻ���");
		bt_client.addActionListener(this);
		panel.add(bt_client);
		*/
		JButton refresh = new JButton("���ˢ��������Ա");
		refresh.addActionListener(this);
		panel.add(refresh);

		list_msgList = new List(30);
		list_userList = new List(25);
		panel.add(list_msgList);
		panel.add(list_userList);

		tf_msg = new JTextArea(10, 10);
		// tf_msg.addAncestorListener((AncestorListener) new TFmsgListener());

		JButton button1 = new JButton("����");
		button1.addActionListener(this);

		panel.add(tf_msg);
		panel.add(button1);

		container.add(panel);

		new Eclient();//�ͻ�������
		
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("����")) {
			String msg=UserName.getUsername()+"˵�� "+tf_msg.getText();
			tf_msg.setText("");
			
			list_msgList.add(msg);
			
			try {
				dataOutStream.writeUTF(msg);//д��socket��
			} catch (Exception e1) {
				System.out.println("IOException");
				e1.printStackTrace();
			}
		} else if (cmd.equals("���ˢ��������Ա")) {
			
			/*for (int i = 0; i <u.getUserAndThread().size(); i++) {
				list_userList.add(u.getUserAndThread().get(i));
			}*/
			
		} else if (cmd.equals("��������")) {
			new ConTo();
		} /*else if (cmd.equals("����������")) {
			//new Eserver();
			new Thread(new serviceRun()).start();
			
		}*/ else if (cmd.equals("��������")) {
			// service.Service();
		} else if (cmd.equals("�Ͽ�����")) {

		} else if (cmd.equals("�˳�����")) {
			int j = JOptionPane.showConfirmDialog(f, "ȷ��Ҫ�˳���", "�˳�",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (j == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (cmd.equals("����")) {
			JOptionPane.showMessageDialog(f,
					"  Super_QQ��һ���ɺ�������������ſ����ľ�������Ϣ���������\n����javaƽ̨����ʵ�ֵĹ����У�\n"
							+ "�û�����½\n����˽��\n����Ⱥ��\n�����ļ��ȹ��ܡ�\n\nԸ��ʹ����죡\n"
							+ "\n       ��Ȩ���У���������");
		}
	}
	/*class serviceRun implements Runnable{ //����������

		@Override
		public void run() {
			try {
				new Eserver();
			} catch (Exception e) {
				System.out.println("����������ʧ�ܣ�");
				e.printStackTrace();
			} 
		}
	}*/

	class Eclient {
		private int port = UserName.getPort();
		private String host = UserName.getHost();
		private Socket socket;// socket

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

			public void recMsg() {// ������Ϣ
				try {
					while (iConnect) {
						str = dataInStream.readUTF();// ʼ�ն�ȡ����socket������
						//tf_msg.setText(str);
						list_msgList.add(str);//���뵽��Ϣ�б�
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
