package 树和二叉树;
//查找二叉树  递归查找 先左边 后右边
public class SearchBiTree {
	public static BiTrebieNode search(BiTrebieNode t,Object x){
		BiTrebieNode tmp;
		
		if(t==null)
			return null;//查找失败
		if(t.data.equals(x))
			return t;	//查找成功
		
		if(t.getLeftChild()!=null){//在左子树查找
			tmp=search(t.getLeftChild(), x);
			if(tmp!=null)
				return tmp;//查找成功 递归结束
		}
		if(t.getRightChild()!=null){
			tmp=search(t.getRightChild(), x);
			if(tmp!=null)
				return tmp;
		}
		return null;
	}
}
