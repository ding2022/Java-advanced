package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

public class ConTo implements ActionListener {
	JFrame f = null;
	ListSelectionEvent userList = null;

	public ConTo() {
		f = new JFrame(UserName.getUsername() + " ѡ��Ҫ˽�ĵ���");
		// userList=new ListSelectionEvent(f, 0,userList.countItems(), true);
	}

	public ConTo(int a) {
		f = new JFrame(UserName.getUsername() + " ѡ��ҪȺ�ĵ���");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("˽��")) {
			String s = UserName.getUsername();
			UserName.setUsername("˽��: " + s + " ���ں� " + "" + " ����");
			//new MainView();
		} else if (cmd.equals("Ⱥ��")) {
			String s = UserName.getUsername();
			UserName.setUsername("Ⱥ��: " + s + " ���ں� " + "" + " ����");
			//new MainView();
		}
	}
}
