package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 1/3/18.
 */
public class minSteps {
    public static int solution(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for (int k=2;k<=n;k++){
            for (int j=1;j<k;j++){
                if (k%j==0)
                    dp[k] = Math.min(dp[k],dp[j]+k/j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
