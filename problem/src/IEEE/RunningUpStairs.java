package IEEE;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xyan on 10/14/17.
 */
public class RunningUpStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        BigInteger sum = new BigInteger("0");
        BigInteger a ;
        BigInteger b;
         for (int i =0 ;i< t;i++){

            int n = in.nextInt();
            if (n==1){
                System.out.println(1);
                continue;
            }
            else if (n==2){
                System.out.println(2);
                continue;
            }
            else {

                a = new BigInteger("1");
                b = new BigInteger("2");
                for (int j=3;j<=n;j++){
                    sum = a.add(b);
                    a =b;
                    b = sum;
                }
                System.out.println(sum);
            }
        }


    }
}
