package jianzhi;

import java.util.ArrayList;

/**
 * Created by xyan on 12/19/17.
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> solution(int[] array,int sum){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int value1,value2,multiply=99999999;
        int small = 0,big = array.length-1;
        while (small<big){
            int s = array[small] + array[big];
            if (s == sum){
                if (array[small]*array[big] <= multiply){

                    value1 = array[small];
                    value2 = array[big];
                    arrayList.add(value1);
                    arrayList.add(value2);
                    multiply = array[small] * array[big];
                }
                small++;
                big--;
            }
            else if (s<sum){
                small ++;
            }
            else
                big--;
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,5,5,7,10,11,16};
        ArrayList<Integer> arrayList = solution(array,10);
        System.out.println(arrayList.get(0)+" "+arrayList.get(1));
    }
}
