package leetcode;

import java.util.Arrays;

public class productExceptSelf {

    public int[] solution(int[] nums){
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1;i<nums.length;i++)
            res[i] = res[i-1]*nums[i-1]; //res[i]表示[0,i)的乘积
        int right = 1;
        for (int i = nums.length-1;i>=0;i--){
            res[i] *= right;
            right *= nums[i];  //right表示[n-1,i)的乘积
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new productExceptSelf().solution(new int[]{1,2,3,4})));
    }
}
