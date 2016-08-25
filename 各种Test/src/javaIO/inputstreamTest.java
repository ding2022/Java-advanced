package javaIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class inputstreamTest{
	public static void main(String[] args) throws Exception{
		//从文件读取并写出
		DataInputStream in= new DataInputStream(new BufferedInputStream(new FileInputStream("")));
		DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("")));
	}
}
