package ͼ;

//��ʼ����� ͼ���ڽӾ���Ĵ�С�Ѿ�ȷ�� ���������������ڵ� �� ɾ���ڵ� �ߵ�
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import ���Ͷ�����.Visit;
//�����ĺ����� ���캯�� ���ؽڵ���� ���ر߸��� ���ؽڵ���ֵ �õ����ڽڵ� �õ����ڽڵ�����ڽڵ� 
//ɾ���� ����� �õ��ߵ�Ȩֵ 
//ͼ�ı���  ������ȱ���   ������ȱ���  ����ͨͼ��������ȱ���  ����ͨͼ�Ĺ�����ȱ��� 

public class LinJieJuZhen_AdjMWGraph {
	static final int maxWeight = 10000;

	private ArrayList<Object> vertices; // �洢�ڵ�����ݵ����Ա�

	private int[][] edge; // �洢�ߵĶ�ά����
	private int numOfEdges; // �ߵĸ���

	public LinJieJuZhen_AdjMWGraph(int maxV) {// ��ʼ��ͼ�ľ��� ������
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

	public int getNumOfVertices() {// ���ؽڵ����
		return vertices.size();
	}

	public int getNumOfEdges() {// ���رߵĸ���
		return numOfEdges;
	}

	public Object getValue(int v) throws Exception {// ���ؽڵ�v������Ԫ��
		return vertices.get(v);
	}

	public int getWeight(int v1, int v2) throws Exception {
		// ���ر�<v1,v2>��Ȩֵ
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		return edge[v1][v2];
	}

	public void insertVertex(Object vertex) throws Exception {
		// ����ڵ�
		vertices.add(vertex);
	}

	public void insertEdge(int v1, int v2, int weight) throws Exception {
		// �����<v1,v2>��ȨֵΪweight
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		edge[v1][v2] = weight;
		numOfEdges++;
	}

	public void deleteEdge(int v1, int v2) throws Exception {
		// ɾ����<v1,v2>
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
		// ȡ�ڵ�V�ĵ�һ���ڽӽڵ� �����ڷ��ظýڵ���±���� ���򷵻�-1
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
		// ȡ�ڵ�v1���ڽӽڵ�v2����ڽӽڵ� ���ڵĻ��������±��
		if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
			throw new Exception();
		}
		for (int col = v2 + 1; col < vertices.size(); col++) {
			if (edge[v1][col] > 0 && edge[v1][col] < maxWeight)
				return col;
		}
		return -1;
	}

	// ������������������������ ����������������Ĳ���������������У�
	private void depthFirstSearch(int v, boolean[] visited, Visit vs)
			throws Exception {
		// ������Ƚ����ݹ�
		// visited[] ������ǽڵ��Ƿ��Ѿ������ʹ�
		vs.print(getValue(v));
		visited[v] = true;// �ѵ�ǰ�ڵ���Ϊ �Ѿ����ʹ�

		int w = getFirstNeighbor(v);// �õ��ڽӽڵ�
		while (w != -1) {// �ڽӽڵ����ʱѭ��
			if (!visited[w]) {// û�б����ʹ�
				depthFirstSearch(w, visited, vs);// ��wΪ��ʼ�ڵ�ݹ�
			}
			w = getNextNeighbor(v, w);// ȡ����һ���ڽӽڵ� �������ڽڵ���ʼ��λ�ñ������յ�ʱ ��ʼת����һ�����ڽڵ�
										// �����Ϊ��ʼ���еݹ�
		}
	}

	private void broadFirstSearch(int v, boolean[] visited, Visit vs)
			throws Exception {
		// ÿһ�ε��Ƴ���Ϊ��һ�������
		int u, w;

		LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();

		vs.print(getValue(v));
		visited[v] = true;

		queue.add(new Integer(v));// �ڵ�v�����
		while (!queue.isEmpty()) {// ���зǿ�
			u = (int) queue.remove();// ������
			w = getFirstNeighbor(u);// ȡ��u�ĵ�һ���ڽӽڵ㡢�����뵽��һ��ڵ���

			while (w != -1) {
				if (!visited[w]) {
					vs.print(getValue(w));
					visited[w] = true;
					queue.add(new Integer(w));// �ڵ�w����� ���������һ��ڵ��λ��
				}
				w = getNextNeighbor(u, w);// �˴�������ͬ��ȵ�֮�������ת�� ��һ��Ľڵ��Ѿ��������������
			}
		}
	}

	public void depthFirstSearch(Visit vs) throws Exception {
		// ����ͨͼ��������ȱ��� //���еĽڵ� ���������� û������ͼ�� ��ÿ��ͼ������������ȱ���
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
		// ����ͨͼ��������ȱ��� //���еĽڵ� ���������� û������ͼ�� ��ÿ��ͼ������������ȱ���
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
