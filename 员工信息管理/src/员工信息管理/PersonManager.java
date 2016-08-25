package 员工信息管理;

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
		dialog = new JDialog(f, "员工登记", true);// 弹出对话框
		Container dialogpane = dialog.getContentPane();// 添加组件
		dialogpane.setLayout(new GridLayout(7, 2));

		dialogpane.add(new JLabel("员工编号:", SwingConstants.CENTER));
		dialogpane.add(tf1);
		dialogpane.add(new JLabel("员工姓名:", SwingConstants.CENTER));
		dialogpane.add(tf2);
		dialogpane.add(new JLabel("部门编号:", SwingConstants.CENTER));
		dialogpane.add(tf3);
		dialogpane.add(new JLabel("职务:", SwingConstants.CENTER));
		dialogpane.add(tf4);
		dialogpane.add(new JLabel("工资:", SwingConstants.CENTER));
		dialogpane.add(tf5);
		dialogpane.add(new JLabel("学历编号:", SwingConstants.CENTER));
		dialogpane.add(tf6);

		JButton b1 = new JButton("确定");
		dialogpane.add(b1);
		JButton b2 = new JButton("取消");
		dialogpane.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		dialog.setBounds(400, 300, 600, 260);
		dialog.show();
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("确定")) {
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
				// Class.forName(DBDriver).newInstance();//加载驱动到内存

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
				//预防注入式攻击
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
				 * sQLString="insert into　person(id,name,depId,work,salary,eduid)"
				 * + "values(12,'qery',13,'ere132',1342,133)";
				 */
				int num = stmt.executeUpdate(sQLString);
				if (num > 0) {
					//System.out.println("right");
					JOptionPane.showMessageDialog(null, "注册成功");
				}

				// stmt.close();
				// connection1.close();
				// dialog.dispose();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "存在非法数据，请仔细核对！");
				// System.err.println("存在非法数据，请仔细核对！");
			} finally {
				try {
					stmt.close();
					connection1.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				dialog.dispose();
			}
		} else if (cmd.equals("取消")) {
			dialog.dispose();
		}
	}

}

public class PersonManager implements ActionListener {//

	JFrame f = null;

	public PersonManager() {
		f = new JFrame("员工信息");

		Container containerPane = f.getContentPane();
		JPanel buttonPanel = new JPanel();

		JButton b = new JButton("员工登记");
		b.addActionListener(this);// 设置一个监听事件
		buttonPanel.add(b);
		
		b=new JButton("查找信息");
		b.addActionListener(this);// 设置一个监听事件
		buttonPanel.add(b);
		
		b=new JButton("修改信息");
		b.addActionListener(this);// 设置一个监听事件
		buttonPanel.add(b);

		b = new JButton("退出系统");
		b.addActionListener(this);
		buttonPanel.add(b);
		// 布局
		
		buttonPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.blue, 4), "员工登记系统",
				TitledBorder.CENTER, TitledBorder.TOP));
		containerPane.add(buttonPanel, BorderLayout.CENTER);

		JMenuBar mBar = new JMenuBar();
		JMenu selection = new JMenu("选项");
		JMenuItem regist = new JMenuItem("员工登记");
		JMenuItem sun = new JMenuItem("统计信息");
		JMenuItem exit = new JMenuItem("退出系统");
		
		selection.add(regist);
		selection.add(sun);
		selection.add(exit);

		JMenu sys = new JMenu("帮助");
		JMenuItem introduce = new JMenuItem("软件功能介绍");
		
		sys.add(introduce);

		mBar.add(selection);
		mBar.add(sys);
		f.setJMenuBar(mBar);// 为窗体增加菜单

		regist.addActionListener(this);
		sun.addActionListener(this);
		introduce.addActionListener(this);
		exit.addActionListener(this);

		f.pack();
		f.setVisible(true);
		// 添加窗口事件
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if (cmd.equals("员工登记")) {
		
			new RegistSystem(f);
		
		} else if (cmd.equals("退出系统")) {
			
			System.exit(0);
		}else if(cmd.equals("软件功能介绍")){
			JOptionPane.showMessageDialog(null, 
					"本软件由风豪开发\n如有疑问请联系\nfenghao4321@163.com"+
					"\n基本功能介绍：\n"
					+"添加信息"+"\n修改（更新，删除等）"+"\n查找"+"\n统计所有员工信息"
					+"\n后续开发中"
					+ "\n欢迎使用！"
					);
		}else if(cmd.equals("修改信息")){
			new UpdateMessage(f);
		}else if(cmd.equals("查找信息")){
			new SearchMessage(f);
		}
		else if (cmd.equals("统计信息")) {
			try {

				// Class.forName("com.mysql.jdbc.Driver()");//加载驱动器
				// 和数据库建立连接
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
					stringBuilder.append("员工编号:" + rs.getInt("id") + "   员工姓名:"
							+ rs.getObject("name").toString() + "   部门编号:"
							+ rs.getInt("depId") + "   职务:  "
							+ rs.getObject("work").toString() + "   工资:  "
							+ rs.getInt("salary") + "   学历编号:"
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
				JOptionPane.showMessageDialog(f, "共有员工："
						+ i
						+ " 名\n详细信息:\n\n "
						+ list.toString().replace(",", "").replace("[", "")
								.replace("]", ""));

				stmt.close();
				con.close();
				rs.close();
			} catch (Exception e1) {
				System.err.println("连接失败");
				JOptionPane.showMessageDialog(null, "连接失败");
			}
		}
	}

	public static void main(String[] args) {
		new PersonManager();
	}
}
