package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xyan on 1/3/18.
 */
public class deleteAndEarn {
    //有问题
    public static int solution(int[] nums){
        int[] flag = new int[nums.length];
        Arrays.fill(flag,0);
        int index  =0;
        int count = 0;
        return score(nums,flag,0,0);
    }
    public static int score(int[] nums,int[] flag,int index,int count){
        if (index==nums.length)
            return count;
        int s = 0;
        int[] flag2 = flag;
        for (int i =0;i<nums.length;i++)
            flag2[i] = flag[i];
        for (int i=index;i<nums.length;i++){
            if (flag[i]==0){
                //index ++ ;
                flag[i]=1;
                for (int j = index+1;j<nums.length;j++){
                    if (nums[j]==nums[i]-1||nums[j]==nums[i]+1)
                        flag[j] = 1;
                }
                s = Math.max(score(nums,flag,index+1,count+nums[i]),score(nums,flag2,index+1,count));
            }
            else
                s = score(nums,flag,index+1,count);
        }
        return s;
    }

    //DP
    public static int solution2(int[] nums){
        int[] count = new int[10002];
        for (int i=0;i<nums.length;i++){
            count[nums[i]] += nums[i];
        }
        int take = 0,skip = 0; //take[i]表示取了i下标元素的最大值,skip[i]表示没有取i元素的最大值
        for (int i=1;i<10002;i++){
            int take_i = count[i] + skip;
            int skip_i = Math.max(take,skip);
            take = take_i;
            skip = skip_i;
        }
        return Math.max(take,skip);
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
