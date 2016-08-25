package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModelChoose implements ActionListener {
	JFrame f = null;

	public ModelChoose() {
		f = new JFrame(UserName.getUsername() + "--�����Ƽ�");
		f.setBounds(100, 100, 450, 300);
		Container container = f.getContentPane();
		JPanel panel = new JPanel();

		JButton asClient = new JButton("��Ϊ�ͻ���");
		JButton asServer = new JButton("��Ϊ������");
		asClient.addActionListener(this);
		asServer.addActionListener(this);
		panel.add(asClient);
		panel.add(asServer);

		container.add(panel);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.pack();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("��Ϊ�ͻ���")) {
			new GUI_Client();
			f.setVisible(false);
		} else if (cmd.equals("��Ϊ������")) {
			new GUI_Server();
			f.setVisible(false);
		}
	}
	public static void main(String[] args) {
		new ModelChoose();
	}
}
