package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/27/17.
 */
public class canPartition {
    //0-1背包问题(在子集中选取一些元素使其之和为特定的数)
    /*
     dp[i][j]表示从0-i选取若干元素之和为j,取值为true(1)或false(0)
     */
    public static boolean solution2(int[] nums){
        int sum = Arrays.stream(nums).sum();
        if ((sum&1)==1)
            return false;
        int target = sum/2;
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],0);
        }
        dp[0][0] = 1;
        for (int i=1;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for (int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for (int i=1;i<n;i++){
            for (int j=nums[i];j<target+1;j++){
                dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
            }
        }
        return dp[n-1][target]==0?false:true;
    }


    /*//递归搜索(暴力搜索)
    public static boolean solution(int[] nums){
        int sum = Arrays.stream(nums).sum(),k=2;
        if (sum%2!=0)
            return false;
        int target = sum/2;
        int index = nums.length-1;
        Arrays.sort(nums);
        if (nums[index]>target)
            return false;
        while (nums[index]==target && index>0){
            index--;
            k--;
        }
        if (k<0)
            return false;
        return search(nums,target,index,new int[k]);
    }

    public static boolean search(int[] nums,int target,int index,int[] group){
        //将nums[index]尝试放入group中
        if (index<0){
            return true;
        }
        for(int i=0;i<group.length;i++){
            int ele = nums[index];
            if (group[i]+ele<=target){
                group[i]+=ele;
                if (search(nums,target,index-1,group)) return true;
                group[i]-=ele;
            }
        }
        return false;
    }
    */
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1, 2, 3, 5}));
    }
}
