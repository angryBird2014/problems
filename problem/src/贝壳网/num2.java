package 贝壳网;

import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p1= in.nextInt();
        int p2 = in.nextInt();
        int p3 = in.nextInt();
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int s = 0;
        int[] diff = new int[n];
        int start = 0,end = 0;
        for (int i=0;i<n;i++){
            start = in.nextInt();
            diff[i] = start - end;
            end = in.nextInt();
            s += (end-start) * p1;
            if (i!=0){
                if (diff[i]<=t1) //未息屏
                    s += diff[i] * p1;
                else if (diff[i]<=t1+t2) //息屏未睡眠
                    s += t1 * p1 + (diff[i]-t1) * p2;
                else
                    s += t1 * p1 + t2 * p2 + (diff[i]-t1-t2) * p3;
            }
        }
        System.out.println(s);
    }
}
