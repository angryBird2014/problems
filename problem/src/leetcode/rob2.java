package leetcode;

public class rob2 {
    public int solution(int[] nums){
        if(nums==null || nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];dp[1] = Math.max(nums[0],nums[1]);
        int max = dp[1];

        max = Math.max(max,Math.max(findSolution(nums,1,nums.length),findSolution(nums,0,nums.length-1)));
        return max;
    }

    public int findSolution(int[] nums,int start,int end){ //左闭右开
        if (end-start<=1)
            return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        int max = dp[start+1];
        for (int i= start+2;i<end;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new rob2().solution(new int[]{1,2,3,1}));
    }
}
