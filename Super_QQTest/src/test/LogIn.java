package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogIn implements ActionListener {

	JFrame f = null;
	JTextField login_TF;
	public LogIn(){
		f=new JFrame("Super_QQ--ºÆÃô¿Æ¼¼");
		Container container=f.getContentPane();
		
		JPanel panel=new JPanel();
		
		login_TF=new JTextField(10);
		panel.add(login_TF);
		
		JButton bt_login=new JButton("µÇÂ½");
		bt_login.addActionListener(this);
		panel.add(bt_login);
		
		container.add(panel);
		
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		if(cmd.equals("µÇÂ½")){
			UserName.setUsername(login_TF.getText().trim());
			/*try {
				new EchoClient();
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
			f.setVisible(false);
			//new MainView();
		}
	}
	public static void main(String[] args) {
		new LogIn();
	}
}