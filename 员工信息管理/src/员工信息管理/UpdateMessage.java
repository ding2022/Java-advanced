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

public class UpdateMessage implements ActionListener{
	Dialog dialog;
	UpdateMessage(JFrame f) {
		dialog = new JDialog(f, "�޸�Ա����Ϣ(���ݲ�ͬ�Ĳ��ҷ�ʽ����С���ҷ�Χ��������ѡ��)", true);
		Container dialogpane = ((JDialog) dialog).getContentPane();
		dialogpane.setLayout(new GridLayout(7, 2));

		JButton b1 = new JButton("���� Ա����� �޸�");
		b1.addActionListener(this);
		dialogpane.add(b1);

		JButton b2 = new JButton("���� Ա������ �޸�");
		b2.addActionListener(this);
		dialogpane.add(b2);

		JButton b3 = new JButton("���� ���ű�� �޸�");
		b3.addActionListener(this);
		dialogpane.add(b3);

		JButton b4 = new JButton("���� ְ�� �޸�");
		b4.addActionListener(this);
		dialogpane.add(b4);

		JButton b5 = new JButton("���� ���� �޸�");
		b5.addActionListener(this);
		dialogpane.add(b5);

		JButton b6 = new JButton("���� ѧ����� �޸�");
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
		UpdateWay sw = new UpdateWay();

		if (cmd.equals("���� Ա����� �޸�")) {
			sw.UpdateById(f);

		} else if (cmd.equals("���� Ա������ �޸�")) {
			sw.UpdateByName(f);

		} else if (cmd.equals("���� ���ű�� �޸�")) {
			sw.UpdateByDepID(f);

		} else if (cmd.equals("���� ְ�� �޸�")) {
			sw.UpdateByWork(f);

		} else if (cmd.equals("���� ���� �޸�")) {
			sw.UpdateBySalary(f);

		} else if (cmd.equals("���� ѧ����� �޸�")) {
			sw.UpdateByEduID(f);

		} else if (cmd.equals("������")) {
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
	JTextField tf = new JTextField();// �ı�����
	JTextField tf2=new JTextField();//����Ҫ�޸ĵ�Ա�����
	String id;//�������
	String XiangMu;//��������
	String id2;//Ҫ�޸ĵ�Ա�����
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("�޸���Ϣ")) {
			sure = true;
			String	neirong=tf.getText().toString().trim();
			UpdateResult(id,XiangMu,neirong,sure);
			System.out.println(id2);
			
			dialog.dispose();
			System.out.println("queding"+sure);
		}else if (cmd.equals("������Ϣ")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("ɾ����Ϣ")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("ɾ����Ϣ")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("ȡ���޸�")) {
			//System.exit(0);
			dialog.dispose();
		}else if (cmd.equals("ȡ��")) {
			//System.exit(0);
			updateDialog.dispose();
		}
	}
	public void UpdateById(JFrame f) {
		String title = "��Ա������޸�", message = "������Ҫ�޸ĵ�Ա���ı��:";
		id=title;
		XiangMu="id";
		UpdateMethod(title, message);
		//UpdateResult(title, "id", sure);
	}

	public void UpdateByName(JFrame f) {
		String title = "��Ա�������޸�", message = "������Ҫ�޸ĵ�Ա������:";
		id=title;
		XiangMu="name";
		UpdateMethod(title, message);
		//UpdateResult(title, "name", sure);
		// UpdateMethod(f, title, message,"name");

	}

	public void UpdateByDepID(JFrame f) {
		String title = "�Բ��ű���޸�", message = "������Ҫ�޸ĵĲ��ű��:";
		id=title;
		XiangMu="depId";
		UpdateMethod(title, message);
		//UpdateResult(title, "depId", sure);
		// UpdateMethod(f, title, message);

	}

	public void UpdateByWork(JFrame f) {
		String title = "��ְ���޸�", message = "������Ҫ�޸ĵ�ְ��:";
		id=title;
		XiangMu="work";
		UpdateMethod(title, message);
		//UpdateResult(title, "work", sure);
		// UpdateMethod(f, title, message);

	}

	public void UpdateBySalary(JFrame f) {
		String title = "�Թ����޸�", message = "������Ҫ�޸ĵĹ���:";
		id=title;
		XiangMu="salary";
		UpdateMethod(title, message);
		//UpdateResult(title,"salary", sure);
		// UpdateMethod(f, title, message);

	}

	public void UpdateByEduID(JFrame f) {
		String title = "��ѧ������޸�", message = "������Ҫ�޸ĵ�ѧ�����:";
		id=title;
		XiangMu="eduid";
		UpdateMethod(title, message);
		//UpdateResult(title, "eduid", sure);
		// UpdateMethod(f, title, message);

	}

	private void UpdateMethod(String title, String message) {
		
		JFrame f = null;
		dialog = new JDialog(f, title, true);// �����Ի���
		Container dialogpane = dialog.getContentPane();// ������

		dialogpane.setLayout(new GridLayout(2, 2));
		dialogpane.add(new JLabel(message, SwingConstants.CENTER));
		dialogpane.add(new JLabel("��ע���������ɸѡ��Ϣ��", SwingConstants.CENTER));
		dialogpane.add(tf);

		JButton b1 = new JButton("�޸���Ϣ");
		dialogpane.add(b1);
		JButton b2 = new JButton("����ɾ����Ϣ");
		dialogpane.add(b2);
		JButton b3 = new JButton("ȡ���޸�");
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
			//		+ tField.getText().toString();// sql ÿ�ֹ��ܵĲ���
			if (sure) {
			
			String sql = "select * from person where "+item+"="+NeiRong;
			ZSGC zsgc = new ZSGC();// ������ ���� ����
			Statement stmt = zsgc.getStmt(); // �������� ���õ�statement����
			
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
				String showmessage=title
						+ " ��Ա���ܹ��У�"
						+ i
						+ " ��\n\n��ϸ��Ϣ:\n\n "
						+ list.toString().replace(",", "").replace("[", "")
								.replace("]", "");
			//	JOptionPane.showMessageDialog(f,showmessage);
				
				dialog.dispose();
				updateDialog=new JDialog(f2, title, true);
				Container dialogpane = ((JDialog) updateDialog).getContentPane();// ������
				dialogpane.setLayout(new GridLayout(10, 1));
				dialogpane.add(new JLabel(showmessage, SwingConstants.CENTER));
				dialogpane.add(new JLabel("\n��ѡ���޸�Ŀ���Ա����ţ�", SwingConstants.CENTER));
				dialogpane.add(tf2);
				JButton b1 = new JButton("������Ϣ");
				dialogpane.add(b1);
				JButton b2 = new JButton("ɾ����Ϣ");
				dialogpane.add(b2);
				JButton b3 = new JButton("ȡ��");
				dialogpane.add(b3);

				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);

				updateDialog.setBounds(400, 300, 500, 500);
				updateDialog.show();
				
				id2=tf2.getText().toString().trim();//���һ�����ĵط�
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�޸Ĵ���");
				e.printStackTrace();
			} finally {
				JdbcUtils.release(stmt, null, rs);
			}
		} else {

		}
	}
}

