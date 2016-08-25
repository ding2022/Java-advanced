package cn.haofeng.utils;

import java.util.UUID;

import org.junit.Test;

public class Commons {
	@Test
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(uuid());
	}
}
