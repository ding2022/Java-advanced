package ���Ͷ�����;
//���������� �ݹ� ���� ���� ���� ����   �����ǰѶ����� ���ϵ��� ÿ������ұ���һ�� ��һ������ �������ҽڵ� ÿ���Ƴ���ǰ�ڵ�ʱ ���������ҽڵ������ �������ܱ�����ȫ
import java.util.concurrent.LinkedBlockingQueue;

import ջ.SeqStack;


public class Traverse_BianLi {
	public static void preOrder(BiTrebieNode t, Visit vs) {// ������������� �� �� ��
		if (t != null) {
			vs.print(t.data);// �˲��������ڱ������ڵ�
			preOrder(t.getLeftChild(), vs);
			preOrder(t.getRightChild(), vs);
		}
	}

	public static void inOrder(BiTrebieNode t, Visit vs) {// ������������� �� �� ��
		if (t != null) {
			inOrder(t.getLeftChild(), vs);
			vs.print(t.data);
			inOrder(t.getRightChild(), vs);
		}
	}

	public static void postOrder(BiTrebieNode t, Visit vs) {// ������������� �� �� ��
		if (t != null) {
			postOrder(t.getLeftChild(), vs);
			postOrder(t.getRightChild(), vs);
			vs.print(t.data);
		}
	}

	public static void levelOrder(BiTrebieNode t, Visit vs) throws Exception {//������� һ�����
		LinkedBlockingQueue<Object> q=new LinkedBlockingQueue<Object>();//����һ����ʽ���� �Ա���ڵ�
		if(t==null)
			return;
		BiTrebieNode curr;
		q.add(t);  //���ڵ�����
		while (!q.isEmpty()) {
			curr=(BiTrebieNode) q.remove();	//�����еĽڵ�
			
			vs.print(curr.data); //�������ڵ�
			
			if(curr.getLeftChild()!=null){	//���ڵ� ����
				q.add(curr.getLeftChild()); //�������ڵ�
			}
			if(curr.getRightChild()!=null){
				q.add(curr.getRightChild());
			}
		}
	}
	public static void preOrderByStack(BiTrebieNode root)throws Exception{//���õݹ��������� ���� ջ �����ҽڵ� ������ڵ�
		SeqStack stack=new SeqStack();
		if(root==null){
			return;
		}
		BiTrebieNode curr;
		
		stack.push(root);//��ջ root
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
