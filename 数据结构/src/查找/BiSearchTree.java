package 查找;

import 树和二叉树.Visit;

//二叉排序树类
public class BiSearchTree {
	private BiTreeSearchNode root;// 根指针

	private void inOrder(BiTreeSearchNode t, Visit vs) {// 中序遍历
		if (t != null) {
			inOrder(t.getLeft(), vs);
			vs.print(new Integer(t.getData()));
			inOrder(t.getRight(), vs);
		}
	}

	private void preOrder(BiTreeSearchNode t, Visit vs) {// 先序遍历
		if (t != null) {
			vs.print(new Integer(t.getData()));
			preOrder(t.getLeft(), vs);
			preOrder(t.getRight(), vs);
		}
	}

	public BiSearchTree() {
		root = null;
	}

	public BiTreeSearchNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeSearchNode root) {
		this.root = root;
	}

	public void inOrder(Visit vs) {
		inOrder(root, vs);
	}

	public void preOrder(Visit vs) {
		preOrder(root, vs);
	}

	public BiTreeSearchNode getLeft(BiTreeSearchNode current) {// 取左孩子
		return current != null ? current.getLeft() : null;
	}

	public BiTreeSearchNode getRight(BiTreeSearchNode current) {// 取左孩子
		return current != null ? current.getRight() : null;
	}

	public BiTreeSearchNode find(int item) {// 查找
		if (root != null) {
			BiTreeSearchNode temp = root;
			while (temp != null) {
				if (temp.getData() == item)
					return temp;
				if (temp.getData() < item)
					temp = temp.getRight();
				else {
					temp.getLeft();
				}
			}
		}
		return null;
	}

	public void insert(BiTreeSearchNode ptr, int item) { // 插入
		if (item < ptr.getData()) {
			if (ptr.getLeft() != null) {
				BiTreeSearchNode temp = new BiTreeSearchNode(item);
				temp.setParent(ptr);
				ptr.setLeft(temp);
			} else {
				insert(ptr.getLeft(), item);
			}
		} else if (item > ptr.getData()) {
			if (ptr.getRight() != null) {
				BiTreeSearchNode temp = new BiTreeSearchNode(item);
				temp.setParent(ptr);
				ptr.setRight(temp);
			} else {
				insert(ptr.getRight(), item);
			}
		}
		return;
	}

	public void delete(BiTreeSearchNode ptr, int item) {// 删除
		if (ptr != null) {
			if (item < ptr.getData())
				delete(ptr.getLeft(), item);
			else if (item > ptr.getData()) {
				delete(ptr.getRight(), item);
			} else if (ptr.getLeft() != null && ptr.getRight() != null) {
				BiTreeSearchNode min;
				min = ptr.getRight();
				while (min.getLeft() != null)
					min = min.getLeft();
				ptr.setData(min.getData());
				delete(ptr.getRight(), min.getData());
			}
		} else {
			if (ptr.getLeft() == null && ptr.getRight() != null) {
				ptr.getParent().setRight(ptr.getRight());
				ptr.getRight().setParent(ptr.getParent());
			} else if (ptr.getRight() == null && ptr.getLeft() != null) {
				ptr.getParent().setLeft(ptr.getLeft());
				ptr.getLeft().setParent(ptr.getParent());
			} else {
				BiTreeSearchNode p = ptr.getParent();
				if (p.getLeft() == ptr)
					p.setLeft(null);
				else {
					p.setRight(null);
				}
			}
		}
	}
}
