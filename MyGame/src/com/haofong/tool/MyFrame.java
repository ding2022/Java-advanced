package com.haofong.tool;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

	public void launchFrame() {
		setSize(Const.Game_WIDTH, Const.Game_HEIGHT);
		setLocation(200, 100);
		setVisible(true);

		new PaintThread().start();// 启动崇化县城

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}

	/**
	 * 重画窗口的 线程内部类
	 * 
	 * @author feng
	 *
	 */
	class PaintThread extends Thread {
		@Override
		public void run() {
			super.run();
			while (true) {
				// 重画
				repaint();
				try {
					Thread.sleep(40);// 一秒画 25 次 25 针
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
