package ����;

import java.util.Collection;

public class DbLinkedList<T>
{
	
	//�����ڲ��࣬��������Ľڵ�
	private class Node<T>
	{
		Node<T> pre; //ָ��ǰһ���ڵ�
		Node<T> next; //ָ���һ���ڵ�
		T value;  //��ǰ�ڵ��ֵ
		
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
	
	private Node<T> header;  //����ͷ�ڵ�
	private int size;  //��������ĳ���
	
	public DbLinkedList()
	{
		header = new Node<T>(null, null, null);//�յ�ͷ�ڵ㣬��������˫��ѭ���������β
		header.pre = header.next = header; //˫��ѭ��������β����
		size = 0;
	}
	
	public DbLinkedList(Collection<? extends T> collection)
	{
		this();
		addAll(this.size, collection);
	}
	
	public boolean add(T value)//�������β�������һ���ڵ�, �൱����header�ڵ�ǰ���һ���ڵ�
	{
		return add(header, value);
	}
	
	public boolean add(int index, T value)//ָ��index������ڵ�
	{
		return add(entry(index), value);
	}
	
	public boolean remove(Object obj)//ɾ��ָ��value�Ľڵ�
	{
		Node<T> node;
		//1. ��header.next����������ٵ�headerʱ����
		for(node = header.next; node!=header; node=node.next)
		{
			if(node.value == obj || (obj!=null && obj.equals(node.value)))
			{
				remove(node);
				return true;
			}
		}
		//2.java.util.LinkedListʵ�֣�������null�ٱ��������˸о�Ч�ʲ��ѽ��ϣ�����˴ͽ�
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
	
	public T remove(int index)//ɾ��ָ��index�ڵ�
	{
		return remove(entry(index));
	}
	
	public boolean addAll(Collection<? extends T> collection)
	{
		return addAll(this.size, collection);
	}
	
	//��ָ��indexλ�����collection�������Ԫ��
	public boolean addAll(int index, Collection<? extends T> collection)
	{
		if(collection==null || collection.size()==0)
		{
			return false;
		}
		//��ȡָ��λ�ýڵ㣬���index==size������ĩβ��ӽڵ㣬��header�ڵ�֮ǰ
		//��index==sizeʱ������entry���������쳣������������ʽ���б�Ҫ
		Node<T> node = index == this.size ? this.header : entry(index);
		Object[] objArray = collection.toArray();
		int len = objArray.length;
		Node<T> preNode = node.pre;
		for(int i=0; i<len; i++)
		{
			//�½�һ���ڵ㣬�½ڵ��nextָ��node���½ڵ��preָ��node��pre
			//���ָ�����node.pre��newNode��node
			//���ڶ��ε���ʱ��preNode=newNode1(i=1������newNode), newNode1��newNode2(i=2������newNode)��node
			Node<T> newNode = new Node<T>((T) objArray[i], node, preNode);
			//ά��˫�������ָ�򣬽�node��pre�ڵ��nextָ���½ڵ�,���ָ�����node.pre��newNode
			//���ڶ��ε���ʱ��newNode1��newNode2
			preNode.next = newNode;
			//��preNodeָ��newNode�����ڶ��ε���ʱ��preNode�����ƶ�һλ
			preNode = newNode;
		}
		//������ɺ�node��ǰһ���ڵ�ָ��preNode�������һ�δ�����newNode����preNode��node
		//���len=2,��ɵ����ͱ������preNode����newNode1����newNode2����node
		node.pre = preNode;
		//���ȼ�len
		this.size += len;
		return true;
	}
	
	private T remove(Node<T> node)
	{
		//node��ǰһ���ڵ�nextָ��node����һ���ڵ�
		//node����һ���ڵ�preָ��node��ǰһ���ڵ�
		//A��node��B�ĳ�A����B
		node.pre.next = node.next;
		node.next.pre = node.pre;
		//node��ǰ��ָ��null
		//A��node��B�ĳ�null��node��null
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
	
	private Node<T> entry(int index) //������index���Ľڵ�
	{
		rangeIndex(index); //�ж�index�Ƿ�Խ��
		
		Node<T> node = this.header;
		//�ж�index�Ƿ�С��size��һ�룬���С�ھʹ�header����ʼ����������ʹ�header��ǰ��ʼ���������Ч��
		//������һ������header��A��B��C��D��header
		if(index < (this.size>>1))
		{
			//��Ϊheader�ǿյ�ͷ�ڵ㣬����iҪС�ڵ���index
			//����index=1�� С��size��һ��2
			//i=0ʱ��node=A
			//i=1ʱ��node=B��Ȼ������ѭ��
			for(int i=0; i<=index; i++)
			{
				node = node.next;
			}
		}
		else
		{
			//����index=2����Сsize��һ��
			//i=3, node����header��ǰһ���� node=D
			//i=2, node=C��Ȼ������ѭ��
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
			throw new IndexOutOfBoundsException("index����");
		}
	}
	
	private boolean add(Node<T> node, T value)
	{
		//�½�һ���ڵ㣬�½ڵ��nextָ��node���½ڵ��preָ��node��pre
		//���ָ�����node.pre��newNode��node
		Node<T> newNode = new Node<T>(value, node, node.pre);
		//ά��˫�������ָ�򣬽�node��pre�ڵ��nextָ���½ڵ�,���ָ�����node.pre��newNode
		node.pre.next = newNode;
		//node�ڵ��ǰһ���ڵ�ָ���½ڵ㣬���ָ�����newNode��node
		node.pre = newNode;
		//�������д��벻�ܵߵ�������node��ǰһ���ڵ�ᱻ���ǳ��½ڵ㣬�ᶪʧnodeԭ����ǰһ���ڵ��nextָ��
		//���������������node�ڵ��nodeǰһ���ڵ�֮�����һ���½ڵ㣬��ά����˫���ϵ
		this.size++;
		return true;
	}
	
	public void clear()
	{
		Node<T> node = header.next;
		//��ÿһ���ڵ��˫��ָ����գ�����ÿ���ڵ㶼û�б����ã����Է������������������ڴ�
		while(node != header)
		{
			//��node����һ���ڵ���ʱ��������
			Node<T> tempNode = node.next;
			//��node����һ���ڵ����һ���ڵ��ÿ�
			node.next = node.pre = null;
			//��node��ֵҲ�ÿ�
			node.value = null;
			//��node�ƶ�����һ���ڵ�
			node = tempNode;
		}
		//���header��˫��ָ��null
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