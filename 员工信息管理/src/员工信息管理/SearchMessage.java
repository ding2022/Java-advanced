package Ա����Ϣ����;

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
		dialog = new JDialog(f, "������Ϣ", true);
		Container dialogpane = dialog.getContentPane();
		dialogpane.setLayout(new GridLayout(7, 2));

		JButton b1 = new JButton("���� Ա����� ����");
		b1.addActionListener(this);
		dialogpane.add(b1);

		JButton b2 = new JButton("���� Ա������ ����");
		b2.addActionListener(this);
		dialogpane.add(b2);

		JButton b3 = new JButton("���� ���ű�� ����");
		b3.addActionListener(this);
		dialogpane.add(b3);

		JButton b4 = new JButton("���� ְ�� ����");
		b4.addActionListener(this);
		dialogpane.add(b4);

		JButton b5 = new JButton("���� ���� ����");
		b5.addActionListener(this);
		dialogpane.add(b5);

		JButton b6 = new JButton("���� ѧ����� ����");
		b6.addActionListener(this);
		dialogpane.add(b6);

		JButton b7 = new JButton("������");
		b7.addActionListener(this);
		dialogpane.add(b7);

		dialog.setBounds(400, 300, 300, 290);
		dialog.show();
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		String cmd = e.getActionCommand();
		SearchWay sw = new SearchWay();

		if (cmd.equals("���� Ա����� ����")) {
			sw.SearchById(f);

		} else if (cmd.equals("���� Ա������ ����")) {
			sw.SearchByName(f);

		} else if (cmd.equals("���� ���ű�� ����")) {
			sw.SearchByDepID(f);

		} else if (cmd.equals("���� ְ�� ����")) {
			sw.SearchByWork(f);

		} else if (cmd.equals("���� ���� ����")) {
			sw.SearchBySalary(f);

		} else if (cmd.equals("���� ѧ����� ����")) {
			sw.SearchByEduID(f);

		} else if (cmd.equals("������")) {
			//System.exit(0);
			dialog.dispose();
		}
	}
}

class SearchWay implements ActionListener {
	boolean sure = false;
	JDialog dialog;
	//JTextField tField=null; 
	JTextField tf = new JTextField();// �ı�����
	String id;//�������
	String XiangMu;//��������
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("ȷ��")) {
			sure = true;
			String	neirong=tf.getText().toString().trim();
			SearchResult(id,XiangMu,neirong,sure);
			dialog.dispose();
			System.out.println("queding"+sure);
		} else if (cmd.equals("ȡ��")) {
			//System.exit(0);
			dialog.dispose();
		}
	}
	public void SearchById(JFrame f) {
		String title = "��Ա����Ų���", message = "������Ҫ���ҵ�Ա�����:";
		id=title;
		XiangMu="id";
		searchMethod(title, message);
		//SearchResult(title, "id", sure);
	}

	public void SearchByName(JFrame f) {
		String title = "��Ա����������", message = "������Ҫ���ҵ�Ա������:";
		id=title;
		XiangMu="name";
		searchMethod(title, message);
		//SearchResult(title, "name", sure);
		// searchMethod(f, title, message,"name");

	}

	public void SearchByDepID(JFrame f) {
		String title = "�Բ��ű�Ų���", message = "������Ҫ���ҵĲ��ű��:";
		id=title;
		XiangMu="depId";
		searchMethod(title, message);
		//SearchResult(title, "depId", sure);
		// searchMethod(f, title, message);

	}

	public void SearchByWork(JFrame f) {
		String title = "��ְ�����", message = "������Ҫ���ҵ�ְ��:";
		id=title;
		XiangMu="work";
		searchMethod(title, message);
		//SearchResult(title, "work", sure);
		// searchMethod(f, title, message);

	}

	public void SearchBySalary(JFrame f) {
		String title = "�Թ��ʲ���", message = "������Ҫ���ҵĹ���:";
		id=title;
		XiangMu="salary";
		searchMethod(title, message);
		//SearchResult(title,"salary", sure);
		// searchMethod(f, title, message);

	}

	public void SearchByEduID(JFrame f) {
		String title = "��ѧ����Ų���", message = "������Ҫ���ҵ�ѧ�����:";
		id=title;
		XiangMu="eduid";
		searchMethod(title, message);
		//SearchResult(title, "eduid", sure);
		// searchMethod(f, title, message);

	}

	private void searchMethod(String title, String message) {
		
		JFrame f = null;
		dialog = new JDialog(f, title, true);// �����Ի���
		Container dialogpane = dialog.getContentPane();// ������

		dialogpane.setLayout(new GridLayout(2, 2));
		dialogpane.add(new JLabel(message, SwingConstants.CENTER));
		dialogpane.add(tf);

		JButton b1 = new JButton("ȷ��");
		dialogpane.add(b1);
		JButton b2 = new JButton("ȡ��");
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
			//		+ tField.getText().toString();// sql ÿ�ֹ��ܵĲ���
			String sql = "select * from person where "+item+"="+NeiRong;
			ZSGC zsgc = new ZSGC();// ������ ���� ����
			Statement stmt = zsgc.getStmt(); // �������� ���õ�statement����
			
			System.out.println(stmt);
			ResultSet rs = null; // �õ������

			try {
				rs = stmt.executeQuery(sql);
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
				}
				JOptionPane.showMessageDialog(f,title
						+ " ��Ա���ܹ��У�"
						+ i
						+ " ��\n��ϸ��Ϣ:\n\n "
						+ list.toString().replace(",", "").replace("[", "")
								.replace("]", ""));

			} catch (SQLException e) {
				// System.err.println("����ʧ��");
				JOptionPane.showMessageDialog(null, "���Ҵ���");
				e.printStackTrace();
			} finally {
				JdbcUtils.release(stmt, null, rs);
			}
		} else {

		}
	}
}
