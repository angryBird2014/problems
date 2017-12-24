package graph;

/**
 * Created by xyan on 10/11/17.
 */
//邻接矩阵
public class MGraph {
    int vexs;  //顶点个数
    char[] nodes;  //顶点集合
    int[][] edges;  //边集合

    public MGraph(int nodes){
        this.vexs = nodes;
        this.nodes = new char[nodes];
        this.edges = new int[nodes][nodes];
    }
}
