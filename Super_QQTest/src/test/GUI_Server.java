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
		f = new JFrame(UserName.getUsername() + "-服务器--浩敏科技");
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
	class serviceRun implements Runnable { // 启动服务器

		@Override
		public void run() {
			try {
				new Eserver();
			} catch (Exception e) {
				System.out.println("服务器启动失败！");
				setTextView("服务器启动失败！");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new GUI_Server();
	}

	//服务器端进程
	class Eserver {

		UserName u = new UserName();
		private int port = UserName.getPort();
		
		public List<ThreadForClient> ListthreadForClient =u.getThreadForClient();// 监听客户端的线程列表
		public Map<ThreadForClient, String> MapuserAndThread=u.getUserAndThread();//把线程与客户名绑定起来
		 
//		public List<ThreadForClient> ListthreadForClient = new ArrayList<ThreadForClient>();// 监听客户端的线程列表
//		public Map<ThreadForClient, String> MapuserAndThread=new HashMap<ThreadForClient, String>();//把线程与客户名绑定起来

		public Eserver() {
			try {
				boolean iConnect = false;
				ServerSocket serverSocket = new ServerSocket(port);// 一直处于监听状态
				iConnect = true; // 连上后变为true

				while (iConnect) {
					System.out.println("服务器启动！"); // 此处获取本机ip地址 作为主机地址
					System.out.println("倡导正能量！\n\n正在等待各位，请积极发言……");
					
					setTextView("服务器启动！\n"+"倡导正能量！\n\n正在等待各位，请积极发言……");

					Socket socket = serverSocket.accept(); // 开始监听

					ThreadForClient currentClient = new ThreadForClient(socket);// 创建线程引用
					System.out.println("有新用户上线！"); // 某某上线
					setTextView("有新用户上线！");
					ListthreadForClient.add(currentClient); // 加入列表
					MapuserAndThread.put(currentClient, UserName.getUsername());

					// TongBu();//此处同步了列表和消息

					new Thread(currentClient).start(); // 启动监听线程
					// System.out.println("客户端进程已经启动！");
				}

			} catch (IOException e) {
				System.out.println("服务异常");
				setTextView("服务异常");
				e.printStackTrace();
			}
		}

		/*
		 * public void TongBu(){ u.setThreadForClient(threadForClient);
		 * u.setUserAndThread(userAndThread); }
		 */

		class ThreadForClient implements Runnable {
			private Socket s;// 每个进程单独的socket
			private DataInputStream dataInStreamC;// 输入输出流
			private DataOutputStream dataOutputStreamC;
			private String str;
			private boolean isConnect = false;// 是否连接成功

			ThreadForClient(Socket socket) {// 特定的socket
				this.s = socket;
				isConnect = true;
			}

			@Override
			public void run() {
				System.out.println("新用户可以发言了……哈哈");// 此处可以标示每个客户端的特定信息
				setTextView("新用户可以发言了……哈哈");
				try {
					while (isConnect) {
						// System.out.println("等待此线程发送消息");
						dataInStreamC = new DataInputStream(s.getInputStream());

						str = dataInStreamC.readUTF();// utf编码读入
						System.out.println(str);// 此处显示客户端发来的消息

						// 转发消息
						for (int i = 0; i < ListthreadForClient.size(); i++) {
							// System.out.println("转发消息中..." + i);
							ThreadForClient c = ListthreadForClient.get(i);

							c.sendMsg(MapuserAndThread.get(c) + "说： " + str);
						}

					}

				} catch (Exception e) {
				}
			}// 每一个线程都有个socket

			public void sendMsg(String str) {
				try {
					System.out.println("转发中……");
					// 为每个线程创建一个输出流 写入数据
					dataOutputStreamC = new DataOutputStream(
							this.s.getOutputStream());
					dataOutputStreamC.writeUTF(str);

					System.out.println("转发成功");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
