package leetcode;

/**
 * Created by xyan on 12/29/17.
 */
public class maxProduct {
    public static int solution(int[] nums){
        if (nums.length==0)
            return 0;
        int max = nums[0],min = nums[0],totalMax = nums[0];
        for (int i=1;i<nums.length;i++){
            int tmpMax = nums[i]*max;
            int tmpMin = nums[i]*min;
            max = Math.max(Math.max(tmpMax,tmpMin),nums[i]);
            min = Math.min(Math.min(tmpMax,tmpMin),nums[i]);
            totalMax = Math.max(max,totalMax);
        }
        return totalMax;

    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2,3,-2,4}));
    }
}
