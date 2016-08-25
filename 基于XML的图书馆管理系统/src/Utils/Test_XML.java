package Utils;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Test_XML {

	public static void main(String[] args) {
		String fileName=null;
		try{
			Scanner in=new Scanner(System.in);
			System.out.println("����Ҫ��֤��xml�ļ������֣�");
			fileName=in.nextLine();
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			
			DocumentBuilder builder=factory.newDocumentBuilder();
			MyHandler handler=new MyHandler();
			builder.setErrorHandler(handler);
			
			Document document=builder.parse(new File(fileName));
			if(handler.erroeMessage==null){
				System.out.println(fileName+"�ļ���Ч");
			}else {
				System.out.println(fileName+"�ļ���Ч");
			}
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			
		}
	}

}
class MyHandler extends DefaultHandler{
	String erroeMessage=null;
	public void error(SAXParseException e)throws SAXParseException{
		erroeMessage=e.getMessage();
		System.out.println("һ�����"+erroeMessage);
	}
	public void fatalError(SAXParseException e)throws SAXParseException{
		erroeMessage=e.getMessage();
		System.out.println("��������"+erroeMessage);
	}
}

