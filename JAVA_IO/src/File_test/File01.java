package File_test;

import java.io.File;

/**
 * ��������
 * ·���ָ���
 * ���Ʒָ���\ windows �� /
 * @author feng
 *
 */
public class File01 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);//�ļ��ָ���
		System.out.println(File.separator);//·���ָ���
		
		//���ַ�ʽ
		String path="E:\\test\\filename";
		path="E:"+File.separator+"test"+File.separator+"filename";//Ϊ��Ӧ�Բ�ͬ����ϵͳ ·���ָ��� �Ĳ��
		//�Ƽ�ʹ��
		path="E:/test/filename";
		
		
	}
}
