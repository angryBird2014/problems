package pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class number3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            int k = scan.nextInt();
            char[] numbers = scan.next().toCharArray();
            int[] count = new int[10];
            for (int i=0;i<n;i++) {
                if(count[numbers[i]]++>=k){
                    System.out.println("0");
                    System.out.println(numbers.toString());
                }
            }
            for (int i=0;i<n;i++){
                //暴力循环
                int gap = k-i;
                int[] result = new int[numbers.length];
                System.arraycopy(numbers,0,result,0,numbers.length);
                for (int j=0;j<result.length;j++){

                }

            }

        }


    }
}
