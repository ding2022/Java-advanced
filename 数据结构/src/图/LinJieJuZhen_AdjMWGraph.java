package 图;

//初始情况下 图的邻接矩阵的大小已经确定 后续可往里面插入节点 边 删除节点 边等
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import 树和二叉树.Visit;
//包括的函数有 构造函数 返回节点个数 返回边个数 返回节点数值 得到相邻节点 得到相邻节点的相邻节点 
//删除边 插入边 得到边的权值 
//图的遍历  深度优先遍历   广度优先遍历  非连通图的深度优先遍历  非连通图的广度优先遍历 

public class LinJieJuZhen_AdjMWGraph {
	static final int maxWeight = 10000;

	private ArrayList<Object> vertices; // 存储节点的数据的线性表

	private int[][] edge; // 存储边的二维数组
	private int numOfEdges; // 边的个数

	public LinJieJuZhen_AdjMWGraph(int maxV) {// 初始化图的矩阵 及数据
		vertices = new ArrayList<Object>();
		edge = new int[maxV][maxV];

		for (int i = 0; i < maxV; i++) {
			for (int j = 0; j < maxV; j++) {
				if (i == j)
					edge[i][j] = 0;
				else {
					edge[i][j] = maxWeight;
				}
			}
		}
		numOfEdges = 0;
	}

	public int getNumOfVertices() {// 返回节点个数
		return vertices.size();
	}

	public int getNumOfEdges() {// 返回边的个数
		return numOfEdges;
	}

	public Object getValue(int v) throws Exception {// 返回节点v的数据元素
		return vertices.get(v);
	}

	public int getWeight(int v1, int v2) throws Exception {
		// 返回边<v1,v2>的权值
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		return edge[v1][v2];
	}

	public void insertVertex(Object vertex) throws Exception {
		// 插入节点
		vertices.add(vertex);
	}

	public void insertEdge(int v1, int v2, int weight) throws Exception {
		// 插入边<v1,v2>，权值为weight
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		edge[v1][v2] = weight;
		numOfEdges++;
	}

	public void deleteEdge(int v1, int v2) throws Exception {
		// 删除边<v1,v2>
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		if (edge[v1][v2] == maxWeight || v1 == v2) {
			throw new Exception();
		}
		edge[v1][v2] = maxWeight;
		numOfEdges--;
	}

	public int getFirstNeighbor(int v) throws Exception {
		// 取节点V的第一个邻接节点 若存在返回该节点的下标序号 否则返回-1
		if (v < 0 || v > vertices.size()) {
			throw new Exception();
		}
		for (int col = 0; col < vertices.size(); col++) {
			if (edge[v][col] > 0 && edge[v][col] < maxWeight) {
				return col;
			}
		}
		return -1;
	}

	public int getNextNeighbor(int v1, int v2) throws Exception {
		// 取节点v1的邻接节点v2后的邻接节点 存在的话返回其下标号
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		for (int col = v2 + 1; col < vertices.size(); col++) {
			if (edge[v1][col] > 0 && edge[v1][col] < maxWeight)
				return col;
		}
		return -1;
	}

	// 深度优先类似于树的先序遍历 广度优先类似于树的层序遍历（借助队列）
	private void depthFirstSearch(int v, boolean[] visited, Visit vs)
			throws Exception {
		// 深度优先借助递归
		// visited[] 用来标记节点是否已经被访问过
		vs.print(getValue(v));
		visited[v] = true;// 把当前节点标记为 已经访问过

		int w = getFirstNeighbor(v);// 得到邻接节点
		while (w != -1) {// 邻接节点存在时循环
			if (!visited[w]) {// 没有被访问过
				depthFirstSearch(w, visited, vs);// 以w为初始节点递归
			}
			w = getNextNeighbor(v, w);// 取得下一个邻接节点 当以相邻节点起始的位置遍历到终点时 开始转向先一个相邻节点
										// 以这个为开始进行递归
		}
	}

	private void broadFirstSearch(int v, boolean[] visited, Visit vs)
			throws Exception {
		// 每一次的移除作为下一层的移入
		int u, w;

		LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();

		vs.print(getValue(v));
		visited[v] = true;

		queue.add(new Integer(v));// 节点v入队列
		while (!queue.isEmpty()) {// 队列非空
			u = (int) queue.remove();// 出队列
			w = getFirstNeighbor(u);// 取得u的第一个邻接节点、、进入到下一层节点中

			while (w != -1) {
				if (!visited[w]) {
					vs.print(getValue(w));
					visited[w] = true;
					queue.add(new Integer(w));// 节点w入队列 加入的是下一层节点的位置
				}
				w = getNextNeighbor(u, w);// 此处用于在同深度的之间遍历的转换 下一层的节点已经被加入队列中了
			}
		}
	}

	public void depthFirstSearch(Visit vs) throws Exception {
		// 非连通图的深度优先遍历 //即有的节点 单独出来了 没有连到图中 对每张图都进行深度优先遍历
		boolean[] visited = new boolean[getNumOfVertices()];
		for (int i = 0; i < getNumOfVertices(); i++) {
			visited[i] = false;
		}
		for (int i = 0; i < getNumOfVertices(); i++) {
			if (!visited[i]) {
				depthFirstSearch(i, visited, vs);
			}
		}
	}

	public void broadFirstSearch(Visit vs) throws Exception {
		// 非连通图的深度优先遍历 //即有的节点 单独出来了 没有连到图中 对每张图都进行深度优先遍历
		boolean[] visited = new boolean[getNumOfVertices()];
		for (int i = 0; i < getNumOfVertices(); i++) {
			visited[i] = false;
		}
		for (int i = 0; i < getNumOfVertices(); i++) {
			if (!visited[i]) {
				broadFirstSearch(i, visited, vs);
			}
		}
	}
}
