package leetcode;

public class numDistinct {
    public int solution(String s,String t){
        if (s==null || s.length()==0 || t == null || t.length()==0)
            return 0;
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i=0;i<s.length()+1;i++){
            dp[0][i] = 1;
        }
        for (int i=1;i<t.length()+1;i++){
            for (int j=1;j<s.length()+1;j++){
                if (s.charAt(j-1)==t.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new numDistinct().solution("","bag"));
    }
}
