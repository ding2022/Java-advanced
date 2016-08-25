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

public class UpdateMessage implements ActionListener{
	Dialog dialog;
	UpdateMessage(JFrame f) {
		dialog = new JDialog(f, "修改员工信息(根据不同的查找方式来缩小查找范围，更便于选择)", true);
		Container dialogpane = ((JDialog) dialog).getContentPane();
		dialogpane.setLayout(new GridLayout(7, 2));

		JButton b1 = new JButton("根据 员工编号 修改");
		b1.addActionListener(this);
		dialogpane.add(b1);

		JButton b2 = new JButton("根据 员工姓名 修改");
		b2.addActionListener(this);
		dialogpane.add(b2);

		JButton b3 = new JButton("根据 部门编号 修改");
		b3.addActionListener(this);
		dialogpane.add(b3);

		JButton b4 = new JButton("根据 职务 修改");
		b4.addActionListener(this);
		dialogpane.add(b4);

		JButton b5 = new JButton("根据 工资 修改");
		b5.addActionListener(this);
		dialogpane.add(b5);

		JButton b6 = new JButton("根据 学历编号 修改");
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
		UpdateWay sw = new UpdateWay();

		if (cmd.equals("根据 员工编号 修改")) {
			sw.UpdateById(f);

		} else if (cmd.equals("根据 员工姓名 修改")) {
			sw.UpdateByName(f);

		} else if (cmd.equals("根据 部门编号 修改")) {
			sw.UpdateByDepID(f);

		} else if (cmd.equals("根据 职务 修改")) {
			sw.UpdateByWork(f);

		} else if (cmd.equals("根据 工资 修改")) {
			sw.UpdateBySalary(f);

		} else if (cmd.equals("根据 学历编号 修改")) {
			sw.UpdateByEduID(f);

		} else if (cmd.equals("不找了")) {
			//System.exit(0);
			dialog.dispose();
		}
	}
}

class UpdateWay implements ActionListener {
	boolean sure = false;
	JDialog dialog;
	JDialog updateDialog;
	//JTextField tField=null; 
	JTextField tf = new JTextField();// 文本输入
	JTextField tf2=new JTextField();//输入要修改的员工编号
	String id;//结果类型
	String XiangMu;//搜索的项
	String id2;//要修改的员工编号
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("修改信息")) {
			sure = true;
			String	neirong=tf.getText().toString().trim();
			UpdateResult(id,XiangMu,neirong,sure);
			System.out.println(id2);
			
			dialog.dispose();
			System.out.println("queding"+sure);
		}else if (cmd.equals("更新信息")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("删除信息")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("删除信息")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("取消修改")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("取消")) {
			//System.exit(0);
			updateDialog.dispose();
		}
	}
	public void UpdateById(JFrame f) {
		String title = "以员工编号修改", message = "请输入要修改的员工的编号:";
		id=title;
		XiangMu="id";
		UpdateMethod(title, message);
		//UpdateResult(title, "id", sure);
	}

	public void UpdateByName(JFrame f) {
		String title = "以员工姓名修改", message = "请输入要修改的员工姓名:";
		id=title;
		XiangMu="name";
		UpdateMethod(title, message);
		//UpdateResult(title, "name", sure);
		// UpdateMethod(f, title, message,"name");

	}

	public void UpdateByDepID(JFrame f) {
		String title = "以部门编号修改", message = "请输入要修改的部门编号:";
		id=title;
		XiangMu="depId";
		UpdateMethod(title, message);
		//UpdateResult(title, "depId", sure);
		// UpdateMethod(f, title, message);

	}

	public void UpdateByWork(JFrame f) {
		String title = "以职务修改", message = "请输入要修改的职务:";
		id=title;
		XiangMu="work";
		UpdateMethod(title, message);
		//UpdateResult(title, "work", sure);
		// UpdateMethod(f, title, message);

	}

	public void UpdateBySalary(JFrame f) {
		String title = "以工资修改", message = "请输入要修改的工资:";
		id=title;
		XiangMu="salary";
		UpdateMethod(title, message);
		//UpdateResult(title,"salary", sure);
		// UpdateMethod(f, title, message);

	}

	public void UpdateByEduID(JFrame f) {
		String title = "以学历编号修改", message = "请输入要修改的学历编号:";
		id=title;
		XiangMu="eduid";
		UpdateMethod(title, message);
		//UpdateResult(title, "eduid", sure);
		// UpdateMethod(f, title, message);

	}

	private void UpdateMethod(String title, String message) {
		
		JFrame f = null;
		dialog = new JDialog(f, title, true);// 弹出对话框
		Container dialogpane = dialog.getContentPane();// 添加组件

		dialogpane.setLayout(new GridLayout(2, 2));
		dialogpane.add(new JLabel(message, SwingConstants.CENTER));
		dialogpane.add(new JLabel("（注意输入的是筛选信息）", SwingConstants.CENTER));
		dialogpane.add(tf);

		JButton b1 = new JButton("修改信息");
		dialogpane.add(b1);
		JButton b2 = new JButton("批量删除信息");
		dialogpane.add(b2);
		JButton b3 = new JButton("取消修改");
		dialogpane.add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		dialog.setBounds(400, 300, 500, 100);
		dialog.show();
		//return tf;
	}

	private void UpdateResult(String title,	String item, String NeiRong,boolean sure) {
		JFrame f=null;
		JFrame f2=null;
			//String sql = "select * from person where" + item + "="
			//		+ tField.getText().toString();// sql 每种功能的操作
			if (sure) {
			
			String sql = "select * from person where "+item+"="+NeiRong;
			ZSGC zsgc = new ZSGC();// 帮助类 连接 操作
			Statement stmt = zsgc.getStmt(); // 建立连接 并得到statement对象
			
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
				String showmessage=title
						+ " 的员工总共有："
						+ i
						+ " 名\n\n详细信息:\n\n "
						+ list.toString().replace(",", "").replace("[", "")
								.replace("]", "");
			//	JOptionPane.showMessageDialog(f,showmessage);
				
				dialog.dispose();
				updateDialog=new JDialog(f2, title, true);
				Container dialogpane = ((JDialog) updateDialog).getContentPane();// 添加组件
				dialogpane.setLayout(new GridLayout(10, 1));
				dialogpane.add(new JLabel(showmessage, SwingConstants.CENTER));
				dialogpane.add(new JLabel("\n请选择修改目标的员工编号：", SwingConstants.CENTER));
				dialogpane.add(tf2);
				JButton b1 = new JButton("更新信息");
				dialogpane.add(b1);
				JButton b2 = new JButton("删除信息");
				dialogpane.add(b2);
				JButton b3 = new JButton("取消");
				dialogpane.add(b3);

				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);

				updateDialog.setBounds(400, 300, 500, 500);
				updateDialog.show();
				
				id2=tf2.getText().toString().trim();//最后一次做的地方
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "修改错误");
				e.printStackTrace();
			} finally {
				JdbcUtils.release(stmt, null, rs);
			}
		} else {

		}
	}
}

