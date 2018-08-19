package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class 字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] lines = in.nextLine().toCharArray();
        int n = lines.length/4;
        char[][] result = new char[n+1][n+1];
        for (int i=0;i<result.length;i++)
            Arrays.fill(result[i],' ');
        int j = 0;
        for (int i=0;i<n;i++){
            //上
            result[0][i] = lines[j++];
        }
        //右
        for (int i=0;i<n;i++)
            result[i][n] = lines[j++];
        for (int i=n;i>=1;i--)
            result[n][i] = lines[j++];
        for (int i=n;i>=1;i--)
            result[i][0] = lines[j++];
        for (int i=0;i<=n;i++){
            System.out.println(result[i]);
        }

    }
}
