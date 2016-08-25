package com.haofeng.util;

/**
 * 工具类 包含图片获取等
 */
import java.awt.Image;
import java.awt.Toolkit;

public class GameUtils {

	private GameUtils() {
	};// 私有化构造器 防止被调

	// 图片获取
	public static Image getImage(String path) {
		/*URL u = GameUtils.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;*/
		return Toolkit.getDefaultToolkit().getImage(
				GameUtils.class.getClassLoader().getResource(path));
	}
}
