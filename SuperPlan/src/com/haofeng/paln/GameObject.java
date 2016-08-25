package com.haofeng.paln;

/**
 * 游戏物体类
 * 提取出子弹 飞机的共同点
 */
import java.awt.Image;
import java.awt.Rectangle;

import com.haofeng.util.Const;

public class GameObject {
	Image img;// 图片
	double x, y;// 坐标
	int speed = Const.getSpeed();// 运行速度

	int width, height;

	public Rectangle getRect() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public GameObject(Image img, double x, double y, int speed, int width,
			int height) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject() {
	}

}
