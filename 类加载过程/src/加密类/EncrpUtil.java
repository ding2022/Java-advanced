package 加密类;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncrpUtil {
	public static void main(String[] args) {
		encrp("", "");
	}
	@SuppressWarnings("null")
	public static void encrp(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		int temp = -1;
		try {
			while ((temp = fis.read()) != -1) {
				fos.write(temp^0xff);//取反操作
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
