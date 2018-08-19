package leetcode;

import java.util.Arrays;

public class rob1 {
    public int solution(int[] nums){
        if (nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        int max = Integer.MIN_VALUE;
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new rob1().solution(new int[]{1}));
    }
}
