package 查找;

//二叉排序树查找  考虑到二叉排序树的操作中 会用到孩子节点找双亲节点的操作 所以采用而链存储结构不是很方便
//因此在二叉链存储结构的基础上 增加一个指向双亲几点的对象引用 就能解决问题 
//用此种节点构成的二叉树称为三叉链结构的二叉树


public class BiTreeSearchNode {
	//三叉链节点类
	private BiTreeSearchNode leftChild;
	private BiTreeSearchNode rightChild;
	private BiTreeSearchNode parent; // 双亲节点
	private int data; // 数据元素

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
