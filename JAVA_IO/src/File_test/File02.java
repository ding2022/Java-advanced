package File_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ���·�������·������ file����
 * 
 * @author feng
 *
 */
public class File02 {
	public static void main(String[] args) throws IOException {
		String path = "E:/test";
		String name = "filename";
		// ���·�������·������ file����
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
		File temp = File.createTempFile("tmp", ".temp", new File("C:/"));// ������ʱ�ļ�
																			// �����˳���ͽ���ɾ����

		// makedir �����Ŀ¼������ �޷�����
		// makedirs ����ļ��������� �����ļ��� ��ʹ��Ŀ¼������
	}

}
