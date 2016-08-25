package 图;

//狄克斯特拉算法 求解最短路径  两个集合 S T  S中存着已经找到最短路径的节点  T中为未找到最短路径的节点
//初始s中只有源节点 然后从t中选出权重最小的邻接节点 加入s中 然后以新加入的节点为源节点寻找下一节点   直到t为空为止
//这样全部最小路径节找到
public class Dijkstra {
	static final int maxWeight = 9999;

	public static void dijkstra(LinJieJuZhen_AdjMWGraph g, int v0,
			int[] distance, int path[]) throws Exception {
		// g从下标为v0的节点到其他节点的最短距离distance
		// 和相应的目标节点的前一节点下标path

		int n = g.getNumOfVertices();
		int[] s = new int[n];// s用来存放n个节点的标记
		int minDis, u = 0;

		// 初始化
		for (int i = 0; i < n; i++) {
			distance[i] = g.getWeight(v0, i);
			s[i] = 0;// 初始军标记为0
			if (i != v0 && distance[i] < maxWeight) {
				path[i] = v0; // v0节点为初始节点 为前一个的
			} else {
				path[i] = -1;
			}
		}

		s[v0] = 1;// 标记节点v0已经从集合T加入到集合s中

		// 从T中选择出有最短距离的节点u
		for (int i = 1; i < n; i++) {
			minDis = maxWeight;
			for (int j = 0; j < n; j++) {
				if (s[j] == 0 && distance[j] < minDis) {// 未分配 且距离最小
					u = j;
					minDis = distance[j];
				}
			}
			// 不存在路径时算法结束 主要考虑到非连通图
			if (minDis == maxWeight)
				return;
			
			s[u] = 1;// 加入节点到S
			// 修改v0到其他节点的最短距离和最短路径

			for (int j = 0; j < n; j++) {
				if (s[j] == 0 && g.getWeight(u, j) < maxWeight
						&& distance[u] + g.getWeight(u, j) < distance[j]) {
					distance[j]=distance[u] + g.getWeight(u, j);//节点v0经过u到其他节点的最短距离和最短路径
					path[j]=u;//作为下一个路径起始点
				}
			}
		}
	}
}
