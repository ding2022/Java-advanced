package 栈;

import 树和二叉树.BiTrebieNode;

public class SeqStack {

	final int defauleSize = 10;
	int top;
	Object[] stack;
	int maxStackSize;

	public SeqStack() {
		initiate(defauleSize);
	}

	SeqStack(int sz) {
		initiate(sz);
	}

	private void initiate(int sz) {// 初始化
		maxStackSize = sz;
		top = 0;
		stack = new Object[sz];
	}

	public void push(Object obj) throws Exception{
		if(top>=maxStackSize){
			throw new Exception();
		}
		top++;
		stack[top]=obj;
	}

	public Object pop()throws Exception {
		if(top<0){
			throw new Exception();
		}
		Object tmp= stack[top];
		top--;
		return tmp;
	}

	public int getTop() {
		return top;
	}
	public boolean isEmpty(){
		return top==0;
	}
}
