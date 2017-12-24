package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by xyan on 12/16/17.
 */
public class PrintMinNumber {
    public static String solution(int[] numbers){
        String result = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            arrayList.add(numbers[i]);
        }

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1.toString() + str2.toString();
                String s2 = str2.toString() + str1.toString();
                return s1.compareTo(s2);
            }
        });

        for(int i=0;i<arrayList.size();i++)
            result += arrayList.get(i);
        //System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        solution(new int[]{3,32,321});
    }

}
