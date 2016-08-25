package cn.haofeng.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

/**
 * 动态生成图片
 * @author hao.feng
 *
 */
public class Demo {
	@Test
	public void fun1() throws FileNotFoundException, IOException{
		/**
		 * 创建图片缓冲区
		 * 设置其宽高
		 * 得到这个图片的绘制环境 得到画笔
		 * 保存
		 */
		BufferedImage bi=new BufferedImage(70, 35, BufferedImage.TYPE_INT_RGB);
		Graphics2D g=(Graphics2D) bi.getGraphics();//得到绘制环境
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 70, 35);//填充矩形
		g.setColor(Color.RED);
		g.drawString("hello", 2, 10);
		
		ImageIO.write(bi, "JPEG", new FileOutputStream("F:/xxx.jpg"));
	}
}
