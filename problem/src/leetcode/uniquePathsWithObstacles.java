package leetcode;

/**
 * Created by xyan on 12/22/17.
 */
public class uniquePathsWithObstacles {
    public static int solution(int[][] obstacleGrid){
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        int i=0,j=0;
        for (;j<n && obstacleGrid[0][j]==0;j++)
            path[0][j]=1;
        for (;j<n;j++)
            path[0][j]=0;
        for (;i<m && obstacleGrid[i][0]==0;i++)
            path[i][0]=1;
        for (;i<m;i++)
            path[i][0]=0;

        for(i=1;i<m;i++){
            for (j=1;j<n;j++){
                if (obstacleGrid[i][j]==1)
                    path[i][j] = 0;
                else{
                    path[i][j] = path[i-1][j]+path[i][j-1];
                }
            }
        }
        //System.out.println(path[m-1][n-1]);
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
        solution(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }
}
