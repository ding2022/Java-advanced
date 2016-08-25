/*package 浏览器;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class Brower extends JFrame{
	JLabel jLabel;
	JTextField jtf;
	JEditorPane edpl;
	public Brower(){
		super("Brower");
		Container con=getContentPane();
		jLabel =new JLabel("请输入要访问的网址：");
		jtf=new JTextField("");
		jtf.addActionListener(new MyFieldDealing());
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(jLabel);
		panel.add(jtf);
		con.add(panel,BorderLayout.NORTH);
		edpl=new JEditorPane();
		edpl.setEditable(false);
		edpl.addHyperlinkListener(new MyFieldDealing());
		con.add(new JScrollPane(edpl),BorderLayout.CENTER);
		setSize(600,800);
		setVisible(true);
	}
	void getPage(String site){
		try{
			edpl.setPage(site);
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "连接错误","错误提示",JOptionPane.ERROR_MESSAGE);
		}
	}
	class MyEnter implements ActionListener{ //处理输入网址时的回车操作
		public void actionPerformed(ActionEvent e){
			String string=jtf.getText();
			getPage(string);
		}
	}
	class MyHyperListener implements HyperlinkListener{//处理网页中的链接
		public void hyperlinkUpdate(HyperlinkListener e){
			if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
				String string =e.getURL().toString();
				getPage(string);
			}
		}
	}
	public static void main(String[] args) {
		Brower myBrower=new Brower();
		myBrower.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
*/