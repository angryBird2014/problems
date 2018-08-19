package leetcode;

public class minDistance {
    public int solution(String word1,String word2){
        if((word1==null || word1.length()==0) && (word2==null || word2.length()==2))
            return 0;
        if (word1.length()==0 && word2.length()!=0)
            return word2.length();
        if (word2.length()==0 && word1.length()!=0)
            return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for (int j=0;j<dp[0].length;j++)
            dp[0][j] = j;
        int min_value = Integer.MAX_VALUE;
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new minDistance().solution("","execution"));
    }
}
