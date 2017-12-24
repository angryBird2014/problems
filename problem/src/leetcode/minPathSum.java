package leetcode;

/**
 * Created by xyan on 12/22/17.
 */
public class minPathSum {
    public static int solution(int[][] grid){
        int m = grid.length,n = grid[0].length;
        int[][] mincost = new int[grid.length][grid[0].length];
        mincost[0][0] = grid[0][0];
        for (int i=1;i<m;i++){
            mincost[i][0] = mincost[i-1][0]+grid[i][0];
        }
        for (int j=1;j<n;j++)
            mincost[0][j] = mincost[0][j-1]+grid[0][j];
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                mincost[i][j] = grid[i][j] + Math.min(mincost[i-1][j],mincost[i][j-1]);
            }
        }
        System.out.println(mincost[m-1][n-1]);
        return mincost[m-1][n-1];
    }

    public static void main(String[] args) {
        solution(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

}
