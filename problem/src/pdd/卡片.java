package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class 卡片 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] numbers = new int[100];
        int[][] dp = new int[2][100];
        int[] up = new int[100];
        int[] down = new int[100];
        boolean[] visit = new boolean[100];

        Arrays.fill(visit, false);

        for (int i = 0; i < n; ++i) {
            numbers[i] = in.nextInt();
        }
        int novisseq = n;
        int counttimes = 0;
        while (novisseq > 0) {
            ++counttimes;
            for (int i = 0; i < n; ++i) {
                dp[0][i] = 1;
                dp[1][i] = 1;
                up[i] = i;
                down[i] = i;
            }

            for (int i = 0; i < n; ++i) {
                if (visit[i]) continue;
                int maxlastup = 0;
                int maxlastupindex = -1;
                int maxlastdown = 0;
                int maxlastdownindex = -1;
                for (int j = 0; j < i; ++j) {
                    if (visit[j]) continue;
                    if (numbers[i] > numbers[j] && dp[0][j] >= maxlastup) {   // up
                        maxlastup = dp[0][j];
                        maxlastupindex = j;
                    }
                    if (numbers[i] < numbers[j] && dp[1][j] >= maxlastdown) {   // down
                        maxlastdown = dp[1][j];
                        maxlastdownindex = j;
                    }
                }

                if (-1 != maxlastupindex) {
                    dp[0][i] = dp[0][maxlastupindex] + 1;
                    up[i] = maxlastupindex;
                }
                if (-1 != maxlastdownindex) {
                    dp[1][i] = dp[1][maxlastdownindex] + 1;
                    down[i] = maxlastdownindex;
                }
            }

            int maxuplen = 0;
            int maxupindex = -1;
            int maxdownlen = 0;
            int maxdownindex = -1;
            for (int i = 0; i < n; ++i) {
                if (visit[i]) continue;
                if (dp[0][i] >= maxuplen) {
                    maxuplen = dp[0][i];
                    maxupindex = i;
                }
                if (dp[1][i] >= maxdownlen) {
                    maxdownlen = dp[1][i];
                    maxdownindex = i;
                }
            }

            if (maxuplen >= maxdownlen) {
                int iindex = maxupindex;
                int ivalue = up[maxupindex];
                while (iindex != ivalue) {
                    visit[iindex] = true;
                    --novisseq;
                    iindex = ivalue;
                    ivalue = up[iindex];
                }
                visit[iindex] = true;
                --novisseq;
            } else {
                int iindex = maxdownindex;
                int ivalue = down[maxdownindex];
                while (iindex != ivalue) {
                    visit[iindex] = true;
                    --novisseq;
                    iindex = ivalue;
                    ivalue = down[iindex];
                }
                visit[iindex] = true;
                --novisseq;
            }
        }
        System.out.println(counttimes);
    }

}
