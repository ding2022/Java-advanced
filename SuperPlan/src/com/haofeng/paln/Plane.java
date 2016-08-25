package com.haofeng.paln;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import com.haofeng.util.GameUtils;

public class Plane extends GameObject {
	boolean left, up, right, down;
	private boolean life = true;// 飞机活着

	public void draw(Graphics g) {
		if (life) {
			g.drawImage(img, (int) x, (int) y, null);
			move();
		}
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public void move() {
		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
	}

	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;

		default:
			break;
		}
	}

	public void minusSirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;

		default:
			break;
		}
	}

	public Plane(String imgpath, double x, double y) {
		this.img = GameUtils.getImage(imgpath);
		// 这两句必须写在 得到图片的下方
		// this.width = plane.getWidth(null);
		// this.height = plane.getHeight(null);
		this.width = 20;
		this.height = 20;
		this.x = x;
		this.y = y;
	}

	public Plane() {
	}
}