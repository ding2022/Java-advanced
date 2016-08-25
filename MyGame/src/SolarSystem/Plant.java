package SolarSystem;

import java.awt.Graphics;
import java.awt.Image;

import com.haofong.tool.GameUtil;

/**
 * 行星 除了图片，坐标。行星沿某个椭圆运行，长轴，短轴，速度，角度。绕着某个star飞
 * 
 * @author feng
 *
 */
public class Plant extends Star {

	double longAxis;// 长轴
	double shortAxis;
	double speed;
	double degree;
	Star center;

	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
		// 沿着椭圆飞
		x = center.x + longAxis * Math.cos(degree);
		y = center.y + shortAxis * Math.sin(degree);
		degree += speed;
	}

	public Plant(String imgpath, double longAxis, double shortAxis,
			double speed, Star center) {
		this.center = center;

		this.x = center.x + longAxis;
		this.y = center.y;
		this.img = GameUtil.getImage(imgpath);

		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
	}

	public Plant(Image img, double x, double y) {
		super(img, x, y);
	}
}
