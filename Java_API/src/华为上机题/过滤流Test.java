package ��Ϊ�ϻ���;

import java.io.*;

public class ������Test {

	public static void main(String[] args) {
		File file;
		FileOutputStream fout;
		BufferedOutputStream bout;
		DataInputStream din;
		PushbackInputStream pin;
		try{
		String string="file1fileoutputstream2bufferedoutputstream3datainputstream4datainputstream5pushbackinputstream6";
		byte[] data=string.getBytes();
		file =new File("test.txt");
		if(file.exists()==false){
			file.createNewFile();
		}
		fout =new FileOutputStream(file);
		bout=new BufferedOutputStream(fout);
		
		bout.write(data,0,data.length);
		bout.flush();
		din=new DataInputStream(new FileInputStream(file));
		System.out.println(din.readBoolean());
		System.out.println("ת�������");
		int pdata;
		pin=new PushbackInputStream(new FileInputStream("test.txt"));
		while((pdata=pin.read())!=-1){
			if(Character.isLetter((char)pdata)){
				System.out.println((char)pdata);
			}else{
				System.out.println();
			}
		}
		System.out.println();
		}catch(Exception e){
			System.out.println("error");
		}
	}
}
