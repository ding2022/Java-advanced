package 链表;

import java.util.LinkedList;

public class NodeText {
	Object element; // 元素
	NodeText next; // 下一个节点

	public NodeText(NodeText nextVal) {// 头结点构造函数 头结点不存储数据
		next = nextVal;
	}

	NodeText(Object obj, NodeText nextVal) {// 其他节点的构造函数
		element = obj;
		next = nextVal;
	}

	public NodeText getNext() { // 获取下一个节点
		return next;
	}

	void setNext(NodeText nextVal) {
		next = nextVal;
	}

	public Object getElement() {
		return element;
	}

	LinkedList<Object> linkedList = new LinkedList<Object>();

	public void setElement(Object element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}
