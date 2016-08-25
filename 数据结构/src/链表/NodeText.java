package ����;

import java.util.LinkedList;

public class NodeText {
	Object element; // Ԫ��
	NodeText next; // ��һ���ڵ�

	public NodeText(NodeText nextVal) {// ͷ��㹹�캯�� ͷ��㲻�洢����
		next = nextVal;
	}

	NodeText(Object obj, NodeText nextVal) {// �����ڵ�Ĺ��캯��
		element = obj;
		next = nextVal;
	}

	public NodeText getNext() { // ��ȡ��һ���ڵ�
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
