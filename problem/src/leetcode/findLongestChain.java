package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/30/17.
 */
public class findLongestChain {
    //贪心做法
    public static int solution(int[][] pairs){
        int m = pairs.length;

        if (m==0)
            return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);//非常重要
        int[] dp = new int[m+1];
        dp[0] = 0;
        int maxValue = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=1;i<m+1;i++){
            //一种是不取
            int tmp = dp[i-1];
            //取了，并且可以取
            if (pairs[i-1][0]>maxValue){
                dp[i] = dp[i-1]+1;
                maxValue = pairs[i-1][1];
            }
            dp[i] = Math.max(dp[i],tmp);
            if (dp[i]>max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3,4},{2,3},{1,2}}));
    }
}
