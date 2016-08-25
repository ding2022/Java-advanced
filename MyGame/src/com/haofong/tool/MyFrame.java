package com.haofong.tool;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

	public void launchFrame() {
		setSize(Const.Game_WIDTH, Const.Game_HEIGHT);
		setLocation(200, 100);
		setVisible(true);

		new PaintThread().start();// �����绯�س�

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}

	/**
	 * �ػ����ڵ� �߳��ڲ���
	 * 
	 * @author feng
	 *
	 */
	class PaintThread extends Thread {
		@Override
		public void run() {
			super.run();
			while (true) {
				// �ػ�
				repaint();
				try {
					Thread.sleep(40);// һ�뻭 25 �� 25 ��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
