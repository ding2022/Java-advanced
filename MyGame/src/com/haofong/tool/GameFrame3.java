package com.haofong.tool;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 游戏窗口类 窗口物体沿任意方向运行
 * 
 * @author feng
 *
 */
public class GameFrame3 extends MyFrame {// GUI编程：awt,swing等 用的很少

	Image img = GameUtil.getImage("images/hao.jpg");

	private double x = 100, y = 100;
	private double degree = 3.14 / 3; // [0,2pai]
	private double speed = 10;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, (int) x, (int) y, null);

		if (speed > 0) {
			speed -= 0.01;
		} else {
			speed = 0;
		}

		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		if (y > 500 - 25 || y < 25) {
			degree = -degree;
		}
		if (x < 0 || x > 500 - 25) {
			degree = Math.PI - degree;
		}
	}

	public static void main(String[] args) {
		GameFrame3 gf = new GameFrame3();
		gf.launchFrame();
	}
}
