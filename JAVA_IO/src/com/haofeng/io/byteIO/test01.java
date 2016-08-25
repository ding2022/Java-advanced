package com.haofeng.io.byteIO;

import java.io.File;
import java.io.FileInputStream;

/**
 * 1,读取文件   找到文件
 * 2 建立联系 
 * 3 选择流
 * 4 读写
 * @author feng
 *
 */
public class test01 {
	public static void main(String[] args) throws Exception {
		//建立联系
		File src=new File("e:/test.txt");
		//选择流
		FileInputStream is=new FileInputStream(src);
		//操作流 缓冲数组
		byte[] car=new byte[10];
		int len=0;	//接受实际读取的大小
		//循环读取
		while(-1!=(len=is.read(car))){//read方法表示 读取的字节的数目  
//			不会超过 定义的byte数组的大小  当读取数为-1时 表示无法读取继续
			
			//将字节数组转换成字符串
			String info=new String(car,0,len);	//String 有很多重写的方法 把car里的数据 从0读到len
			System.out.println(info);
		}
	}
//	public static 

}
