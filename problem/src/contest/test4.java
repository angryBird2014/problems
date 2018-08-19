package contest;

import java.util.Arrays;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        //int max = 0;
        char[] array = s.toCharArray();
        int[] dp = new int[array.length];
        Arrays.fill(dp,0);
        int max= dp[0];
        for (int i=1;i<array.length;i++){
            if (i<=dp[i-1]){
                int start = i+dp[i-1];
                int end = i+2*dp[i-1];
                if (start<array.length && end<array.length){
                    if (array[start]!=array[end])
                        dp[i] = dp[i-1]-1;
                    else
                        dp[i] = dp[i-1];
                }
            }
            else
                dp[i] = 0;

            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
