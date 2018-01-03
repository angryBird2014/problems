package leetcode;

/**
 * Created by xyan on 1/3/18.
 */
public class countBits {
    public static int[] solution(int num){
        int[] dp = new int[num+1];
        dp[0]=0;

        for (int i=1;i<num+1;i++){
            dp[i] = dp[i&i-1]+1; //这太厉害了，相&求得不连续的数值!!!
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] dp = solution(5);
        for (int i=0;i<dp.length;i++)
            System.out.println(dp[i]);
        System.out.println(solution(5));
    }
}
