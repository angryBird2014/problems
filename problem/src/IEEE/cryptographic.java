package IEEE;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Created by xyan on 10/14/17.
 */
public class cryptographic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt();
        HashMap<Character,Double> dict = new HashMap<>();
        for(int i=0;i<26;i++){
            char key = in.next().toCharArray()[0];
            double value = in.nextDouble();
            dict.put(key,value);
        }


        String useless = in.nextLine();
        String text = in.nextLine();
        double sum = radius;



        text = text.toUpperCase();
        StringBuilder str = new StringBuilder();
        for (int i=0;i<text.length()-1 ;i++){
            if (text.charAt(i)<'A' || text.charAt(i)>'Z'){
                continue;
            }
            str.append(text.charAt(i));
        }

        for(int i= 1;i<str.length();i++){
            char first =str.charAt(i-1);
            char last = str.charAt(i);
            sum += cal(first,last,radius,dict);
        }
        System.out.println(Math.round(sum));

    }

    public static double cal(char first,char last,int radius,HashMap<Character,Double> map){

        double tmp;
        double Max = Math.max(map.get(first),map.get(last));
        double Min = Math.min(map.get(first),map.get(last));

        if (Max-Min>180)
            tmp = Math.toRadians((360-(Max-Min))/2);
        else if ((Max - Min)<180)
            tmp = Math.toRadians((Max-Min)/2);
        else
            return 2*radius;

        return Math.sin(tmp)*radius*2;


    }

}
