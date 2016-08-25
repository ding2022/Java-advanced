package 链表;

import java.util.Collection;

//循环双向链表
public class DoublelinkList {
	
	private Node header;
	private int size;//定义链表的长度
	
	public void initlist(){
		
	}
	public DoublelinkList(){
		header=new Node(null, null, null);//空的头结点，用来区分双向循环链表的首尾
		header.pre=header.next=header;//双向循环链表 首尾相连
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
