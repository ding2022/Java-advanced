package ���Ͷ�����;
//����������ʱ����ת90��  ���ð����ʾ����ӡ������   �ݹ�
public class printBiTree {
	public static void PrintBiTreeTool(BiTrebieNode root,int level) {
		//��root��ڵ�����Ԫ�غ������
		if(root!=null){
			//�ҽڵ����
			PrintBiTreeTool(root.getRightChild(), level+1);
			if(level!=0){
				//�߹�6*��level-1�����ո� ÿ��ֵ����һ������ʾ Ϊ������
				for(int i=0;i<6*(level-1);i++){
					System.out.print(" ");
				}
				System.out.print("___");
			}
			System.out.println(root.data);
			//��ڵ����
			PrintBiTreeTool(root.getLeftChild(),level+1);
		}
	}
}
