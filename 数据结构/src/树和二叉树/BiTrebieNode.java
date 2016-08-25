package 树和二叉树;
//构建二叉树
public class BiTrebieNode {
	private BiTrebieNode leftChild;
	private BiTrebieNode rightChild;
	public Object data;
	
	BiTrebieNode(){
		leftChild=null;
		rightChild=null;
	}
	BiTrebieNode(Object item,BiTrebieNode left,BiTrebieNode right){
		data=item;
		leftChild=left;
		rightChild=right;
	}
	
	public BiTrebieNode getLeftChild(){
		return leftChild;
	}
	public BiTrebieNode getRightChild() {
		return rightChild;
	}
	public Object getData() {
		return data;
	}
}
