package leetcode;

import sun.nio.cs.ext.MacArabic;

/**
 * Created by xyan on 12/22/17.
 */
public class maxProfit {
    public static int solution(int[] prices){
        if (prices.length==0||prices.length==1)
            return 0;
        int profile = Integer.MIN_VALUE;
        //int maxValue = Integer.MIN_VALUE;
        int minValue = prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]<minValue)
                minValue = prices[i];
            else if (prices[i]-minValue > profile){
                profile = prices[i]-minValue;
                //maxValue = prices[i];
            }
        }
        if (profile==Integer.MIN_VALUE)
            return 0;
        return profile;
    }

    public static  int solution2(int[] prices){
        if (prices==null || prices.length==0)
            return 0;
        int max_value = 0;
        for (int i=1;i<prices.length;i++)
            if (prices[i]>prices[i-1])
                max_value += prices[i]-prices[i-1];
        return max_value;

    }

    public static int solution3(int[] prices){
        if (prices==null || prices.length<2)
            return 0;
        int[] f = new int[prices.length];
        int[] g = new int[prices.length];
        int min_value = prices[1];
        for (int i=1;i<prices.length;i++){
            min_value = Math.min(min_value,prices[i]);
            f[i] = Math.max(f[i-1],prices[i]-min_value);
        }
        int max_value = prices[prices.length-1];
        for (int i =prices.length-2;i>=0;i--){
            max_value = Math.max(max_value,prices[i]);
            g[i] = Math.max(g[i],max_value-prices[i]);
        }
        int profile = 0;
        for (int i=0;i<prices.length;i++)
            profile = Math.max(profile,f[i]+g[i]);
        return profile;
    }

    public static void main(String[ ] args) {
        System.out.println(solution3(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
