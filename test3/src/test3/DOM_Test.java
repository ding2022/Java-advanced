package test3;


import java.io.File;
import java.io.FileOutputStream;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.*;
import javax.xml.soap.Node;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class DOM_Test {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dbf.newDocumentBuilder();
			Document doc=builder.parse(new File("DOM_Test.xml"));
			
			Element root=doc.getDocumentElement();
			NodeList nList=root.getChildNodes();
			for(int i=0;i<nList.getLength();i++){
				Node node=(Node) nList.item(i);
				if(node.getNodeType()==node.ELEMENT_NODE){
					Element enode=(Element) node;
					if(i==3){
						enode.removeAttribute("学号");
					}
					System.out.println(i);
					System.out.println(enode.getTextContent());
				}
				
			}
			Node node=(Node) nList.item(1);
			root.removeChild(node);
			TransformerFactory transFactory=TransformerFactory.newInstance();
			Transform transformr=(Transform) transFactory.newTransformer();
			DOMSource domSource=new DOMSource(doc);
		
			File file=new File("DOM_Test.xml");
			FileOutputStream out=new FileOutputStream(file);
			StreamResult xmlResult=new StreamResult(out);
			
			//此处有错
			//transformr.transform(domSource, xmlResult);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
