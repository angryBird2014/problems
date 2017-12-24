package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/24/17.
 */
public class findTargetSumWays {
    /*解法有问题，而且应该不会用递归求解
    public static int solution(int[] nums,int s){
        if (nums.length==0)
            return 0;
        int position=0,currentsum = 0,ways = 0;
        dfscore(nums,position,ways,s,currentsum);
        System.out.println(ways);
        return ways;
    }
    public static void dfscore(int[] nums,int position,int ways,int s,int currentsum){
        if (position==nums.length-1){
            if (s == currentsum)
                ways =  ways+1;
            return;
        }
        dfscore(nums,position+1,ways,s,currentsum+nums[position]);
        dfscore(nums,position+1,ways,s,currentsum-nums[position]);


    }
    */
    //解题思路参考https://kingsfish.github.io/2017/08/22/Leetcode-494-Target-Sum/,转换为0-1背包问题
    public static int solution2(int[] nums,int s){

    }


    public static void main(String[] args) {
        solution2(new int[]{1,1,1,1,1},3);
    }
}
