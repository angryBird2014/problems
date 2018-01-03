package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 1/3/18.
 */
public class coinChange {
    public static int solution(int[] coins,int amount){
        if (coins.length==0)
            return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+10);
        dp[0] = 0;

        for (int j=1;j<=amount;j++){
            for (int i=0;i<coins.length;i++){
                if (j>=coins[i])
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return  (dp[amount]>amount)?-1:dp[amount];

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2},3));
    }
}
