package Utils;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DOM_Check {

	public static void main(String[] args) {
		GiveData give=new GiveData();
		try{
			Scanner in=new Scanner(System.in);
			System.out.println("请输入XML文件名：");
			String filename=in.nextLine().toString();
			
			//查找文件
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder domParser=factory.newDocumentBuilder();
			Document document=domParser.parse(new File(filename+".xml"));
			
			NodeList nodeList=document.getChildNodes();
			
			give.output(nodeList);
			
			System.out.println("图书的平均价格："+give.average/give.m);
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
class GiveData{
	double average=0,m=0;
	public void output(NodeList nodeList) {
		int size=nodeList.getLength();
		for(int i=0;i<size;i++){
			Node node=nodeList.item(i);
			if(node.getNodeType()==Node.TEXT_NODE){
				Text textNode=(Text) node;
				String content=textNode.getWholeText();
				System.out.println(content);
				
				Element parent=(Element) textNode.getParentNode();
				boolean boo=(parent.getNodeName().equals("单价"));
				if(boo){
					content=textNode.getWholeText();
					average=average+Double.parseDouble(content.trim());
					m++;
				}
			}
			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element element=(Element) node;
				String name=element.getNodeName();
				System.out.println(name+":");
				NodeList nodes=element.getChildNodes();
				output(nodes);
			}
			
		}
	}
}
