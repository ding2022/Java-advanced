package com.haofeng.io.byteIO;

import java.io.File;
import java.io.FileInputStream;

/**
 * 1,��ȡ�ļ�   �ҵ��ļ�
 * 2 ������ϵ 
 * 3 ѡ����
 * 4 ��д
 * @author feng
 *
 */
public class test01 {
	public static void main(String[] args) throws Exception {
		//������ϵ
		File src=new File("e:/test.txt");
		//ѡ����
		FileInputStream is=new FileInputStream(src);
		//������ ��������
		byte[] car=new byte[10];
		int len=0;	//����ʵ�ʶ�ȡ�Ĵ�С
		//ѭ����ȡ
		while(-1!=(len=is.read(car))){//read������ʾ ��ȡ���ֽڵ���Ŀ  
//			���ᳬ�� �����byte����Ĵ�С  ����ȡ��Ϊ-1ʱ ��ʾ�޷���ȡ����
			
			//���ֽ�����ת�����ַ���
			String info=new String(car,0,len);	//String �кܶ���д�ķ��� ��car������� ��0����len
			System.out.println(info);
		}
	}
//	public static 

}
