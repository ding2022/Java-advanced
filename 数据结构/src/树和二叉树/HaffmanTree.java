package 树和二叉树;

//哈弗曼树 带权最短路径树 
public class HaffmanTree {// 构造哈弗曼树和哈弗曼编码的哈弗曼树类
	static final int maxValue = 10000;// 最大权值
	private int nodeNum;// 叶节点的个数

	public HaffmanTree(int n) {
		nodeNum = n;
	}

	public void haffman(int[] weight, HaffNode[] node) {
		// 构造权值为weight的哈弗曼树
		int m1, m2, x1, x2;
		int n = nodeNum;

		// 哈弗曼树初始化 n个叶节点的哈弗曼树共有2n-1个节点
		for (int i = 0; i < 2 * n - 1; i++) {
			HaffNode temp = new HaffNode();
			if (i < n) {
				temp.weight = weight[i];
			} else {
				temp.weight = 0;
			}
			temp.parent = 0;
			temp.flag = 0;
			temp.leftChlid = -1;
			temp.rightChild = -1;
			node[i] = temp;
		}
		// 构造哈弗曼树的n-1个非叶节点
		for (int i = 0; i < n - 1; i++) {
			m1 = m2 = maxValue;
			x1 = x2 = 0;
			for (int j = 0; j < n + i; j++) {
				if (node[j].weight < m1 && node[j].flag == 0) {
					m2 = m1;
					x2 = x1;
					m1 = node[j].weight;
					x1 = j;
				} else if (node[j].weight < m2 && node[j].flag == 0) {
					m2 = node[j].weight;
					x2 = j;
				}
			}
			// 将找出的两颗权值最小的子树合并为一颗子树

			node[x1].parent = n + i;
			node[x2].parent = n + i;
			node[x1].flag = 1;
			node[x2].flag = 1;
			node[n + i].weight = node[x1].weight + node[x2].weight;
			node[n + i].leftChlid = x1;
			node[n + i].rightChild = x2;

		}
	}

	public void haffmanCode(HaffNode[] node, Code[] haffCode) {
		// 由哈弗曼树构造哈弗曼编码haffCode
		int n = nodeNum;
		Code cd = new Code(n);
		int child, parent;

		// 求n个叶节点的哈弗曼编码
		for (int i = 0; i < n; i++) {
			cd.start = n - 1; // 不等长编码的最后一位为n-1
			cd.weight = node[i].weight;// 取得编码对应的权值
			child = i;
			parent = node[child].parent;

			while (parent != 0) {
				// 由叶节点向上直到根节点循环
				if (node[parent].leftChlid == child) {
					cd.bit[cd.start] = 0;// 左孩子节点编码为 0
				} else {
					cd.bit[cd.start] = 1;// 右孩子节点编码为1
				}
				cd.start--;
				child = parent;
				parent = node[child].parent;
			}

			Code temp = new Code(n);

			// 保存叶节点的编码和不等长编码的起始位
			for (int j = cd.start + 1; j < n; j++) {
				temp.bit[j] = cd.bit[i];
			}
			temp.start = cd.start;
			temp.weight = cd.weight;
			haffCode[i] = temp;
		}
	}

}

class HaffNode {// 哈弗曼树的节点类
	int weight;// 权重
	int flag;// 标记
	int parent;// 双亲节点下标
	int leftChlid;// 左孩子下标
	int rightChild;// 右孩子下标

	public HaffNode() {

	}
}

class Code {// 哈弗曼编码类
	int[] bit;// 编码用的数组 用于存储节点路径
	int start;// 某一条节点路径 在数组中的开始位置 重要
	int weight;// 字符的权值

	public Code(int n) {
		bit = new int[n];
		start = n - 1;
	}
}