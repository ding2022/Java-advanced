package ͼ;
//����ķ�㷨 ��³˹�����㷨
//��С������
public class MinSpanTree {// ��С��������ÿ���߽ڵ�
	Object vertex; // ÿ���ߵĻ�ͷ�ڵ����� ��ʼ�ڵ�����
	int weight; // Ȩֵ

	MinSpanTree() {

	}

	MinSpanTree(Object obj, int w) {
		vertex = obj;
		weight = w;
	}
}
//����ķ�㷨
class Prim {
	static final int maxWeight = 9999;

	public static void prim(LinJieJuZhen_AdjMWGraph g, MinSpanTree[] closeVertex)
			throws Exception {
		int n = g.getNumOfVertices();
		int minCost;
		int[] lowCost = new int[n];
		int k = 0;

		for (int i = 1; i < n; i++) {
			lowCost[i] = g.getWeight(0, i);// lowCost�ĳ�ʼֵ
		}
		MinSpanTree temp = new MinSpanTree();

		// �ӽڵ�0����������С������
		temp.vertex = g.getValue(0);
		closeVertex[0] = temp;// ����ڵ�0
		lowCost[0] = -1;// ��ǽڵ�0

		for (int i = 1; i < n; i++) {
			// Ѱ�ҵ�ǰ��СȨֵ�ı�����Ӧ�Ļ�ͷ�ڵ�k
			minCost = maxWeight;// maxweightΪ��������Ȩֵ
			for (int j = 1; j < n; j++) {
				if (lowCost[j] < minCost && lowCost[j] > 0) {
					minCost = lowCost[j];
					k = j;
				}
			}
			MinSpanTree curr = new MinSpanTree();
			curr.vertex = g.getValue(k); // ���满ͷ�ڵ�k
			curr.weight = minCost; // ������ӦȨֵ
			closeVertex[i] = curr;	//���浱ǰ�Ľڵ㵽����
			lowCost[k] = -1; // ��ǽڵ�k

			for (int j = 1; j < n; j++) {
				if (g.getWeight(k, j) < lowCost[j])
					lowCost[j] = g.getWeight(k, j);
			}
		}
	}
}
