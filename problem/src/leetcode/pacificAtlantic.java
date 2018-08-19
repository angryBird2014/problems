package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class pacificAtlantic {
    int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public List<int[]> solution(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<int[]> arrayList = new ArrayList<>();
        if (matrix==null ||m==0||n==0)
            return arrayList;
        Queue<int[]> Pqueue = new LinkedList<>();
        Queue<int[]> Aqueue = new LinkedList<>();
        boolean[][] pvisited = new boolean[m][n];
        boolean[][] avisited = new boolean[m][n];
        for (int i=0;i<m;i++){
            Pqueue.offer(new int[]{i,0});
            Aqueue.offer(new int[]{i,n-1});
            pvisited[i][0] = true;
            avisited[i][n-1] = true;
        }
        for(int i=0;i<n;i++){
            Pqueue.offer(new int[]{0,i});
            Aqueue.offer(new int[]{m-1,i});
            pvisited[0][i] = true;
            avisited[m-1][i] = true;
        }
        bfs(matrix,Pqueue,pvisited);
        bfs(matrix,Aqueue,avisited);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++)
                if (pvisited[i][j] && avisited[i][j])
                    arrayList.add(new int[]{i,j});
        }
        return arrayList;

    }
    public void bfs(int[][] matrix,Queue<int[]> queue,boolean[][] visited){
        int m = matrix.length,n = matrix[0].length;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            for (int[] dir:dirs){
                int newx = dir[0]+ node[0];
                int newy =dir[1] + node[1];
                if(newx<0 || newx >= m || newy <0 || newy>=n || visited[newx][newy]==true || matrix[newx][newy] < matrix[node[0]][node[1]])
                    continue;
                visited[newx][newy] = true;
                queue.offer(new int[]{newx,newy});

            }
        }

    }

    public static void main(String[] args) {

        ArrayList<int[]> result = (ArrayList<int[]>) new pacificAtlantic().solution(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i)[0]+"\t"+result.get(i)[1]);
        }
    }
}
