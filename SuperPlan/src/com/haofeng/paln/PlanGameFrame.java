package com.haofeng.paln;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.haofeng.util.Const;
import com.haofeng.util.GameUtils;
import com.haofeng.util.MyFrame;

public class PlanGameFrame extends MyFrame {

	Image bg = GameUtils.getImage(Const.getBackgd());

	Plane p = new Plane(Const.getHero(), 50, 50);
	public int BulletCount=Const.getBulletCount();
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();// 子弹数组

	Date startTime;
	Date endTime;
	Explode bao;

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for (Bullet b : bulletList) {
			b.draw(g);
			// 检测与飞机的碰撞
			boolean crash = b.getRect().intersects(p.getRect());
			if (crash) {
				p.setLife(false);// 飞机死了
				if (bao == null) {
					bao = new Explode(p.x, p.y);
					endTime = new Date();
				}
			}
		}
		if (!p.isLife()) {
			bao.draw(g);
			// printGameOver(g, "GAME OVER", 100, 200, 100);
			int LiveTime = (int) (endTime.getTime() - startTime.getTime()) / 1000;
			printGameOver(g, Color.yellow, "存活时间：" + LiveTime + "秒", 430, 500,
					60);
			printGameOver(g, Color.black, "--风豪出品--", 430, 620, 60);
			printGameOver(g, Color.black, "--联系：hao_fong@qq.com", 430, 690, 60);

			switch (LiveTime / 10) {
			case 0:
				printGameOver(g, Color.red, "U R A LOSER!", 400, 300, 100);
				break;
			case 1:
				printGameOver(g, Color.red, "U R A LOSER!", 400, 300, 100);
				break;
			case 2:
				printGameOver(g, Color.yellow, "还可以!", 460, 300, 100);
				break;
			case 3:
				printGameOver(g, Color.yellow, "还可以！", 460, 300, 100);
				break;
			case 4:
				printGameOver(g, Color.yellow, "还可以!", 460, 300, 100);
				break;
			case 5:
				printGameOver(g, Color.yellow, "还可以!", 460, 300, 100);
				break;
			case 6:
				printGameOver(g, Color.blue, "有那么点好了!", 400, 300, 100);
				break;
			case 7:
				printGameOver(g, Color.blue, "有那么点好了!", 400, 300, 100);
				break;
			case 8:
				printGameOver(g, Color.blue, "有那么点好了!", 400, 300, 100);
				break;
			case 9:
				printGameOver(g, Color.green, "你太棒了!", 450, 300, 100);
				break;
			case 10:
				printGameOver(g, Color.green, "你太棒了!", 450, 300, 100);
				break;
			case 11:
				printGameOver(g, Color.green, "你太棒了!", 450, 300, 100);
				break;
			default:
				printGameOver(g, Color.orange, "你乃神人也!", 450, 300, 100);
				break;
			}
		}
	}

	public void printGameOver(Graphics g, Color color, String strGG, int x,
			int y, int size) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体", Font.BOLD, size);
		g.setFont(f);
		g.drawString(strGG, x, y);
		g.setColor(c);
	}

	public void LaunchFrame() {
		super.LaunchFrame();// 把父类的加载进来
		// 增加键盘监听
		addKeyListener(new keyMonitor());
		// 生成子弹
		for (int i = 0; i < BulletCount; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		// 当游戏加载时 开始计时
		startTime = new Date();
	}

	// 定义为内部类 可以方便的使用外部类的普通属性
	class keyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusSirection(e);
		}
	}
}
