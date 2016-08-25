package c_s聊天;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class HeartClient extends Frame {
	private TextField tfText;
	private TextArea taContent;
	private Socket s;
	private DataOutputStream dos;
	private DataInputStream dis;

	public static void main(String[] args) {
		new HeartClient().launchFrame();

	}

	public void launchFrame() {
		tfText = new TextField();
		taContent = new TextArea();
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.tfText.addActionListener(new TFListener());
		this.add(tfText, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.pack();
		this.connect();
		this.setVisible(true);
	}

	/**
	 * 我在努力地连接服务器中...
	 */
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 1720);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			new Thread(new SendThread()).start();
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} finally {
		}

	}

	/**
	 * 额不会傻等着tfText(TextField tfText的监听器类)
	 */
	class TFListener implements ActionListener {
		private String str;

		@Override
		public void actionPerformed(ActionEvent e) {
			str = tfText.getText().trim();
			tfText.setText("");
			try {
				dos.writeUTF(str);
			} catch (IOException e1) {
				System.out.println("IOException");
				e1.printStackTrace();
			}
		}

	}

	/**
	 * 客户端接收消息的线程呦...
	 *
	 */
	class SendThread implements Runnable {
		private String str;
		private boolean iConnect = false;

		public void run() {
			iConnect = true;
			recMsg();
		}

		/**
		 * 消息，看招，哪里跑...（客户端接收消息的实现）
		 */
		public void recMsg() {
			try {
				while (iConnect) {
					str = dis.readUTF();
					taContent.setText(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}