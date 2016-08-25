package 员工信息管理;


import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ServletTest extends JApplet {

	create c=new create();
	
	public static void main(String[] args) {
		
	}
	class create{
		public void init() {
			JButton goButton = new JButton("连接到百度");
			Container myContainer = getContentPane();
			myContainer.add(new JLabel("连接到百度"), BorderLayout.NORTH);
			myContainer.add(goButton, BorderLayout.SOUTH);
			goButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						URL newdocument = new URL("http://www.baidu.com");
						AppletContext browser = getAppletContext();
						browser.showDocument(newdocument);
					} catch (Exception ex) {
					}
				}
			});
		}
	}
}
