package com.haofeng.paln;

import java.awt.Color;
import java.awt.Graphics;
import com.haofeng.util.Const;

/**
 * 子弹类 坐标 x，y 速度，角度
 * 
 * @author feng
 *
 */
public class Bullet extends GameObject {
	double degree;

	public Bullet() {
		degree = Math.random() * Math.PI * 2;
		x = Const.Frame_Height / 2;
		y = Const.Frame_Width / 2;
		width = 10;
		height = 10;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, 10, 10);

		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		if (y > Const.Frame_Height - 17 || y < 32) {
			degree = -degree;
		}
		if (x < 5 || x > Const.Frame_Width - 17) {
			degree = Math.PI - degree;
		}

		g.setColor(c);
	}
}
