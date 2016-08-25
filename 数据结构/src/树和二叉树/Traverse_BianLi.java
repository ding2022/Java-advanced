package 树和二叉树;
//遍历二叉树 递归 先序 中序 后序 层序   层序是把二叉树 从上到下 每层从左到右遍历一遍 用一个队列 储存左右节点 每次移除当前节点时 把它的左右节点入队列 这样就能遍历完全
import java.util.concurrent.LinkedBlockingQueue;

import 栈.SeqStack;


public class Traverse_BianLi {
	public static void preOrder(BiTrebieNode t, Visit vs) {// 先序遍历二叉树 根 左 右
		if (t != null) {
			vs.print(t.data);// 此操作类似于遍历根节点
			preOrder(t.getLeftChild(), vs);
			preOrder(t.getRightChild(), vs);
		}
	}

	public static void inOrder(BiTrebieNode t, Visit vs) {// 中序遍历二叉树 左 根 右
		if (t != null) {
			inOrder(t.getLeftChild(), vs);
			vs.print(t.data);
			inOrder(t.getRightChild(), vs);
		}
	}

	public static void postOrder(BiTrebieNode t, Visit vs) {// 后序遍历二叉树 左 右 根
		if (t != null) {
			postOrder(t.getLeftChild(), vs);
			postOrder(t.getRightChild(), vs);
			vs.print(t.data);
		}
	}

	public static void levelOrder(BiTrebieNode t, Visit vs) throws Exception {//层序遍历 一层层走
		LinkedBlockingQueue<Object> q=new LinkedBlockingQueue<Object>();//创建一个链式对象 以保存节点
		if(t==null)
			return;
		BiTrebieNode curr;
		q.add(t);  //根节点入列
		while (!q.isEmpty()) {
			curr=(BiTrebieNode) q.remove();	//出队列的节点
			
			vs.print(curr.data); //输出这个节点
			
			if(curr.getLeftChild()!=null){	//做节点 不空
				q.add(curr.getLeftChild()); //加入做节点
			}
			if(curr.getRightChild()!=null){
				q.add(curr.getRightChild());
			}
		}
	}
	public static void preOrderByStack(BiTrebieNode root)throws Exception{//不用递归的先序遍历 借助 栈 先入右节点 再入左节点
		SeqStack stack=new SeqStack();
		if(root==null){
			return;
		}
		BiTrebieNode curr;
		
		stack.push(root);//入栈 root
		while(!stack.isEmpty()){
			curr=(BiTrebieNode)stack.pop();
			System.out.println(curr);
			
			if(curr.getRightChild()!=null){
				stack.push(curr.getRightChild());
			}
			if(curr.getLeftChild()!=null){
				stack.push(curr.getLeftChild());
			}
		}
	}
}
