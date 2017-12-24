package jianzhi;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by xyan on 12/16/17.
 */
public class GetUglyNumber_Solution {

    public static int solution(int index){
        int number = 0,i = 0 ;
        while (i<index) {
            number++;
            i += ugly_number(number);

        }
        System.out.println(number);
        return number;
    }
    public static int ugly_number(int number){
            while (number%2==0)
                number = number/2;
            while (number%3==0)
                number = number/3;
            while (number%5==0)
                number = number/5;
            if (number==1)
                return 1;
            return 0;
        }

    //保存一个排好序的丑数数组，丑数必定是以前的丑数乘以2,3,5而得到的,动态规划的一种解法
    public static int solution2(int index){
        if(index < 7)return index;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++){
            int tmp = Math.min(arrayList.get(t2)*2,Math.min(arrayList.get(t3)*3,arrayList.get(t5)*5));
            arrayList.add(tmp);
            //i++;
            if (arrayList.get(i)==arrayList.get(t2)*2)
                t2++;
            if (arrayList.get(i) == arrayList.get(t3)*3)
                t3++;
            if (arrayList.get(i) == arrayList.get(t5)*5)
                t5++;
        }
        //System.out.println(arrayList.get(index-1));
        return arrayList.get(index-1);
    }

    public static void main(String[] args) {
        solution2(7);
    }
}

