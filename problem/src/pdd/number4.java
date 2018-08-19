package pdd;

import com.sun.tools.javac.code.Attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class number4 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);

        String[] result = in.nextLine().split(" ");
        int[] numbers = new int[result.length];
        int s = 0;
        for(int i=0;i<result.length;i++){
            numbers[i] = Integer.valueOf(result[i]);
            s+= numbers[i];
        }
        if (s<=300)
            System.out.println(1);
        else {
            s = 0;
            Arrays.sort(numbers);//升序
            int count = 0;
            for (int i =0;i<numbers.length;i++){
                s += numbers[i];
                if (s>300){
                    count++;
                    s = numbers[i];
                }
            }
            System.out.println(count);
        }

    }

}
