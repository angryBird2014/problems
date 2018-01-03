package leetcode;

/**
 * Created by xyan on 1/3/18.
 */
//递归解法
public class combinationSum4 {
    public static int solution(int[] nums,int target) {
        if (target == 0)
            return 1;
        int result = 0;
        for(int i=0;i<nums.length;i++)
            if (target-nums[i]>=0)
                result += solution(nums,target-nums[i]);
        return result;
    }

    public static int solution2(int[] nums,int target){
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<target+1;i++){
            for (int j=0;j<nums.length;j++){
                if (i>=nums[j])
                    dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1,2,3},4));
    }
}
