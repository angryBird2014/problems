package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/26/17.
 */
//尝试将每个元素放入group
public class canPartitionKSubsets {
    public static boolean solution(int[] nums,int k){
        if (k==1)
            return true;
        int sum = Arrays.stream(nums).sum();
        int target = sum/k;
        if (sum % k!=0)
            return false;
        Arrays.sort(nums);
        int row = nums.length-1;
        if (nums[row]>target) return false;
        while (row >= 0 && nums[row]==target){
            k--;
            row--;
        }
        return search(new int[k],row,nums,target);

    }

    public static boolean search(int[] groups,int index,int[] nums,int target){
        if (index<0)
            return true;
        //尝试讲num[index]放入group中，所以遍历group
        for (int i=0;i<groups.length;i++){
            int ele = nums[index];
            if (groups[i]+ele <= target){
                groups[i]+= ele;
                if (search(groups,index-1,nums,target)) //递归遍历后面的元素
                    return true;
                groups[i]-=ele;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 3, 5, 2, 1},4));
    }
}
