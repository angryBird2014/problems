package leetcode;

import java.util.Arrays;

public class N_number {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5,6,7};
        int target = 5;
        System.out.println(dfs(numbers,target,0));
        System.out.println(dp(numbers,target));
        System.out.println(dp2(numbers,target));
        System.out.println(dfs2(numbers,target,0,0));
        System.out.println(dp3(numbers,target));
    }
    public static boolean dfs(int[] numbers,int target,int index){
        if (index >= numbers.length) return false;
        if(target<0) return false;
        if (target==0) return true;
        return dfs(numbers,target,index+1) || dfs(numbers,target-numbers[index],index+1);
    }

    public static boolean dp(int[] numbers,int target){
        boolean[][] dp = new boolean[numbers.length+1][target+1];
        //dp[0][0] = true;
        for (int i=0;i<numbers.length+1;i++)
            Arrays.fill(dp[i],false);
        for(int i=1;i<target+1;i++)
            dp[0][i] = false;
        for (int i=0;i<numbers.length+1;i++)
            dp[i][0] = true;
        for (int i=1;i<numbers.length+1;i++){
            for (int j=1;j<target+1;j++){
                dp[i][j] = dp[i-1][j];
                if (numbers[i-1]<=j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-numbers[i-1]];
                }

            }
        }
        return dp[numbers.length][target];
    }

    public static boolean dp2(int[] numbers,int target){
        boolean[][] dp = new boolean[numbers.length][target];
        for (int i=0;i<numbers.length;i++)
            Arrays.fill(dp[i],false);
        for(int i=0;i<target;i++)
            dp[0][i] = false;
        for (int i=0;i<numbers.length;i++)
            dp[i][0] = true;
        for (int i=1;i<numbers.length;i++){
            for (int j=0;j<target;j++){
                dp[i][j] = dp[i-1][j];
                if (numbers[i]<=j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-numbers[i]];
                }
            }
        }
        return dp[numbers.length-1][target-1];
    }

    public static int dfs2(int[] numbers,int target,int index,int count){
        if (target<0)
            return count;
        if (index==numbers.length){
            if (target==0)
                count ++;
            return count;
        }
        return dfs2(numbers,target,index+1,count) + dfs2(numbers,target-numbers[index],index+1,count);
    }

    //求总数
    public static int dp3(int[] numbers,int target){
        int[] dp = new int[target+1];
        dp[0] = 1;


        for (int i=0;i<numbers.length;i++){
            for (int j=target;j>=numbers[i];j--){
               dp[j] += dp[j-numbers[i]];
            }
        }
        return dp[target];
    }


}
