package com.haofong.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * ��Ϸ������
 * 
 * @author feng
 *
 */
public class GameFrame extends MyFrame {// GUI��̣�awt,swing�� �õĺ���

	Image img = GameUtil.getImage("images/hao.jpg");

	private double x,y;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(100, 100, 200, 200);// ����
		g.drawRect(100, 100, 200, 200);// ������
		g.drawOval(100, 100, 200, 200);// ��Բ���ǻ�����
		g.drawOval(200, 200, 200, 150);// ����Բ

		g.drawString("���Ƿ��", 200, 200);

		g.fillRect(30, 30, 40, 40);
		Color c = g.getColor();
		// �ѻ�����ɫ�ı�
		g.setColor(Color.red);
		// ���ͼ��
		g.fillRect(100, 100, 200, 100);

		g.setColor(c);

		g.drawImage(img, (int)x, (int)y, null);
		x++;
		y++;
	}
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
