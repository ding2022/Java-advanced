package 员工信息管理;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.haofeng.JDBCutils.JdbcUtils;
import com.haofeng.JDBCutils.ZSGC;

public class SearchMessage implements ActionListener {
	JDialog dialog;

	SearchMessage(JFrame f) {
		dialog = new JDialog(f, "查找信息", true);
		Container dialogpane = dialog.getContentPane();
		dialogpane.setLayout(new GridLayout(7, 2));

		JButton b1 = new JButton("根据 员工编号 查找");
		b1.addActionListener(this);
		dialogpane.add(b1);

		JButton b2 = new JButton("根据 员工姓名 查找");
		b2.addActionListener(this);
		dialogpane.add(b2);

		JButton b3 = new JButton("根据 部门编号 查找");
		b3.addActionListener(this);
		dialogpane.add(b3);

		JButton b4 = new JButton("根据 职务 查找");
		b4.addActionListener(this);
		dialogpane.add(b4);

		JButton b5 = new JButton("根据 工资 查找");
		b5.addActionListener(this);
		dialogpane.add(b5);

		JButton b6 = new JButton("根据 学历编号 查找");
		b6.addActionListener(this);
		dialogpane.add(b6);

		JButton b7 = new JButton("不找了");
		b7.addActionListener(this);
		dialogpane.add(b7);

		dialog.setBounds(400, 300, 300, 290);
		dialog.show();
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		String cmd = e.getActionCommand();
		SearchWay sw = new SearchWay();

		if (cmd.equals("根据 员工编号 查找")) {
			sw.SearchById(f);

		} else if (cmd.equals("根据 员工姓名 查找")) {
			sw.SearchByName(f);

		} else if (cmd.equals("根据 部门编号 查找")) {
			sw.SearchByDepID(f);

		} else if (cmd.equals("根据 职务 查找")) {
			sw.SearchByWork(f);

		} else if (cmd.equals("根据 工资 查找")) {
			sw.SearchBySalary(f);

		} else if (cmd.equals("根据 学历编号 查找")) {
			sw.SearchByEduID(f);

		} else if (cmd.equals("不找了")) {
			//System.exit(0);
			dialog.dispose();
		}
	}
}

class SearchWay implements ActionListener {
	boolean sure = false;
	JDialog dialog;
	//JTextField tField=null; 
	JTextField tf = new JTextField();// 文本输入
	String id;//结果类型
	String XiangMu;//搜索的项
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("确定")) {
			sure = true;
			String	neirong=tf.getText().toString().trim();
			SearchResult(id,XiangMu,neirong,sure);
			dialog.dispose();
			System.out.println("queding"+sure);
		} else if (cmd.equals("取消")) {
			//System.exit(0);
			dialog.dispose();
		}
	}
	public void SearchById(JFrame f) {
		String title = "以员工编号查找", message = "请输入要查找的员工编号:";
		id=title;
		XiangMu="id";
		searchMethod(title, message);
		//SearchResult(title, "id", sure);
	}

	public void SearchByName(JFrame f) {
		String title = "以员工姓名查找", message = "请输入要查找的员工姓名:";
		id=title;
		XiangMu="name";
		searchMethod(title, message);
		//SearchResult(title, "name", sure);
		// searchMethod(f, title, message,"name");

	}

	public void SearchByDepID(JFrame f) {
		String title = "以部门编号查找", message = "请输入要查找的部门编号:";
		id=title;
		XiangMu="depId";
		searchMethod(title, message);
		//SearchResult(title, "depId", sure);
		// searchMethod(f, title, message);

	}

	public void SearchByWork(JFrame f) {
		String title = "以职务查找", message = "请输入要查找的职务:";
		id=title;
		XiangMu="work";
		searchMethod(title, message);
		//SearchResult(title, "work", sure);
		// searchMethod(f, title, message);

	}

	public void SearchBySalary(JFrame f) {
		String title = "以工资查找", message = "请输入要查找的工资:";
		id=title;
		XiangMu="salary";
		searchMethod(title, message);
		//SearchResult(title,"salary", sure);
		// searchMethod(f, title, message);

	}

	public void SearchByEduID(JFrame f) {
		String title = "以学历编号查找", message = "请输入要查找的学历编号:";
		id=title;
		XiangMu="eduid";
		searchMethod(title, message);
		//SearchResult(title, "eduid", sure);
		// searchMethod(f, title, message);

	}

	private void searchMethod(String title, String message) {
		
		JFrame f = null;
		dialog = new JDialog(f, title, true);// 弹出对话框
		Container dialogpane = dialog.getContentPane();// 添加组件

		dialogpane.setLayout(new GridLayout(2, 2));
		dialogpane.add(new JLabel(message, SwingConstants.CENTER));
		dialogpane.add(tf);

		JButton b1 = new JButton("确定");
		dialogpane.add(b1);
		JButton b2 = new JButton("取消");
		dialogpane.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		dialog.setBounds(400, 300, 500, 100);
		dialog.show();
		//return tf;
	}

	private void SearchResult(String title,	String item, String NeiRong,boolean sure) {
		JFrame f=null;
			
			if (sure) {
			//String sql = "select * from person where" + item + "="
			//		+ tField.getText().toString();// sql 每种功能的操作
			String sql = "select * from person where "+item+"="+NeiRong;
			ZSGC zsgc = new ZSGC();// 帮助类 连接 操作
			Statement stmt = zsgc.getStmt(); // 建立连接 并得到statement对象
			
			System.out.println(stmt);
			ResultSet rs = null; // 得到结果集

			try {
				rs = stmt.executeQuery(sql);
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
				}
				JOptionPane.showMessageDialog(f,title
						+ " 的员工总共有："
						+ i
						+ " 名\n详细信息:\n\n "
						+ list.toString().replace(",", "").replace("[", "")
								.replace("]", ""));

			} catch (SQLException e) {
				// System.err.println("连接失败");
				JOptionPane.showMessageDialog(null, "查找错误");
				e.printStackTrace();
			} finally {
				JdbcUtils.release(stmt, null, rs);
			}
		} else {

		}
	}
}
