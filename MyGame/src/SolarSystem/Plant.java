package SolarSystem;

import java.awt.Graphics;
import java.awt.Image;

import com.haofong.tool.GameUtil;

/**
 * ���� ����ͼƬ�����ꡣ������ĳ����Բ���У����ᣬ���ᣬ�ٶȣ��Ƕȡ�����ĳ��star��
 * 
 * @author feng
 *
 */
public class Plant extends Star {

	double longAxis;// ����
	double shortAxis;
	double speed;
	double degree;
	Star center;

	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
		// ������Բ��
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
