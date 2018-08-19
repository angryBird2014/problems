package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class 巧克力 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for (int i=0;i<n;i++)
            h[i] = in.nextInt();
        int m = in.nextInt();
        int[] w = new int[m];
        for (int i=0;i<m;i++)
            w[i] = in.nextInt();
        Arrays.sort(h);
        Arrays.sort(w);
        int count = 0;
        for (int i=0,j=0;i<w.length;i++){
            if (w[i]<h[j])
                continue;
            else {
                count ++ ;
                j++;
                if (j==h.length)
                    break;
            }
        }
        System.out.println(count);
    }
}
