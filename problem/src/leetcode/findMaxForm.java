package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/27/17.
 */
public class findMaxForm {
    //m(0),n(1)
    //0-1背包问题dp[i][m][n]
    public static int solution(String[] strs,int m ,int n){
        int size = strs.length;
        int[][][] dp = new int[size+1][m+1][n+1];
        //Arrays.fill(dp,0);
        for (int k=0;k<m;k++)
            for (int p=0;p<n;p++)
                dp[0][k][p]=0;
        for (int i=1;i<size+1;i++){
            int[] nums = calculate(strs[i-1]);
            for (int k=0;k<m+1;k++){
                for (int p=0;p<n+1;p++) {
                    if (k >= nums[0] && p >= nums[1])
                        dp[i][k][p] = Math.max(dp[i - 1][k][p], dp[i - 1][k - nums[0]][p - nums[1]]+1);
                    else
                        dp[i][k][p] = dp[i-1][k][p];
                    }
                }
        }
        return dp[size][m][n];
    }

    public static int[] calculate(String s){
        int[] nums = new int[]{0,0};
        for (int i=0;i<s.length();i++){
            nums[s.charAt(i)-'0'] ++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"10", "0", "1"},1,1));
    }
}
