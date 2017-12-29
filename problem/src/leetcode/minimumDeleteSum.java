package leetcode;

/**
 * Created by xyan on 12/29/17.
 */
public class minimumDeleteSum {
    //dp[i][j]表示s1前i个字符和s2前j个字符相等时所要删除的字符的累计ascii值
    public static int solution(String s1,String s2){
        int m = s1.length(),n=s2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<m+1;i++){
            dp[i][0] = dp[i-1][0]+(int)s1.charAt(i-1);
        }
        for (int j=1;j<n+1;j++)
            dp[0][j] = dp[0][j-1]+(int)s2.charAt(j-1);
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j]+(int)s1.charAt(i-1),dp[i][j-1]+(int)s2.charAt(j-1));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(solution("delete","leet"));
    }
}
