package Ա����Ϣ����;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.haofeng.JDBCutils.JdbcUtils;

class RegistSystem implements ActionListener {

	JDialog dialog;
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();

	RegistSystem(JFrame f) {
		dialog = new JDialog(f, "Ա���Ǽ�", true);// �����Ի���
		Container dialogpane = dialog.getContentPane();// ������
		dialogpane.setLayout(new GridLayout(7, 2));

		dialogpane.add(new JLabel("Ա�����:", SwingConstants.CENTER));
		dialogpane.add(tf1);
		dialogpane.add(new JLabel("Ա������:", SwingConstants.CENTER));
		dialogpane.add(tf2);
		dialogpane.add(new JLabel("���ű��:", SwingConstants.CENTER));
		dialogpane.add(tf3);
		dialogpane.add(new JLabel("ְ��:", SwingConstants.CENTER));
		dialogpane.add(tf4);
		dialogpane.add(new JLabel("����:", SwingConstants.CENTER));
		dialogpane.add(tf5);
		dialogpane.add(new JLabel("ѧ�����:", SwingConstants.CENTER));
		dialogpane.add(tf6);

		JButton b1 = new JButton("ȷ��");
		dialogpane.add(b1);
		JButton b2 = new JButton("ȡ��");
		dialogpane.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		dialog.setBounds(400, 300, 600, 260);
		dialog.show();
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("ȷ��")) {
			Connection connection1 = null;
			Statement stmt = null;
			try {
				// Class.forName("");
				// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				// Connection
				// connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/PIMS");

				/*
				 * String con="jdbc:mysql://localhost:3306/PIMS";
				 * DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				 * Connection
				 * connection1=DriverManager.getConnection(con,"root",
				 * "haofeng");
				 */
				/*String con = "jdbc:mysql://localhost:3306/PIMS";

				// ResultSet rs=null;
				// Class.forName(DBDriver).newInstance();//�����������ڴ�

				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection1 = DriverManager.getConnection(con, "root",
						"haofeng");*/
				Connection con=JdbcUtils.getConnection();

				stmt = con.createStatement();
				//
				int ID = Integer.parseInt(tf1.getText());
				String name = tf2.getText();
				int depId = Integer.parseInt(tf3.getText());
				String work = tf4.getText();
				int salary = Integer.parseInt(tf5.getText());
				int eduid = Integer.parseInt(tf6.getText());

				/*System.out.println(ID + " " + name + " " + depId + " " + work
						+ " " + salary + " " + eduid);*/
				// int DepID=Integer.parseInt(tf3.getText());
				// String Occupation =tf4.getText();
				//Ԥ��ע��ʽ����
				String sQLString = "insert into person(id,name,depId,work,salary,eduid)values("
						+ ID
						+ ",'"
						+ name
						+ "',"
						+ depId
						+ ",'"
						+ work
						+ "',"
						+ salary + "," + eduid + ")";
				/*
				 * String
				 * sQLString="insert into��person(id,name,depId,work,salary,eduid)"
				 * + "values(12,'qery',13,'ere132',1342,133)";
				 */
				int num = stmt.executeUpdate(sQLString);
				if (num > 0) {
					//System.out.println("right");
					JOptionPane.showMessageDialog(null, "ע��ɹ�");
				}

				// stmt.close();
				// connection1.close();
				// dialog.dispose();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "���ڷǷ����ݣ�����ϸ�˶ԣ�");
				// System.err.println("���ڷǷ����ݣ�����ϸ�˶ԣ�");
			} finally {
				try {
					stmt.close();
					connection1.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				dialog.dispose();
			}
		} else if (cmd.equals("ȡ��")) {
			dialog.dispose();
		}
	}

}

public class PersonManager implements ActionListener {//

	JFrame f = null;

