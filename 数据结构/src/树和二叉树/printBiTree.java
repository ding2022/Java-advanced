package 树和二叉树;
//将二叉树逆时针旋转90度  即用凹入表示法打印二叉树   递归
public class printBiTree {
	public static void PrintBiTreeTool(BiTrebieNode root,int level) {
		//第root层节点数据元素横向输出
		if(root!=null){
			//右节点输出
			PrintBiTreeTool(root.getRightChild(), level+1);
			if(level!=0){
				//走过6*（level-1）个空格 每行值都在一列上显示 为了整齐
				for(int i=0;i<6*(level-1);i++){
					System.out.print(" ");
				}
				System.out.print("___");
			}
			System.out.println(root.data);
			//左节点输出
			PrintBiTreeTool(root.getLeftChild(),level+1);
		}
	}
}
