package ����;

//��������������  ���ǵ������������Ĳ����� ���õ����ӽڵ���˫�׽ڵ�Ĳ��� ���Բ��ö����洢�ṹ���Ǻܷ���
//����ڶ������洢�ṹ�Ļ����� ����һ��ָ��˫�׼���Ķ������� ���ܽ������ 
//�ô��ֽڵ㹹�ɵĶ�������Ϊ�������ṹ�Ķ�����


public class BiTreeSearchNode {
	//�������ڵ���
	private BiTreeSearchNode leftChild;
	private BiTreeSearchNode rightChild;
	private BiTreeSearchNode parent; // ˫�׽ڵ�
	private int data; // ����Ԫ��

	public BiTreeSearchNode() {
		leftChild = null;
		rightChild = null;
	}

	public BiTreeSearchNode(int item) {
		leftChild = null;
		rightChild = null;
		data = item;
	}
	public BiTreeSearchNode(int item,BiTreeSearchNode left,BiTreeSearchNode right){
		data=item;
		leftChild=left;
		rightChild=right;
	}
	public void setParent(BiTreeSearchNode parent){
		this.parent=parent;
	}
	public BiTreeSearchNode getParent(){
		return parent;
	}

	public BiTreeSearchNode getLeft() {
		return leftChild;
	}

	public void setLeft(BiTreeSearchNode leftChild) {
		this.leftChild = leftChild;
	}

	public BiTreeSearchNode getRight() {
		return rightChild;
	}

	public void setRight(BiTreeSearchNode rightChild) {
		this.rightChild = rightChild;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
