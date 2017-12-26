package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/24/17.
 */
public class findTargetSumWays {
    //解法有问题，而且应该不会用递归求解
    public static int solution(int[] nums,int S){
        if (nums.length==0)
            return 0;
        int position=0,currentsum = 0,ways = 0;
        int sumways = dfscore(nums,position,ways,S,currentsum);
        System.out.println(sumways);
        return sumways;
    }
    public static int  dfscore(int[] nums,int position,int ways,int S,int currentsum){
        if (position==nums.length){
            if (S == currentsum)
                ways =  ways+1;
            return ways;
        }
        return dfscore(nums,position+1,ways,S,currentsum+nums[position])
                + dfscore(nums,position+1,ways,S,currentsum-nums[position]);


    }

    //解题思路参考https://kingsfish.github.io/2017/08/22/Leetcode-494-Target-Sum/,转换为0-1背包问题

    public static int solution2(int[] nums,int S){
        int sum = 0;
        for (int i=0;i<nums.length;i++)
            sum += nums[i];
        if (S>sum || (S+sum)%2==1)
            return 0;
        int[] dp = new int[sum+1];
        return 0;
    }


    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1},3);
    }
}
