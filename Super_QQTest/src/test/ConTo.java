package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

public class ConTo implements ActionListener {
	JFrame f = null;
	ListSelectionEvent userList = null;

	public ConTo() {
		f = new JFrame(UserName.getUsername() + " 选择要私聊的人");
		// userList=new ListSelectionEvent(f, 0,userList.countItems(), true);
	}

	public ConTo(int a) {
		f = new JFrame(UserName.getUsername() + " 选择要群聊的人");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("私聊")) {
			String s = UserName.getUsername();
			UserName.setUsername("私聊: " + s + " 正在和 " + "" + " 聊天");
			//new MainView();
		} else if (cmd.equals("群聊")) {
			String s = UserName.getUsername();
			UserName.setUsername("群聊: " + s + " 正在和 " + "" + " 聊天");
			//new MainView();
		}
	}
}
