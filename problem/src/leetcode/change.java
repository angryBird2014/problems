package leetcode;

import java.util.Arrays;

public class change {
    public int solution(int amount,int[] coins){
        if (coins==null||coins.length==0)
            return 0;
        int count = 0;
        Arrays.sort(coins);
        dfs(coins,amount,0,count);
        return count;
    }
    public int dfs(int[] coins,int sum,int index,int count){
        if (index>coins.length||sum<0)
            return count;
        if (index==coins.length){
            if (sum==0)
                count++;
            return count;
        }
        return dfs(coins,sum,index,count) + dfs(coins,sum-coins[index],index,count) + dfs(coins,sum-coins[index],index+1,count);
    }

    public static void main(String[] args) {
        //System.out.println(new change().solution(2,new int[]{2}));
        System.out.println(new change().dp(5,new int[]{1,2,5}));
    }

    public int dp(int amount,int[] coins){
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i=0;i<coins.length+1;i++)
            Arrays.fill(dp[i],0);
        for (int i=0;i<coins.length+1;i++)
            dp[i][0] = 1;
        for (int i=0;i<amount+1;i++)
            dp[0][i] = 0;
        dp[0][0] = 1;
        for (int i=1;i<coins.length+1;i++){
            for (int j=0;j<amount+1;j++){
                dp[i][j] = dp[i-1][j];
                if (j>=coins[i-1])
                    dp[i][j] += dp[i][j-coins[i-1]];

            }
        }
        return dp[coins.length][amount];

    }
}
