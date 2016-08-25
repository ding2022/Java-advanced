package File_test;

import java.io.File;

/**
 * 两个常量
 * 路径分隔符
 * 名称分隔符\ windows 非 /
 * @author feng
 *
 */
public class File01 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);//文件分隔符
		System.out.println(File.separator);//路径分隔符
		
		//三种方式
		String path="E:\\test\\filename";
		path="E:"+File.separator+"test"+File.separator+"filename";//为了应对不同操作系统 路径分隔符 的差别
		//推荐使用
		path="E:/test/filename";
		
		
	}
}
