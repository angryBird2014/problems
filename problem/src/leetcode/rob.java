package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/22/17.
 */
public class rob {
    public static int solution(int[] nums){
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] maxPrice = new int[nums.length];
        maxPrice[0] = nums[0];
        maxPrice[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            maxPrice[i] = 0;
            for (int j=0;j<=i-2;j++){
                if (maxPrice[j]+nums[i]>maxPrice[i]){
                    maxPrice[i] = maxPrice[j]+nums[i];
                }
            }
        }
        Arrays.sort(maxPrice);
        System.out.println(maxPrice[maxPrice.length-1]);
        return maxPrice[maxPrice.length-1];
    }

    //动态规划
    public static int solution2(int[] nums){
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] maxprice = new int[nums.length];
        maxprice[0] = nums[0];
        maxprice[1] = Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            int rob = maxprice[i-2]+nums[i];
            int norob = maxprice[i-1];
            maxprice[i] = Math.max(rob,norob);
        }
        System.out.println(maxprice[nums.length-1]);
        return maxprice[nums.length-1];
    }

    public static void main(String[] args) {
        solution2(new int[]{1,2,3,4,5,6,7,8});
    }
}
