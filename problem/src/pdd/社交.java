package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class 社交 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        boolean mp[][] = new boolean[n][n];
        for (int i=0;i<mp.length;i++)
            Arrays.fill(mp[i],false);
        in.nextLine();
        for (int i=0;i<n;i++){
            String[] line = in.nextLine().split(" ");
            int[] numbers = new int[line.length];
            for (int k=0;k<line.length;k++)
                numbers[k] = Integer.valueOf(line[k]);
            for (int j=0;j<numbers.length;j++)
                mp[i][numbers[j]] = true;
            mp[i][i] = true;
        }
        int user = -1;
        int maxfriend = 0;
        for(int i = 0; i < n; ++ i)
        {
            if(i == s || mp[s][i]) continue;
            int countfriend = 0;
            for(int j = 0; j < n; ++ j)
            {
                if(mp[i][j] && mp[s][j]) ++ countfriend;
            }

            if(countfriend > maxfriend) {
                maxfriend = countfriend;
                user = i;
            }
        }
        System.out.println(user);
    }
}
