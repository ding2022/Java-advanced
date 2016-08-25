package server;

/*
 * 功能：实现服务器用户上线与下线的监听。该类对用户上线下线的监听是通过调
 * 用用户链表类（UserLinkList）
 *来实现的。当用户上线与下线情况发生变化时，该类会对主类的界面进行相应的修改。
 */
import javax.swing.*;
import java.io.*;
import java.net.*;

/*
 * 服务端的侦听类
 */
public class ServerListen extends Thread {
	ServerSocket server;

	JComboBox combobox;
	JTextArea textarea;
	JTextField textfield;
	UserLinkList userLinkList;// 用户链表

	Node client;
	ServerReceive recvThread;

	public boolean isStop;

	/*
	 * 聊天服务端的用户上线于下线侦听类
	 */
	public ServerListen(ServerSocket server, JComboBox combobox,
			JTextArea textarea, JTextField textfield, UserLinkList userLinkList) {

		this.server = server;
		this.combobox = combobox;
		this.textarea = textarea;
		this.textfield = textfield;
		this.userLinkList = userLinkList;

		isStop = false;
	}

	public void run() {
		while (!isStop && !server.isClosed()) {
			try {
				client = new Node();
				client.socket = server.accept();
				client.output = new ObjectOutputStream(
						client.socket.getOutputStream());
				client.output.flush();
				client.input = new ObjectInputStream(
						client.socket.getInputStream());
				client.username = (String) client.input.readObject();

				// 显示提示信息
				combobox.addItem(client.username);
				userLinkList.addUser(client);
				textarea.append("用户 " + client.username + " 上线" + "\n");
				textfield.setText("在线用户" + userLinkList.getCount() + "人\n");

				recvThread = new ServerReceive(textarea, textfield, combobox,
						client, userLinkList);
				recvThread.start();
			} catch (Exception e) {
			}
		}
	}
}