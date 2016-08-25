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

	// 界面
	JFrame f = null;
	JTextArea tf_msg = null;
	List list_msgList = null;
	List list_userList = null;
	JMenuBar menuBar = null;
	
	protected DataOutputStream dataOutStream; // 输出流
	protected DataInputStream dataInStream; // 输入流
	UserName u=new UserName();
	//
	/*EchoService service;
	EchoClient client;
	SocketServer server;*/

	public static void main(String[] args) {
		new GUI_Client();
	}
	public GUI_Client() {
		f = new JFrame(u.getUsername() + "-客户端--浩敏科技");
		f.setBounds(100, 100, 450, 300);
		Container container = f.getContentPane();
		JPanel panel = new JPanel();

		menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);

		JMenu menu = new JMenu("聊天");
		menuBar.add(menu);
		JMenuItem single = new JMenuItem("单独聊天");
		JMenuItem mult = new JMenuItem("多人聊天");
		menu.add(single);
		menu.add(mult);
		single.addActionListener(this);
		mult.addActionListener(this);

		JMenu cmenu = new JMenu("选项");
		menuBar.add(cmenu);
		JMenuItem cutCon = new JMenuItem("断开聊天");
		JMenuItem exit = new JMenuItem("退出程序");
		cmenu.add(cutCon);
		cmenu.add(exit);
		cutCon.addActionListener(this);
		exit.addActionListener(this);

		JMenu helpmenu = new JMenu("帮助");
		menuBar.add(helpmenu);
		JMenuItem about = new JMenuItem("关于");
		helpmenu.add(about);
		about.addActionListener(this);

		/*JButton bt_server = new JButton("创建服务器");
		bt_server.addActionListener(this);
		panel.add(bt_server);
		*/
		/*JButton bt_client = new JButton("作为客户端");
		bt_client.addActionListener(this);
		panel.add(bt_client);
		*/
		JButton refresh = new JButton("点击刷新在线人员");
		refresh.addActionListener(this);
		panel.add(refresh);

		list_msgList = new List(30);
		list_userList = new List(25);
		panel.add(list_msgList);
		panel.add(list_userList);

		tf_msg = new JTextArea(10, 10);
		// tf_msg.addAncestorListener((AncestorListener) new TFmsgListener());

		JButton button1 = new JButton("发送");
		button1.addActionListener(this);

		panel.add(tf_msg);
		panel.add(button1);

		container.add(panel);

		new Eclient();//客户端启动
		
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("发送")) {
			String msg=UserName.getUsername()+"说： "+tf_msg.getText();
			tf_msg.setText("");
			
			list_msgList.add(msg);
			
			try {
				dataOutStream.writeUTF(msg);//写入socket中
			} catch (Exception e1) {
				System.out.println("IOException");
				e1.printStackTrace();
			}
		} else if (cmd.equals("点击刷新在线人员")) {
			
			/*for (int i = 0; i <u.getUserAndThread().size(); i++) {
				list_userList.add(u.getUserAndThread().get(i));
			}*/
			
		} else if (cmd.equals("单独聊天")) {
			new ConTo();
		} /*else if (cmd.equals("创建服务器")) {
			//new Eserver();
			new Thread(new serviceRun()).start();
			
		}*/ else if (cmd.equals("多人聊天")) {
			// service.Service();
		} else if (cmd.equals("断开聊天")) {

		} else if (cmd.equals("退出程序")) {
			int j = JOptionPane.showConfirmDialog(f, "确定要退出吗？", "退出",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (j == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (cmd.equals("关于")) {
			JOptionPane.showMessageDialog(f,
					"  Super_QQ是一款由浩敏国际软件集团开发的局域网信息交流软件。\n基于java平台，可实现的功能有：\n"
							+ "用户名登陆\n建立私聊\n建立群聊\n传送文件等功能。\n\n愿您使用愉快！\n"
							+ "\n       版权所有：浩敏集团");
		}
	}
	/*class serviceRun implements Runnable{ //启动服务器

		@Override
		public void run() {
			try {
				new Eserver();
			} catch (Exception e) {
				System.out.println("服务器启动失败！");
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

			public void recMsg() {// 监听消息
				try {
					while (iConnect) {
						str = dataInStream.readUTF();// 始终读取来自socket的内容
						//tf_msg.setText(str);
						list_msgList.add(str);//加入到消息列表
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
