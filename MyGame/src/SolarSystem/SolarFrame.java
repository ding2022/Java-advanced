package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.haofong.tool.GameUtil;
import com.haofong.tool.MyFrame;

/**
 * 太阳系的主窗口
 * 
 * @author feng
 *
 */
public class SolarFrame extends MyFrame {

	Image img = GameUtil.getImage("images/hao.jpg");
	Star sun = new Star(img, 0, 0);
	Plant earth=new Plant(" ", 150, 100, 0.1, sun);

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, Color.yellow, null);
		sun.draw(g); // 画太阳
		earth.draw(g);
	}

	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
