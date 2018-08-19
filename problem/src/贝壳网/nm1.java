package 贝壳网;

import java.util.Arrays;
import java.util.Scanner;

public class nm1 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i=0;i<n;i++)
            numbers[i] = in.nextInt();
        int s = 0;


        int[] chazhi = new int[n];
        for (int i=1;i<numbers.length;i++)
            chazhi[i] = numbers[i] - numbers[i-1];
        for (int i=1;i<chazhi.length;i++)


        System.out.println(s);
    }
}
