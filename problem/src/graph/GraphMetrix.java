package graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xyan on 10/11/17.
 */
public class GraphMetrix {

    public void CreateGraph(MGraph graph,int vexs,char[] nodes ,int[][] edges){
        for(int i=0;i<vexs;i++)
            graph.nodes[i] = nodes[i];
        for (int i=0;i<vexs;i++)
            for (int j=0;j<vexs;j++)
                graph.edges[i][j] = edges[i][j];
    }

    public void ShowGraph(MGraph graph){
        int vexs=graph.vexs;
        int [][]weight=graph.edges;
        int i,j;
        for(i=0;i<vexs;i++){
            System.out.print(graph.nodes[i]+":");
            for(j=0;j<vexs;j++){
                System.out.print(weight[i][j]+" ");
            }
            System.out.println();
        }
    }

    //获取当前节点的第一个邻接顶点位置
    public int GetFirst(MGraph graph,int k){
        if(k<0||k>graph.vexs-1) {
            System.out.println("不存在的顶点");
            return -1;
        }
        for (int i=0;i<=graph.vexs-1;i++){
            if (graph.edges[k][i]==1)
                return i;
        }
        return -1;
    }

    //获取当前顶点K的第t个邻接顶点下一个邻接顶点的位置
    public int GetNext(MGraph graph,int k,int v){
        if(k<0||k>graph.vexs-1||v<0||v>graph.vexs-1){
            System.out.println("不存在顶点");
            return -1;
        }
        for (int i=v+1;i<=graph.vexs-1;i++)
            if (graph.edges[k][i]==1)
                return i;
        return -1;
    }

    //广度优先遍历
    public void BFS(MGraph graph,int k){
        int[] visited = new int[graph.vexs];    //定义标记数组
        for (int i=0;i<visited.length-1;i++)
            visited[i] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited[k]=1;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(graph.nodes[tmp]+", ");
            int v = GetFirst(graph,tmp);
            while(v!=-1){
                if(visited[v]==0){  //节点v没有被访问
                    queue.add(v);
                    visited[v] = 1;
                }
                v = GetNext(graph,tmp,v);
            }
        }
    }

    //深度优先遍历
    public void DFS(MGraph graph,int k,int[] visited){
            System.out.print(graph.nodes[k]+", ");
            visited[k]=1;
            int u = GetFirst(graph,k);
            while (u!=-1) {
                if (visited[u] == 0) {
                    visited[u] = 1;
                    DFS(graph, u, visited);
                }
                u = GetNext(graph, k, u);

            }
    }

    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E'};
        int vexs=data.length;
        int[][] weight=new int[][]{
                {0,1,0,0,1},
                {1,0,1,1,0},
                {0,1,0,0,0},
                {0,1,0,0,1},
                {1,0,0,1,0}
        };
        int[] visited = new int[vexs];
        for (int i=0;i<vexs;i++)
            visited[i]=0;
        MGraph graph=new MGraph(vexs);
        GraphMetrix gam=new GraphMetrix();
        gam.CreateGraph(graph,vexs,data,weight);
        gam.ShowGraph(graph);
        gam.BFS(graph,0);
        System.out.println("------");
        gam.DFS(graph,0,visited);
    }

}
