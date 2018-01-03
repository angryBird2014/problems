package leetcode;

/**
 * Created by xyan on 12/31/17.
 */
public class numberOfArithmeticSlices {
    public static int solution(int[] A){
        if (A.length==0||A.length==1)
            return 0;
        int[] dp = new int[A.length];
        dp[0]= 0;
        dp[1] = 0;

        for (int i=2;i<A.length;i++){
            if (A[i]-A[i-1]==A[i-1]-A[i-2])
                dp[i] = dp[i-1]+1;
        }
        int s = 0;
        for (int i=0;i<dp.length;i++)
            s += dp[i];
        return s;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }
}
