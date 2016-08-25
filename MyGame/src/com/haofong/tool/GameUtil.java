package com.haofong.tool;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 开发中常用的工具类 加载图片等
 * 
 * @author feng
 *
 */
public class GameUtil {
	private GameUtil(){};//工具类通常会将构造方法私有了
	
	public static Image getImage(String path) {
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
