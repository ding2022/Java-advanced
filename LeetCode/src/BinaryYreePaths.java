import java.util.List;

public class BinaryYreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		int k=0;
		if(root.left!=null){
			k++;
		}
		return null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}