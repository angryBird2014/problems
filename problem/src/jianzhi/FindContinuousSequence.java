package jianzhi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by xyan on 12/19/17.
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> solution(int sum){
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int small = 1,big = 2;
        while (small < (1+sum)/2){
            int s = (big-small+1)*(small+big)/2;
            if(s==sum){
                ArrayList<Integer> array = new ArrayList<>();
                for(int i=small;i<=big;i++)
                    array.add(i);
                arrayList.add(array);
                small++;
                big++;
            }
            else if (s<sum){
                big = big + 1;
            }
            else
                small = small +1;

        }
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList = solution(1);
        Iterator<ArrayList<Integer>> it =  arrayList.iterator();
        while (it.hasNext()){
            ArrayList<Integer> array = it.next();
            Iterator<Integer> item = array.iterator();
            String s = "";
            while (item.hasNext())
                s += item.next()+" ";
            System.out.println(s);
        }
    }
}
