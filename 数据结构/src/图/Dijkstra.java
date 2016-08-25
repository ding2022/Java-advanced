package ͼ;

//�ҿ�˹�����㷨 ������·��  �������� S T  S�д����Ѿ��ҵ����·���Ľڵ�  T��Ϊδ�ҵ����·���Ľڵ�
//��ʼs��ֻ��Դ�ڵ� Ȼ���t��ѡ��Ȩ����С���ڽӽڵ� ����s�� Ȼ�����¼���Ľڵ�ΪԴ�ڵ�Ѱ����һ�ڵ�   ֱ��tΪ��Ϊֹ
//����ȫ����С·�����ҵ�
public class Dijkstra {
	static final int maxWeight = 9999;

	public static void dijkstra(LinJieJuZhen_AdjMWGraph g, int v0,
			int[] distance, int path[]) throws Exception {
		// g���±�Ϊv0�Ľڵ㵽�����ڵ����̾���distance
		// ����Ӧ��Ŀ��ڵ��ǰһ�ڵ��±�path

		int n = g.getNumOfVertices();
		int[] s = new int[n];// s�������n���ڵ�ı��
		int minDis, u = 0;

		// ��ʼ��
		for (int i = 0; i < n; i++) {
			distance[i] = g.getWeight(v0, i);
			s[i] = 0;// ��ʼ�����Ϊ0
			if (i != v0 && distance[i] < maxWeight) {
				path[i] = v0; // v0�ڵ�Ϊ��ʼ�ڵ� Ϊǰһ����
			} else {
				path[i] = -1;
			}
		}

		s[v0] = 1;// ��ǽڵ�v0�Ѿ��Ӽ���T���뵽����s��

		// ��T��ѡ�������̾���Ľڵ�u
		for (int i = 1; i < n; i++) {
			minDis = maxWeight;
			for (int j = 0; j < n; j++) {
				if (s[j] == 0 && distance[j] < minDis) {// δ���� �Ҿ�����С
					u = j;
					minDis = distance[j];
				}
			}
			// ������·��ʱ�㷨���� ��Ҫ���ǵ�����ͨͼ
			if (minDis == maxWeight)
				return;
			
			s[u] = 1;// ����ڵ㵽S
			// �޸�v0�������ڵ����̾�������·��

			for (int j = 0; j < n; j++) {
				if (s[j] == 0 && g.getWeight(u, j) < maxWeight
						&& distance[u] + g.getWeight(u, j) < distance[j]) {
					distance[j]=distance[u] + g.getWeight(u, j);//�ڵ�v0����u�������ڵ����̾�������·��
					path[j]=u;//��Ϊ��һ��·����ʼ��
				}
			}
		}
	}
}
