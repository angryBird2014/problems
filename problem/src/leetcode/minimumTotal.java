package leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xyan on 12/23/17.
 */
public class minimumTotal {
    public static int solution(List<List<Integer>> triangle){

        int n = triangle.size();
        if (n==0)
            return 0;
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i=1;i<n;i++)
            dp[i] = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for (int j=i;j>=0;j--){
                if (j==0)
                    dp[j] = dp[j]+triangle.get(i).get(j);
                else
                    dp[j] = Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[0]);
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> totol = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();
        List<Integer> l4 = new LinkedList<>();
        List<Integer> l5 = new LinkedList<>();

        l1.add(2);
        l2.add(3);l2.add(4);
        l3.add(6);l3.add(5);l3.add(7);
        l4.add(4);l4.add(1);l4.add(8);l4.add(3);

        totol.add(l1);totol.add(l2);totol.add(l3);totol.add(l4);
        solution(totol);

    }
}
