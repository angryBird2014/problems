package leetcode;

import java.util.Arrays;

/**
 * Created by xyan on 12/27/17.
 */
public class countSubstrings {


    //动态规划
    public static int solution2(String s){
        int[] dp = new int[s.length()]; //以index结尾的字符串共有多少个回文串
        int[] count = new int[s.length()];
        Arrays.fill(dp,1);
        //dp[0] = 1;
        for (int i=0;i<s.length();i++){
            int tmp = 0;
            for (int j=0;j<=i;j++){
                tmp += isPerli(s.substring(j,i+1));
            }
            count[i] = tmp;
        }

        for (int i=1;i<dp.length;i++){
            dp[i] = dp[i-1]+count[i];
        }
        return dp[s.length()-1];
    }

    //递归解法
    public static int solution(String s){
        if (s==null)
            return 0;
       return search(s,s.length());
    }
    public static int search(String s,int index){
        if (index==1)
            return 1;
        return search(s,index-1)+1+isPerli(s.substring(0,index));

    }
    public static int isPerli(String s){
        boolean flag = true;
        for (int i=0;i<=s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
                flag = false;
                break;
            }
        }
        return flag==true?1:0;
    }

    public static void main(String[] args) {
        System.out.println(solution2("aaa"));
    }
}
