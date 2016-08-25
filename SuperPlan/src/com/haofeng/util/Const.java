package com.haofeng.util;

/**
 * 常量类
 * 
 * @author feng
 *
 */
public class Const {
	public static final int Frame_Width = 1366;
	public static final int Frame_Height = 768;
	public static final String Game_name = "不死之心---风豪出品";
	public static int speed = 10;
	public static String hero = "images/h1.jpg";
	public static String backgd = "images/bg7.jpg";
	public static int BulletCount=30;
	
	public static int getBulletCount() {
		return BulletCount;
	}

	public static void setBulletCount(int bulletCount) {
		BulletCount = bulletCount;
	}

	public static String getBackgd() {
		return backgd;
	}

	public static void setBackgd(String backgd) {
		Const.backgd = backgd;
	}

	public static String getHero() {
		return hero;
	}

	public static void setHero(String hero) {
		Const.hero = hero;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int spee) {
		speed = spee;
	}
}
