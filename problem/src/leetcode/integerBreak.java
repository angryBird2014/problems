package leetcode;

/**
 * Created by xyan on 1/3/18.
 */
public class integerBreak {
    public static int solution(int n){
        if (n<=2)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2;i<n+1;i++){
            for (int j=1;j<i;j++){
                dp[i] =Math.max(dp[i],Math.max(j,dp[j])*Math.max(i-j,dp[i-j])); //i分解j和i-j，但是j与dp[j]，i-j与dp[i-j]还要比较8,2*2*3
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
