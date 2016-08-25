package com.haofong.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 游戏窗口类
 * 
 * @author feng
 *
 */
public class GameFrame extends MyFrame {// GUI编程：awt,swing等 用的很少

	Image img = GameUtil.getImage("images/hao.jpg");

	private double x,y;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(100, 100, 200, 200);// 划线
		g.drawRect(100, 100, 200, 200);// 画矩形
		g.drawOval(100, 100, 200, 200);// 画圆还是画矩形
		g.drawOval(200, 200, 200, 150);// 画椭圆

		g.drawString("我是风豪", 200, 200);

		g.fillRect(30, 30, 40, 40);
		Color c = g.getColor();
		// 把画笔颜色改变
		g.setColor(Color.red);
		// 填充图形
		g.fillRect(100, 100, 200, 100);

		g.setColor(c);

		g.drawImage(img, (int)x, (int)y, null);
		x++;
		y++;
	}
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
