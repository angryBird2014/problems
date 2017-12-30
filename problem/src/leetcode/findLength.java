package leetcode;

/**
 * Created by xyan on 12/30/17.
 */
public class findLength {
    //dp[i][j]表示串1以i结尾的子串和以j结尾的子串的公共子串的最大长度(连续)
    //当s1[i]==s1[j]时,dp[i][j]=dp[i-1][j-1]+1,不相等时为0;
    //largest common sequence中不需要连续，所以s1[i]!=s2[j]时，dp[i][j] = max(dp[i][j-1],dp[i-1][j])
    public static int solution(int[] A,int[] B){
        int[][] dp = new int[A.length+1][B.length+1];
        for (int i=0;i<A.length+1;i++)
            dp[i][0] = 0;
        for (int j=0;j<B.length+1;j++)
            dp[0][j]=0;
        int result = 0;
        for (int i=1;i<A.length+1;i++){
            for (int j=1;j<B.length+1;j++){
                if (A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    result = Math.max(result,dp[i][j]);
                }

                else
                    //dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,2,1},new int[]{3,2,1,4,7}));
    }
}
