package ͼ;
//������Ҫ���ڶԴ����õ�ͼ �������ݵĲ���� 
public class CreateGraph {
	int row;
	int col;
	int weight;

	public CreateGraph(LinJieJuZhen_AdjMWGraph g, Object[] v, int n,
			CreateGraph[] cg, int e) throws Exception {
		//gΪͼ vΪ����Ԫ�ؼ��� nΪ�ڵ���� cgΪ�ߵļ��� eΪ�ߵĸ���
		for(int i=0;i<n;i++){
			g.insertVertex(v[i]);
		}
		for(int k=0;k<e;k++){
			g.insertEdge(cg[k].row, cg[k].col, cg[k].weight);
		}
	}
}
