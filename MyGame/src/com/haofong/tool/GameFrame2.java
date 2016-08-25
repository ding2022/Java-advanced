package com.haofong.tool;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

public class GameFrame2 extends MyFrame {// GUI编程：awt,swing等 用的很少

	Image img = GameUtil.getImage("images/hao.jpg");
	
	private double x, y;
	private boolean left;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(img, (int) x, (int) y, null);

		if (left) {
			x -= 3;
			y -= 3;
		} else {
			x += 3;
			y += 3;
		}
		if (x > 500 - 30) {
			left = true;
		}
		if (x < 0) {
			left = false;
		}
		if (y > 500 - 30) {
			left = true;
		}
		if (y < 30) {
			left = false;
		}
	}
	public static void main(String[] args) {
		GameFrame2 gf = new GameFrame2();
		gf.launchFrame();
	}
}
