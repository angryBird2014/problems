package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/31/17.
 */
//没有AC
public class maximalSquare {
    public static int solution(char[][] matrix){
        if (matrix==null)
            return 0;
        //dp[i][j]为以i,j为终点的最大矩阵(全1)
        int m = matrix.length;
        if (m==0)
            return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] level = new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++)
            if (matrix[i][j]=='1'){
                dp[i][j]=1;
                level[i][j]=0;
            }
            else
                level[i][j]=-1;
        }
        int ans = 0;
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                //要看上一层[i-1][j-1]的level
                int x = i,y=j;
                while (x>=0 && y>=0 && level[x][y]>0){
                    x--;
                    y--;
                }
                int start = matrix[x][y];
                int end = matrix[i][j];
                //遍历



                if (matrix[i-1][j]=='1'&&matrix[i][j-1]=='1'&&matrix[i-1][j-1]=='1'){
                    dp[i][j] = dp[i-1][j-1]+3;
                    //ans = Math.max(dp[i][j],ans);
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dp[i][j]>ans)
                    ans = dp[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(solution(new char[][]{}));
        System.out.println(solution(new char[][]{
                {'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}
                //{'1','1'},{'1','1'}
        }));
    }
}
