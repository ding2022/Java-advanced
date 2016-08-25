package 图;
//普利姆算法 克鲁斯卡尔算法
//最小生成树
public class MinSpanTree {// 最小生成树的每个边节点
	Object vertex; // 每条边的弧头节点数据 起始节点数据
	int weight; // 权值

	MinSpanTree() {

	}

	MinSpanTree(Object obj, int w) {
		vertex = obj;
		weight = w;
	}
}
//普利姆算法
class Prim {
	static final int maxWeight = 9999;

	public static void prim(LinJieJuZhen_AdjMWGraph g, MinSpanTree[] closeVertex)
			throws Exception {
		int n = g.getNumOfVertices();
		int minCost;
		int[] lowCost = new int[n];
		int k = 0;

		for (int i = 1; i < n; i++) {
			lowCost[i] = g.getWeight(0, i);// lowCost的初始值
		}
		MinSpanTree temp = new MinSpanTree();

		// 从节点0出发构造最小生成树
		temp.vertex = g.getValue(0);
		closeVertex[0] = temp;// 保存节点0
		lowCost[0] = -1;// 标记节点0

		for (int i = 1; i < n; i++) {
			// 寻找当前最小权值的边所对应的弧头节点k
			minCost = maxWeight;// maxweight为定义的最大权值
			for (int j = 1; j < n; j++) {
				if (lowCost[j] < minCost && lowCost[j] > 0) {
					minCost = lowCost[j];
					k = j;
				}
			}
			MinSpanTree curr = new MinSpanTree();
			curr.vertex = g.getValue(k); // 保存弧头节点k
			curr.weight = minCost; // 保存相应权值
			closeVertex[i] = curr;	//保存当前的节点到树中
			lowCost[k] = -1; // 标记节点k

			for (int j = 1; j < n; j++) {
				if (g.getWeight(k, j) < lowCost[j])
					lowCost[j] = g.getWeight(k, j);
			}
		}
	}
}
