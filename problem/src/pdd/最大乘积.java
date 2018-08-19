package pdd;

import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class 最大乘积 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long[] numbers = new long[n];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextLong();
        long max1 = 1,max2 = 1,max3 = 1,min1 = 1,min2 = 1;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i] != 0){
                if (numbers[i] > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = numbers[i];
                }
                else if (numbers[i] > max2){
                    max3  = max2;
                    max2 = numbers[i];
                }
                else if (numbers[i] > max3){
                    max3 = numbers[i];
                }
                else if (numbers[i] < min1){
                    min2 = min1;
                    min1 = numbers[i];
                }
                else if (numbers[i] < min2 && numbers[i] > min1){
                    min2 = numbers[i];
                }
            }
        }
        System.out.println(Math.max(max1*max2*max3,min1*min2*max1));
    }
}