	public PersonManager() {
		f = new JFrame("Ա����Ϣ");

		Container containerPane = f.getContentPane();
		JPanel buttonPanel = new JPanel();

		JButton b = new JButton("Ա���Ǽ�");
		b.addActionListener(this);// ����һ�������¼�
		buttonPanel.add(b);
		
		b=new JButton("������Ϣ");
		b.addActionListener(this);// ����һ�������¼�
		buttonPanel.add(b);
		
		b=new JButton("�޸���Ϣ");
		b.addActionListener(this);// ����һ�������¼�
		buttonPanel.add(b);

		b = new JButton("�˳�ϵͳ");
		b.addActionListener(this);
		buttonPanel.add(b);
		// ����
		
		buttonPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.blue, 4), "Ա���Ǽ�ϵͳ",
				TitledBorder.CENTER, TitledBorder.TOP));
		containerPane.add(buttonPanel, BorderLayout.CENTER);

		JMenuBar mBar = new JMenuBar();
		JMenu selection = new JMenu("ѡ��");
		JMenuItem regist = new JMenuItem("Ա���Ǽ�");
		JMenuItem sun = new JMenuItem("ͳ����Ϣ");
		JMenuItem exit = new JMenuItem("�˳�ϵͳ");
		
		selection.add(regist);
		selection.add(sun);
		selection.add(exit);

		JMenu sys = new JMenu("����");
		JMenuItem introduce = new JMenuItem("������ܽ���");
		
		sys.add(introduce);

		mBar.add(selection);
		mBar.add(sys);
		f.setJMenuBar(mBar);// Ϊ�������Ӳ˵�

		regist.addActionListener(this);
		sun.addActionListener(this);
		introduce.addActionListener(this);
		exit.addActionListener(this);

		f.pack();
		f.setVisible(true);
		// ��Ӵ����¼�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if (cmd.equals("Ա���Ǽ�")) {
		
			new RegistSystem(f);
		
		} else if (cmd.equals("�˳�ϵͳ")) {
			
			System.exit(0);
		}else if(cmd.equals("������ܽ���")){
			JOptionPane.showMessageDialog(null, 
					"������ɷ������\n������������ϵ\nfenghao4321@163.com"+
					"\n�������ܽ��ܣ�\n"
					+"�����Ϣ"+"\n�޸ģ����£�ɾ���ȣ�"+"\n����"+"\nͳ������Ա����Ϣ"
					+"\n����������"
					+ "\n��ӭʹ�ã�"
					);
		}else if(cmd.equals("�޸���Ϣ")){
			new UpdateMessage(f);
		}else if(cmd.equals("������Ϣ")){
			new SearchMessage(f);
		}
		else if (cmd.equals("ͳ����Ϣ")) {
			try {

				// Class.forName("com.mysql.jdbc.Driver()");//����������
				// �����ݿ⽨������
				/*DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/PIMS", "root", "haofeng");*/
				Connection con=JdbcUtils.getConnection();

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from person");
				int i = 0;
				ArrayList<String> list = new ArrayList<String>();
				while (rs.next()) {
					i++;
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Ա�����:" + rs.getInt("id") + "   Ա������:"
							+ rs.getObject("name").toString() + "   ���ű��:"
							+ rs.getInt("depId") + "   ְ��:  "
							+ rs.getObject("work").toString() + "   ����:  "
							+ rs.getInt("salary") + "   ѧ�����:"
							+ rs.getInt("eduid") + "\n\n");
					list.add(stringBuilder.toString());

					/*
					 * System.out.println(rs.getInt("id"));
					 * //System.out.println(rs.getClob("name"));
					 * System.out.println(rs.getObject("name").toString());
					 * System.out.println(rs.getInt("depId"));
					 * System.out.println(rs.getObject("work").toString());
					 * //System.out.println(rs.getClob("work"));
					 * System.out.println(rs.getInt("salary"));
					 * System.out.println(rs.getInt("eduid"));
					 * System.out.println();
					 */
				}
				JOptionPane.showMessageDialog(f, "����Ա����"
						+ i
						+ " ��\n��ϸ��Ϣ:\n\n "
						+ list.toString().replace(",", "").replace("[", "")
								.replace("]", ""));

				stmt.close();
				con.close();
				rs.close();
			} catch (Exception e1) {
				System.err.println("����ʧ��");
				JOptionPane.showMessageDialog(null, "����ʧ��");
			}
		}
	}

	public static void main(String[] args) {
		new PersonManager();
	}
}
