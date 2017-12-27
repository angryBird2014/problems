package leetcode;

/**
 * Created by xyan on 12/26/17.
 */
public class numSquares {

    public static int solution(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1;i<=n;i++){
            int minTem = Integer.MAX_VALUE;
            for (int j=1;j*j <= i;j++){
                minTem = Math.min(minTem,dp[i-j*j]+1);
            }
            dp[i] = minTem;
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        solution(10);
    }
}
