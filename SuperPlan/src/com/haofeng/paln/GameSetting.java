package com.haofeng.paln;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.haofeng.util.Const;
import com.haofeng.util.GameUtils;

public class GameSetting extends Frame implements ActionListener {

	JFrame f = null;
	Image bg = GameUtils.getImage("images/gsbg.jpg");
	JTextField tf;
	JTextField tf1;
	JTextField tf2;

	public GameSetting() {
		f = new JFrame("不死之心---风豪出品");
		f.setBounds(470, 250, 430, 340);

		myPanel panel = new myPanel();
		myPanel panel2 = new myPanel();

		tf1 = new JTextField("英雄：颜心", 20);
		tf = new JTextField("难度：简单", 20);
		tf2 = new JTextField("背景：简单生活", 20);

		setButton("切换背景", panel);
		setButton("切换英雄", panel);
		setButton("调整难度", panel);
		setButton("磨练我心", panel);

		panel.add(tf2);
		panel.add(tf);
		panel.add(tf1);

		f.add(panel);
		f.setVisible(true);
	}

	class myPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(bg, 0, 125, null);
			// g.fillRect(60, 40, 40, 20);
		}
	}

	public void setButton(String name, myPanel panel) {
		JButton bt = new JButton(name);
		bt.addActionListener(this);
		panel.add(bt);
	}

	public void setBackGround() {
	}

	public int setSpeed(int speed) {
		return speed;
	}

	public static void main(String[] args) {
		// new MyFrame().LaunchFrame();
		new GameSetting();

		// new PlanGameFrame().LaunchFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("磨练我心")) {
			new PlanGameFrame().LaunchFrame();
		} else if (cmd.equals("切换背景")) {
			tf2.setText("背景：水滴");
			Const.setBackgd("images/bg3.jpg");
		} else if (cmd.equals("调整难度")) {
			tf.setText("难度：困难");
			Const.setBulletCount(50);
			Const.setSpeed(15);
		} else if (cmd.equals("切换英雄")) {
			tf1.setText("英雄：焰心");
			Const.setHero("images/h3.jpg");
		}
	}
}
