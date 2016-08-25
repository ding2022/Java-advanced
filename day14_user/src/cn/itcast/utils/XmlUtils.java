package cn.itcast.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	
	private static String filename = "users.xml";
	
	public static Document getDocument() throws DocumentException{
		
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		
		SAXReader reader = new SAXReader();
		return reader.read(new File(realpath));
		
	}
	
	public static void write2Xml(Document document) throws IOException{
		
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(realpath), format );
        writer.write( document );
        writer.close();

	}
	
}
