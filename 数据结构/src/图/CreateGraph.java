package 图;
//此类主要用于对创建好的图 进行数据的插入等 
public class CreateGraph {
	int row;
	int col;
	int weight;

	public CreateGraph(LinJieJuZhen_AdjMWGraph g, Object[] v, int n,
			CreateGraph[] cg, int e) throws Exception {
		//g为图 v为数据元素集合 n为节点个数 cg为边的集合 e为边的个数
		for(int i=0;i<n;i++){
			g.insertVertex(v[i]);
		}
		for(int k=0;k<e;k++){
			g.insertEdge(cg[k].row, cg[k].col, cg[k].weight);
		}
	}
}
