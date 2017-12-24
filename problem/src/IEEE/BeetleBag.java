package IEEE;

import java.util.Scanner;

/**
 * Created by xyan on 10/15/17.
 */
public class BeetleBag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++){
            int[][] dp = new int[205][505];
            int c = in.nextInt();
            int n = in.nextInt();
            int[][] object = new int[n][2];
            for (int j = 0;j<n;j++){
                object[j][0] = in.nextInt();
                object[j][1] = in.nextInt();
            }
            for (int j =0;j<n;j++){  //n表示物品个数
                for (int k = 0;k<c;k++){ //c表示能剩余最大空间
                    if (j==0 || k==0){
                        dp[j][k] = 0;
                    }
                    else {
                        int value = object[j][1];
                        int weight = object[j][0];
                        if (k<weight){
                            dp[j][k] = dp[j-1][k];
                        }
                        else
                            dp[j][k]=Math.max(dp[j-1][k-weight]+value,dp[j-1][k]);
                        }
                    }
                }
            System.out.println(dp[n-1][c-1]);
            }
        }

}
