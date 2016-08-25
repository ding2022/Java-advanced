package File_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 相对路径与绝对路径构造 file对象
 * 
 * @author feng
 *
 */
public class File02 {
	public static void main(String[] args) throws IOException {
		String path = "E:/test";
		String name = "filename";
		// 相对路径与绝对路径构造 file对象
		File src = new File(path, name);

		src.getPath();
		src.getParent();
		src.canExecute();
		//
		if (!src.exists()) {
			src.createNewFile();
		}
		// FileWriter
		//
		File temp = File.createTempFile("tmp", ".temp", new File("C:/"));// 创建临时文件
																			// 程序退出后就进行删除了

		// makedir 如果父目录不存在 无法创建
		// makedirs 如果文件链不存在 创建文件链 即使父目录不存在
	}

}
