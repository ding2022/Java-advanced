package ���Ͷ�����;
//���Ҷ�����  �ݹ���� ����� ���ұ�
public class SearchBiTree {
	public static BiTrebieNode search(BiTrebieNode t,Object x){
		BiTrebieNode tmp;
		
		if(t==null)
			return null;//����ʧ��
		if(t.data.equals(x))
			return t;	//���ҳɹ�
		
		if(t.getLeftChild()!=null){//������������
			tmp=search(t.getLeftChild(), x);
			if(tmp!=null)
				return tmp;//���ҳɹ� �ݹ����
		}
		if(t.getRightChild()!=null){
			tmp=search(t.getRightChild(), x);
			if(tmp!=null)
				return tmp;
		}
		return null;
	}
}
