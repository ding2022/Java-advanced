package ����;

import java.util.Collection;

//ѭ��˫������
public class DoublelinkList {
	
	private Node header;
	private int size;//��������ĳ���
	
	public void initlist(){
		
	}
	public DoublelinkList(){
		header=new Node(null, null, null);//�յ�ͷ��㣬��������˫��ѭ���������β
		header.pre=header.next=header;//˫��ѭ������ ��β����
		size=0;
	}
	public int getsize(){
		return size;
	}
}
class Node{
	Node pre;
	Node next;
	
	Object data;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node(Object obj,Node pre,Node next){
		this.data=obj;
		this.pre=pre;
		this.next=next;
	}
}
