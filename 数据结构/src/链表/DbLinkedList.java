package 链表;

import java.util.Collection;

public class DbLinkedList<T>
{
	
	//定义内部类，用作链表的节点
	private class Node<T>
	{
		Node<T> pre; //指向前一个节点
		Node<T> next; //指向后一个节点
		T value;  //当前节点的值
		
		public Node(T value, Node<T> next, Node<T> pre)
		{
			this.value = value;
			this.next = next;
			this.pre = pre;
		}
		
		public String toString()
		{
			return this.value + "";
		}
	}
	
	private Node<T> header;  //定义头节点
	private int size;  //定义链表的长度
	
	public DbLinkedList()
	{
		header = new Node<T>(null, null, null);//空的头节点，用来区分双向循环链表的首尾
		header.pre = header.next = header; //双向循环链表，首尾相连
		size = 0;
	}
	
	public DbLinkedList(Collection<? extends T> collection)
	{
		this();
		addAll(this.size, collection);
	}
	
	public boolean add(T value)//在链表的尾巴上面加一个节点, 相当于在header节点前面加一个节点
	{
		return add(header, value);
	}
	
	public boolean add(int index, T value)//指定index处加入节点
	{
		return add(entry(index), value);
	}
	
	public boolean remove(Object obj)//删除指定value的节点
	{
		Node<T> node;
		//1. 从header.next往后遍历，再到header时结束
		for(node = header.next; node!=header; node=node.next)
		{
			if(node.value == obj || (obj!=null && obj.equals(node.value)))
			{
				remove(node);
				return true;
			}
		}
		//2.java.util.LinkedList实现，先区分null再遍历，个人感觉效率差不多呀，希望有人赐教
		/*
		if(obj==null)
		{
			for(node = header.next; node!=header; node=node.next)
			{
				if(node.value == null)
				{
					remove(node);
					return true;
				}
			}
		}
		else
		{
			for(node = header.next; node!=header; node=node.next)
			{
				if(node.value == obj || obj.equals(node.value))
				{
					remove(node);
					return true;
				}
			}
		}
		*/
		return false;
	}
	
	public T remove(int index)//删除指定index节点
	{
		return remove(entry(index));
	}
	
	public boolean addAll(Collection<? extends T> collection)
	{
		return addAll(this.size, collection);
	}
	
	//在指定index位置添加collection里的所有元素
	public boolean addAll(int index, Collection<? extends T> collection)
	{
		if(collection==null || collection.size()==0)
		{
			return false;
		}
		//获取指定位置节点，如果index==size，则在末尾添加节点，即header节点之前
		//当index==size时，调用entry方法会抛异常，所以三则表达式很有必要
		Node<T> node = index == this.size ? this.header : entry(index);
		Object[] objArray = collection.toArray();
		int len = objArray.length;
		Node<T> preNode = node.pre;
		for(int i=0; i<len; i++)
		{
			//新建一个节点，新节点的next指向node，新节点的pre指向node的pre
			//完成指向过程node.pre←newNode→node
			//当第二次迭代时，preNode=newNode1(i=1创建的newNode), newNode1←newNode2(i=2创建的newNode)→node
			Node<T> newNode = new Node<T>((T) objArray[i], node, preNode);
			//维持双向链表的指向，将node的pre节点的next指向新节点,完成指向过程node.pre→newNode
			//当第二次迭代时，newNode1→newNode2
			preNode.next = newNode;
			//将preNode指向newNode，当第二次迭代时，preNode往后移动一位
			preNode = newNode;
		}
		//迭代完成后，node的前一个节点指向preNode（即最后一次创建的newNode），preNode←node
		//如果len=2,完成的链就变成这样preNode→←newNode1→←newNode2→←node
		node.pre = preNode;
		//长度加len
		this.size += len;
		return true;
	}
	
	private T remove(Node<T> node)
	{
		//node的前一个节点next指向node的下一个节点
		//node的下一个节点pre指向node的前一个节点
		//A→node←B改成A→←B
		node.pre.next = node.next;
		node.next.pre = node.pre;
		//node的前后指向null
		//A←node→B改成null←node→null
		node.pre = node.next = null;
		T value = node.value;
		node.value = null;
		this.size--;
		return value;
	}
	
	public T get(int index)
	{
		return entry(index).value;
	}
	
	private Node<T> entry(int index) //迭代至index处的节点
	{
		rangeIndex(index); //判断index是否越界
		
		Node<T> node = this.header;
		//判断index是否小于size的一半，如果小于就从header往后开始迭代，否则就从header往前开始迭代，提高效率
		//例如有一个链表header→A→B→C→D→header
		if(index < (this.size>>1))
		{
			//因为header是空的头节点，所以i要小于等于index
			//例如index=1， 小于size的一半2
			//i=0时，node=A
			//i=1时，node=B，然后跳出循环
			for(int i=0; i<=index; i++)
			{
				node = node.next;
			}
		}
		else
		{
			//例如index=2，不小size的一半
			//i=3, node等于header的前一个， node=D
			//i=2, node=C，然后跳出循环
			for(int i=this.size-1; i>=index; i--)
			{
				node = node.pre;
			}
		}
		return node;
	}
	
	private void rangeIndex(int index)
	{
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException("index错误");
		}
	}
	
	private boolean add(Node<T> node, T value)
	{
		//新建一个节点，新节点的next指向node，新节点的pre指向node的pre
		//完成指向过程node.pre←newNode→node
		Node<T> newNode = new Node<T>(value, node, node.pre);
		//维持双向链表的指向，将node的pre节点的next指向新节点,完成指向过程node.pre→newNode
		node.pre.next = newNode;
		//node节点的前一个节点指向新节点，完成指向过程newNode←node
		node.pre = newNode;
		//上面两行代码不能颠倒，否则node的前一个节点会被覆盖成新节点，会丢失node原来的前一个节点的next指向
		//上述代码完成了在node节点和node前一个节点之间加入一个新节点，并维护了双向关系
		this.size++;
		return true;
	}
	
	public void clear()
	{
		Node<T> node = header.next;
		//将每一个节点的双向指向都清空，这样每个节点都没有被引用，可以方便垃圾回收器回收内存
		while(node != header)
		{
			//将node的下一个节点临时保存起来
			Node<T> tempNode = node.next;
			//将node的下一个节点和上一个节点置空
			node.next = node.pre = null;
			//将node的值也置空
			node.value = null;
			//将node移动到下一个节点
			node = tempNode;
		}
		//清空header的双向指向null
		this.header.next = this.header.pre = this.header;
		this.size = 0;
	}
	
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	public int size()
	{
		return this.size;
	}
}