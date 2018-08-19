package leetcode;

public class isInterleave {
    public boolean solution(String s1,String s2,String s3){
        if (s1==null && s2==null && s3==null)
            return true;
        if ((s1 == null || s2 ==null) && s3==null)
            return false;
        if (s1.length()+s2.length()!=s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i=1;i<s1.length()+1;i++)
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for (int j=1;j<s2.length()+1;j++)
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        for (int i=1;i<s1.length()+1;i++){
            for (int j=1;j<s2.length()+1;j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j)) ||
                        (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new isInterleave().solution("","dbbca","dbbca"));
    }
}
