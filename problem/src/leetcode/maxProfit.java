package leetcode;

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

    public static void main(String[] args) {
        solution(new int[]{1});
    }
}
